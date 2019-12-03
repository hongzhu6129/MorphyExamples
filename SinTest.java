package morphy.examples;
import morphy.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import morphy.annotations.Datamorphism;
import morphy.annotations.MakeSeed;
import morphy.annotations.Metamorphism;
import morphy.annotations.TestCase;
import morphy.annotations.TestCaseFilter;
import morphy.annotations.TestCaseMetric;
import morphy.annotations.TestExecuter;
import morphy.annotations.TestPool;
import morphy.annotations.TestSetContainer;
import morphy.annotations.TestSetFilter;
import morphy.annotations.TestSetMetric;

public class SinTest {
	
	@TestSetContainer(
		inputTypeName = "Double",
		outputTypeName = "Double"
	)
	public TestPool<Double, Double> testSuite = new TestPool<Double, Double>();
	
	@TestExecuter
	public Double testSinX(Double x) {
		return Math.sin(x);
	}
	
	@MakeSeed
	public void randomValues(){
		Random randomGenerator = new Random();
		for (int i=0; i<100;i++){
			TestCase<Double, Double> tc = new TestCase<Double,Double>();
			tc.input = randomGenerator.nextDouble()*Math.PI/2;
			tc.feature = TestDataFeature.original;
			tc.setType("randomValues");
			testSuite.addTestCase(tc);
		}
	};
	
	@Datamorphism
	public TestCase<Double,Double> piMinus(TestCase<Double,Double> seed){
		TestCase<Double,Double> mutant = new TestCase<Double,Double>();
		mutant.input = Math.PI - seed.input;
		return mutant; 
	}
	
	@Datamorphism(filter = "tooClose")
	public TestCase<Double,Double> mid(TestCase<Double,Double> x1, TestCase<Double,Double> x2) {
		TestCase<Double,Double> mutant = new TestCase<Double,Double>();
		mutant.input = (x1.input +x2.input)/2;
		return mutant; 
	}
	
	@TestSetMetric
	public double avgDistance() {
		double total =0;
		double num = 0;
		for (TestCase<Double, Double> x: testSuite.testSet ) {
			total += x.input; 
			num++; 
		};
		if (num==0) {return 0;}
		else {return total / num ;}
	}
	
	@TestSetFilter
	public void sparse() {
		List<TestCase> toBeRemovedTCs = new ArrayList<TestCase>();
		int testSetSize = testSuite.testSet.size();
		for (int i=0; i<testSetSize-1; i++) {
			TestCase<Double, Double> x = testSuite.testSet.get(i);
			Double distanceX = null; 
			for (int j=i+1; j<testSetSize; j++) {
				TestCase<Double, Double> y = testSuite.testSet.get(j);
				double distanceXY = Math.abs(x.input - y.input);
				if (distanceX == null) {
					distanceX = distanceXY;
				}else {
					if (distanceX > distanceXY) {
						distanceX = distanceXY;
					}
				}
			};
			if (distanceX !=null && distanceX<0.00001) {
				toBeRemovedTCs.add(x);
			}	
		}
		testSuite.removeAllTestCases(toBeRemovedTCs);
	}
	
	@TestCaseMetric
	public double distance(TestCase<Double,Double> x) {
		Double distance = null;
		for (TestCase<Double,Double> y: testSuite.testSet) {
			if (x.id.equals(y.id)) {continue;}
			double distanceXY =  Math.abs(y.input - x.input);
			if (distance == null) {distance = distanceXY;
			}else {
				if (distanceXY < distance) { distance = distanceXY; }
			}
		};
		return distance;
	}
	
	@TestCaseFilter
	public Boolean tooClose(TestCase<Double,Double> x) {
		return (distance(x) <0.00001);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "piMinus",
			message="Failed the rule: Sin(x) = Sin(pi - x)")
	public boolean PiMinusAssertion(TestCase<Double, Double> tc) {
			TestCase<Double, Double> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output - originalTc.output) <= 0.000000000000001);
	}
	
	@Analyser
	public void visualization() {
		new VisualizeOutput(testSuite.testSet);
	}
}
