package morphy.examples;

import morphy.annotations.*;

import javax.swing.*;
import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

// Example of datamorphic test specification for testing a classifier.

public class TwoImageRandomTesting extends TwoImageDatamorphsims{
	
	Random randomGenerator = new Random();
	String image = "Original";
	
	@TestSetContainer(
			inputTypeName = "TwoImage",
			outputTypeName = "Double"
			)
	public TestPool<TwoImage, Double> testSuite = new TestPool<TwoImage, Double>();

	@MakeSeed
	public void configPaths() {
		String directory = System.getProperty("user.dir");
		JFileChooser fileChooser = new JFileChooser(directory);
		String location = "";
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("Set SeetaFace Directory");
		if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			location = file.getPath();
			ImageConfig.setSeetaFacePath(location);
		}
		fileChooser.setDialogTitle("Set Image Directory");
		if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			location = file.getPath();
			ImageConfig.setImagePath(location);
		}
	}
	
	@MakeSeed
	public void randomSelectOriginalImages(){
		String numStr = JOptionPane.showInputDialog("Entering the number of test cases or \"all\":");
		String[] fileList;
		if (numStr==null) { return;}
		if (numStr.equals("all")) {
			fileList = getFileListAll();
		}else {
			int numTestCases = Integer.valueOf(numStr);
			fileList = getFileList(numTestCases);
		}
		for (String name: fileList) {
			TwoImage input = new TwoImage(ImageConfig.imagePath, image + "\\" + name, image + "\\" + name);
			testSuite.addInput(input);
		}
	};
	
	@MakeSeed
	public void randomSelectImagePairs(){
		String numStr = JOptionPane.showInputDialog("Entering the number of test cases:");
		if (numStr==null) { return;};
		int numTestCases = Integer.valueOf(numStr);
		String[] fileList = getFileListAll();
		Random randomGenerator = new Random();
		for (int i=0; i<numTestCases; i++) {
			int x = randomGenerator.nextInt(fileList.length);
			int y = randomGenerator.nextInt(fileList.length);
			String name1 = fileList[x];
			String name2 = fileList[y];
			TwoImage input = new TwoImage(ImageConfig.imagePath, image + "\\" + name1, image +"\\"+ name2);
			testSuite.addInput(input);
		}
	};

	@Analyser
	public void statisticalAnalysis() {
		// mapping: test case type --> list of mutants 
		HashMap<String, List<TestCase<TwoImage, Double>>> resMutant = new HashMap<>();
		resMutant.put("Original", new ArrayList<TestCase<TwoImage, Double>>());
		for (TestCase<TwoImage, Double> x : testSuite.testSet) {
			if (x.feature == TestDataFeature.original) {
				resMutant.get("Original").add(x);
			}else {
				if (!resMutant.keySet().contains(x.getType())) {
					resMutant.put(x.getType(), new ArrayList<TestCase<TwoImage, Double>>());
				}
				resMutant.get(x.getType()).add(x);
			};
		};
		//mapping: test case Id --> list of scores
		HashMap<String, List<Double>> resScore = new HashMap<>();
		// order of mutant types in the list of scores
		List<String> tableHeading = new ArrayList<String>();
		//Score of seed test cases is the first in the list
		tableHeading.add("Original");
		for (TestCase<TwoImage, Double> x: resMutant.get("Original")) {
			resScore.put(x.id, new ArrayList<Double>());
			resScore.get(x.id).add(x.output);
		}
		for (String type: resMutant.keySet()) {
			if (type.equals("Original")) { continue;}; 
			tableHeading.add(type);
			for (TestCase<TwoImage, Double> x : resMutant.get(type)) {
				resScore.get(x.getOrigins().get(0)).add(x.output);
			}
		}
		//add the average scores of the mutants for each original test case at the end 
		tableHeading.add("Avg");
		for (String tcId : resScore.keySet()) {
			double avg = resScore.get(tcId).stream().mapToDouble(Double::doubleValue).average().getAsDouble();
			resScore.get(tcId).add(avg);
		};
		// Convert score list into string and save to file
		SaveExpResults saver = new SaveExpResults();
		String headLine = "Test Case Id, Target Image, Subject Image, ";
		saver.saveData(headLine + tableHeading.toString().substring(1).replace("]", ""));
		for (TestCase<TwoImage, Double> x: resMutant.get("Original")) {
			String line = x.id +","
			 + x.input.i1.split(Pattern.quote("\\"))[1] + ","
			 + x.input.i2.split(Pattern.quote("\\"))[1] +",";
			saver.saveData(line +resScore.get(x.id).toString().substring(1).replace("]", ""));
		}
		//Calculate the average score for each type of mutants and save the results
		String tailLine = "Average, , , ";
		for (String type : tableHeading) {
			if (type.equals("Avg")) {continue;}
			tailLine += resMutant.get(type).stream().mapToDouble(x -> x.output).average().getAsDouble() +",";
		}
		saver.saveData(tailLine);
	}
	
	@Analyser
	public void viewStatistics() {
		int numTC = testSuite.testSet.size();
		int numOriginalTC = 0;
		int numMutantTC = 0;
		HashMap<String, List<Double>> resMutant = new HashMap<>();
		for (TestCase<TwoImage, Double> x : testSuite.testSet) {
			if (x.feature == TestDataFeature.original) {
				numOriginalTC++;
			}else {
				numMutantTC++;
				if (!resMutant.keySet().contains(x.getType())) {
					resMutant.put(x.getType(), new ArrayList<Double>());
				}
				resMutant.get(x.getType()).add(x.output);
			};
		};
		String message = "Statistics:\n";
		message = message + "Total number of test cases = " + numTC + "\n";
		message = message + "Number of original test cases = "+ numOriginalTC + "\n";
		message = message + "Number of mutant test cases = " + numMutantTC + "\n";
		for (String type: resMutant.keySet()) {
//			message = message + " -- " + type + " mutants = " + resMutant.get(type).size() +"\n";
			Double avg = resMutant.get(type).stream().mapToDouble(Double::doubleValue).average().getAsDouble();
			message = message + " -- " + type + " avg = " + avg +"\n";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	private String[] getFileList(int size) {
		Random randomGenerator = new Random();
		File file = new File(ImageConfig.imagePath + "\\" + image);
		String[] res = new String[size];
		String[] fNames = file.list();
		for (int i=0; i<size; i++) {
			int x = randomGenerator.nextInt(fNames.length);
			res[i]=fNames[x];
		}
		return res;
	}
	
	private String[] getFileListAll() {
		File file = new File(ImageConfig.imagePath + "\\" + image);
		String[] fNames = file.list();
		return fNames;
	}
}
