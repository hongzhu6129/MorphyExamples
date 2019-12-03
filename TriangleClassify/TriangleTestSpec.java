package morphy.examples;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import morphy.annotations.*;

public class TriangleTestSpec { 

	@TestSetContainer(
			inputTypeName = "Triangle",
			outputTypeName = "TriangleType"
			)
	public TestPool<Triangle, TriangleType> testSuite = new TestPool<Triangle, TriangleType>();
	
	@MakeSeed
	public void makeSeeds(){
		testSuite.addInput(new Triangle(5,5,5));
		testSuite.addInput(new Triangle(5,5,7));
		testSuite.addInput(new Triangle(5,7,9));
		testSuite.addInput(new Triangle(3,5,9));
	}
	
	public TestPool<Triangle, TriangleType> expected = new TestPool<Triangle, TriangleType>();
	
	@MakeSeed
	public void makeSeedsWithExpectedOutput(){
		Triangle trg;
		TestCase<Triangle, TriangleType> tc;
		
		trg = new Triangle(5,5,5); 
		tc = new TestCase<Triangle, TriangleType>(); 
		tc.input = trg;
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tc.output = TriangleType.equilaterial;
		expected.addTestCase(tc);
		
		trg = new Triangle(5,5,7); 
		tc = new TestCase<Triangle, TriangleType>(); 
		tc.input = trg;
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tc.output = TriangleType.isoscelene;
		expected.addTestCase(tc);

		trg = new Triangle(5,7,9); 
		tc = new TestCase<Triangle, TriangleType>(); 
		tc.input = trg;
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tc.output = TriangleType.scalene;
		expected.addTestCase(tc);
		
		trg = new Triangle(3,5,9); 
		tc = new TestCase<Triangle, TriangleType>(); 
		tc.input = trg;
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tc.output = TriangleType.noneTriangle;
		expected.addTestCase(tc);
	}
	
	@MakeSeed
	public void manualInputTestCases(){
		Triangle trg;
		TestCase<Triangle, TriangleType> tc; 
		String numStr; 
		while (true) {
			tc = new TestCase<Triangle, TriangleType>();;
			trg = new Triangle(); 
			numStr = JOptionPane.showInputDialog("Entering a new test case. \nPlease input a real number as the length of side x:");
			if (numStr==null) { break;}
			trg.x	= Integer.valueOf(numStr);
			numStr = JOptionPane.showInputDialog("Please input a real number as the length of side y:");
			if (numStr==null) { break;}
			trg.y	= Integer.valueOf(numStr);
			numStr = JOptionPane.showInputDialog("Please input a real number as the length of side z:");
			if (numStr==null) { break;}
			trg.z	= Integer.valueOf(numStr);
			tc.input = trg;
			tc.setFeature(TestDataFeature.original);
			testSuite.addTestCase(tc);
		}
	}
	
	@MakeSeed
	public void readTestCasesFromFile(){
		Triangle trg;
		TestCase<Triangle, TriangleType> tc;
		String directory = System.getProperty("user.dir");
		JFileChooser fileChooser = new JFileChooser(directory);
		String fileName;
		File file; 
		if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			fileName = file.getName();
		}else {
			return; 
		};
		FileReader fileReader;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e1) {
			return;
		};
		BufferedReader reader = new BufferedReader(fileReader);
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				tc = new TestCase<Triangle, TriangleType>();;
				trg = new Triangle();
				String[] numStrs = line.split(",");
				trg.x=Integer.valueOf(numStrs[0]);
				trg.y=Integer.valueOf(numStrs[1]);
				trg.z=Integer.valueOf(numStrs[2]);
				tc.input = trg;
				tc.setFeature(TestDataFeature.original);
				testSuite.addTestCase(tc);
			}
		} catch (IOException e2) {
			return;
		}
		try {
			reader.close();
		} catch (IOException e) {
			return;
		}
	}
	
	@Metamorphism(
			applicableTestCase="seed",
			message="Match the expected output."
			)
	public boolean matchExpectedOutput(TestCase<Triangle, TriangleType> x) {
		String tcId = x.id;
		TestCase expectedTc = expected.get(tcId);
		return (x.output == expectedTc.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> increaseX(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x+1;
		m.y=seed.input.y;
		m.z=seed.input.z;
		mutant.input = m;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "increaseX",
			message="Increase on Parameter X rule."
			)
	public boolean increaseXRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true;
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType>  increaseY(TestCase<Triangle, TriangleType>  seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x;
		m.y=seed.input.y+1;
		m.z=seed.input.z;
		mutant.input = m; 
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "increaseY",
			message="Increase on Parameter Y rule."
			)
	public boolean increaseYRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true; 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> increaseZ(TestCase<Triangle, TriangleType>  seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x;
		m.y=seed.input.y;
		m.z=seed.input.z+1;
		mutant.input = m; 
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "increaseZ",
			message="Increase on Parameter Y rule."
			)
	public boolean increaseZRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true; 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> decreaseX(TestCase<Triangle, TriangleType>  seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x - 1;
		m.y=seed.input.y;
		m.z=seed.input.z;
		mutant.input = m; 
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "decreaseX",
			message="Decrease on Parameter X rule."
			)
	public boolean decreaseXRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true;
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> decreaseY(TestCase<Triangle, TriangleType>  seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x;
		m.y=seed.input.y-1;
		m.z=seed.input.z;
		mutant.input = m; 
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "decreaseY",
			message="Decrease on Parameter Y rule."
			)
	public boolean decreaseYRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true;
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> decreaseZ(TestCase<Triangle, TriangleType>  seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x;
		m.y=seed.input.y;
		m.z=seed.input.z-1;
		mutant.input = m; 
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "decreaseZ",
			message="Decrease on Parameter Z rule."
			)
	public boolean decreaseZRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		if (originalTc.output == TriangleType.equilaterial){
			return (x.output == TriangleType.isoscelene); 
		};
		return true; 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> swapXY(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.y;
		m.y=seed.input.x;
		m.z=seed.input.z;
		mutant.input = m;
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "swapXY",
			message="Swap X Y rule."
			)
	public boolean swapXYRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		return (originalTc.output == x.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> swapXZ(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.z;
		m.y=seed.input.y;
		m.z=seed.input.x;
		mutant.input = m;
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "swapXZ",
			message="Swap X Z rule."
			)
	public boolean swapXZRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		return (originalTc.output == x.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> swapYZ(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.x;
		m.y=seed.input.z;
		m.z=seed.input.y;
		mutant.input = m;
		return mutant;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "swapYZ",
			message="Swap Y Z rule."
			)
	public boolean swapZYRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		return (originalTc.output == x.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> rotateL(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.y;
		m.y=seed.input.z;
		m.z=seed.input.x;
		mutant.input = m;
		return mutant;
	};
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "rotateL",
			message="Rotate Parameters Leftwards rule."
			)
	public boolean rotateLRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase originalTc = testSuite.get(originalId);
		return (originalTc.output == x.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> rotateR(TestCase<Triangle, TriangleType> seed){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle m = new Triangle(1,1,1);
		m.x=seed.input.z;
		m.y=seed.input.x;
		m.z=seed.input.y;
		mutant.input = m;
		return mutant;
	};
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "rotateR",
			message="Rotate Parameters Rightwards rule."
			)
	public boolean rotateRRule(TestCase<Triangle, TriangleType> x) {
		String originalId = x.getOrigins().get(0);
		TestCase<Triangle, TriangleType> originalTc = testSuite.get(originalId);
		return (originalTc.output == x.output); 
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> copyXToY(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = t.input.x;
		t1.z = t.input.z;
		mutant.input= t1; 
		return mutant; 
	}
	
	@Metamorphism(
		applicableTestCase="mutant",
		applicableDatamorphism="copyXToY",
		message="Copy X to Y rule"
	)
	public boolean copyXtoYRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output==TriangleType.scalene) {
			return (tc.output==TriangleType.isoscelene);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> copyXToZ(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = t.input.y;
		t1.z = t.input.x;
		mutant.input= t1; 
		return mutant; 
	}
	
	@Metamorphism(
		applicableTestCase="mutant",
		applicableDatamorphism="copyXToZ",
		message="Copy X to Z rule"
	)
	public boolean copyXtoZRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output==TriangleType.scalene) {
			return (tc.output==TriangleType.isoscelene);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> copyYToZ(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = t.input.y;
		t1.z = t.input.y;
		mutant.input= t1; 
		return mutant; 
	}
	
	@Metamorphism(
		applicableTestCase="mutant",
		applicableDatamorphism="copyYToZ",
		message="Copy Y to Z rule"
	)
	public boolean copyYtoZRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output==TriangleType.scalene) {
			return (tc.output==TriangleType.isoscelene);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> negateX(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = - t.input.x;
		t1.y = t.input.y;
		t1.z = t.input.z;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negateX",
			message="Negate X rule"
		)
	public boolean negateXRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output!=TriangleType.noneTriangle) {
			return (tc.output==TriangleType.noneTriangle);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> negateY(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = - t.input.y;
		t1.z = t.input.z;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negateY",
			message="Negate Y rule"
		)
	public boolean negateYRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output!=TriangleType.noneTriangle) {
			return (tc.output==TriangleType.noneTriangle);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> negateZ(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = t.input.y;
		t1.z = - t.input.z;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negateZ",
			message="Negate Z rule"
		)
	public boolean negateZRule(TestCase<Triangle, TriangleType> tc) {
		TestCase originalTC = testSuite.get(tc.getOrigins().get(0)); 
		if (originalTC.output!=TriangleType.noneTriangle) {
			return (tc.output==TriangleType.noneTriangle);
		}else {
			return true; 
		}
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> zeroX(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = 0;
		t1.y = t.input.y;
		t1.z = t.input.z;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="zeroX",
			message="Set zero to X rule"
		)
	public boolean zeroXRule(TestCase<Triangle, TriangleType> tc) {
		return (tc.output==TriangleType.noneTriangle);
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> zeroY(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = 0;
		t1.z = t.input.z;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="zeroY",
			message="Set zero to Y rule"
		)
	public boolean zeroYRule(TestCase<Triangle, TriangleType> tc) {
		return (tc.output==TriangleType.noneTriangle);
	}
	
	@Datamorphism
	public TestCase<Triangle, TriangleType> zeroZ(TestCase<Triangle, TriangleType> t){
		TestCase<Triangle, TriangleType> mutant = new TestCase<Triangle, TriangleType>();
		Triangle t1 = new Triangle(1,1,1);
		t1.x = t.input.x;
		t1.y = t.input.y;
		t1.z = 0;
		mutant.input = t1;
		return mutant; 
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="zeroZ",
			message="Set zero to Z rule"
		)
	public boolean zeroZRule(TestCase<Triangle, TriangleType> tc) {
		return (tc.output==TriangleType.noneTriangle);
	}
	
	@Analyser
	public void statisticsOfCorrectness() {
		int numTC = testSuite.testSet.size();
		int numOriginalTC = 0;
		int numMutantTC = 0;
		int numCheckedTC =0;
		int numCorrect =0;
		int numError=0;
		int numFailedTestCases = 0; 
		HashMap<String, Integer> correctnessMap = new HashMap<String, Integer>();
		for (TestCase x : testSuite.testSet) {
			if (x.feature == TestDataFeature.original) { 
				numOriginalTC++;
			}else {
				numMutantTC++;
			};
			if (!x.correctness.equals(null)) {
				String correctness = x.correctness;
				if (correctness.equals("")) continue; 
				numCheckedTC++;
				if (correctness.contains("fail")) {
					numFailedTestCases ++;
				}
				String[] correctnessRecords = correctness.split(";");
				for (String record: correctnessRecords) {
					String key = record.replace("=","<")+">";
					if (correctnessMap.keySet().contains(key) ) {
						int num = correctnessMap.get(key);
						num++;
						correctnessMap.put(key, num);
					}else {
						correctnessMap.put(key, 1);
					}
				}
			}
		};
		String message = "Statistics:\n"; 
		message = message + "Total number of test cases = " + numTC + "\n"; 
		message = message + "Number of original test cases = "+ numOriginalTC + "\n";
		message = message + "Number of mutant test cases = " + numMutantTC + "\n";
		message = message + "Number of test cases checked = " + numCheckedTC + "\n";
		message = message + "Number of test cases failed checking = " + numFailedTestCases + "\n";
		message = message + "Failure Rate = " + ((double)numFailedTestCases/(double)numCheckedTC)*100 + "%\n";
		List<String> keysSorted = new ArrayList<String>();
		for (String key : correctnessMap.keySet()){
			keysSorted.add(key);
		};
		Collections.sort(keysSorted);
		for (String key: keysSorted) {
			message = message + " -- number of " + key + " = " + correctnessMap.get(key) +"\n";
		}
		for (String key : keysSorted) {
			if (key.contains("pass")) {
				numCorrect = numCorrect+correctnessMap.get(key);
			}else {
				numError = numError + correctnessMap.get(key);
			}
		}
		message = message + "Number of times checking passed = " + numCorrect + "\n";
		message = message + "Number of times checking failed = " + numError + "\n";
		message = message + "Failure rate = " + ((double) (numError) / (double) ((numCorrect + numError)))*100 + "%\n";
		JOptionPane.showMessageDialog(null, message);
	}
}
