package morphy.examples;
import morphy.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class TrigonometricsTest {
	
	Random randomGenerator = new Random();
	
	@TestSetContainer(
			inputTypeName = "Double",
			outputTypeName = "Trigonometrics"
			)
	public TestPool<Double, Trigonometrics> testSuite = new TestPool<Double, Trigonometrics>();
	
	public TestPool<Double, Trigonometrics> expected = new TestPool<Double, Trigonometrics>();
	
	@MakeSeed
	public void RandomValue10(){
		for (int i=0; i<10;i++){
			testSuite.addInput(randomGenerator.nextDouble()*Math.PI/2);
		}
	};
	
	@MakeSeed
	public void RandomValue20(){
		for (int i=0; i<20;i++){
			testSuite.addInput(randomGenerator.nextDouble()*Math.PI/2);
		}
	};
	
	@MakeSeed
	public void specialValues(){
		TestCase<Double, Trigonometrics> tc = new TestCase<Double, Trigonometrics>();
		tc.input = 0.0; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		Trigonometrics tf = new Trigonometrics();
		tf.sin = 0.0; 
		tf.cos = 1.0;
		tf.tan = 0.0;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = Math.PI/6; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = 1.0/2.0; 
		tf.cos = Math.sqrt(3.0)/2;
		tf.tan = Math.sqrt(3.0)/3;
		tc.output = tf; 
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = Math.PI/4; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = Math.sqrt(2.0)/2; 
		tf.cos = Math.sqrt(2.0)/2;
		tf.tan = 1;
		tc.output = tf; 
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = Math.PI/3; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = Math.sqrt(3)/2; 
		tf.cos = 1/2;
		tf.tan = Math.sqrt(3.0);
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = Math.PI/2; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = 1.0; 
		tf.cos = 0;
		tc.output = tf; 
		expected.addTestCase(tc);

		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 2*Math.PI/3; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = Math.sqrt(3.0)/2;
		tf.cos = -1.0/2.0; 
		tf.tan = - Math.sqrt(3.0);
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 3*Math.PI/4; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = Math.sqrt(2.0)/2;
		tf.cos = -Math.sqrt(2.0)/2;; 
		tf.tan = - 1;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 5*Math.PI/6; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = 1/2;
		tf.cos = -Math.sqrt(3.0)/2; 
		tf.tan = - Math.sqrt(3.0)/3;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = Math.PI; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = 0;
		tf.cos = -1; 
		tf.tan = 0;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 7*Math.PI/6; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = -1/2;
		tf.cos = -Math.sqrt(3.0)/2;
		tf.tan = Math.sqrt(3.0)/3;
		tc.output = tf; 
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 5*Math.PI/4; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = - Math.sqrt(2.0)/2;
		tf.cos = - Math.sqrt(2.0)/2;
		tf.tan = 1;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 4*Math.PI/3; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = - Math.sqrt(3.0)/2;
		tf.cos = 1/2; 
		tf.tan = Math.sqrt(3.0);
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 3*Math.PI/2; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = - 1;
		tf.cos = 0; 
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 5*Math.PI/3; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf.sin = - Math.sqrt(3.0)/2;
		tf.cos = 1/2; 
		tf.tan = - Math.sqrt(3.0);
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 7*Math.PI/4; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = - Math.sqrt(2.0)/2;
		tf.cos = Math.sqrt(2.0)/2; 
		tf.tan = - 1;
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 11*Math.PI/6; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = - 1/2;
		tf.cos = Math.sqrt(3.0)/2; 
		tf.tan = - Math.sqrt(3.0)/3; 
		tc.output = tf;
		expected.addTestCase(tc);
		
		tc = new TestCase<Double, Trigonometrics>();
		tc.input = 2*Math.PI; 
		tc.setFeature(TestDataFeature.original);
		testSuite.addTestCase(tc);
		tf = new Trigonometrics();
		tf.sin = 0;
		tf.cos = 1; 
		tf.tan = 0; 
		tc.output = tf;
		expected.addTestCase(tc);
	};
	
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> PiMinus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = Math.PI - seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> TwoPiMinus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = 2* Math.PI - seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> HalfPiMinus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = Math.PI/2 - seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> HalfPiPlus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = Math.PI/2 + seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> TwoPiPlus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = 2*Math.PI + seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> negate(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = - seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> PiPlus(TestCase<Double,Trigonometrics> seed){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = Math.PI + seed.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> sum(TestCase<Double,Double> x1, TestCase<Double,Trigonometrics> x2){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = x1.input + x2.input;
		return mutant; 
	}
	
	@Datamorphism
	public TestCase<Double,Trigonometrics> diff(TestCase<Double,Trigonometrics> x1, TestCase<Double,Trigonometrics> x2){
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = x1.input - x2.input;
		return mutant; 
	}
	
	@Datamorphism(filter = "TooClose")
	public TestCase<Double,Trigonometrics> Mid(TestCase<Double,Trigonometrics> x1, TestCase<Double,Trigonometrics> x2) {
		TestCase<Double,Trigonometrics> mutant = new TestCase<Double,Trigonometrics>();
		mutant.input = (x1.input +x2.input)/2;
		return mutant; 
	}
	
	@TestSetMetric
	public double AvgDistance() {
		double total =0;
		double num = 0;
		for (TestCase<Double, Trigonometrics> x: testSuite.testSet ) {
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
			TestCase<Double, Trigonometrics> x = testSuite.testSet.get(i);
			Double distanceX = null; 
			for (int j=i+1; j<testSetSize; j++) {
				TestCase<Double, Trigonometrics> y = testSuite.testSet.get(j);
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
	public double Distance(TestCase<Double,Double> x) {
		Double distance = null;
		for (TestCase<Double,Trigonometrics> y: testSuite.testSet) {
			if (x.id.equals(y.id)) { continue;}
			double distanceXY =  Math.abs(y.input - x.input);
			if (distance == null) {distance = distanceXY;
			}else {
				if (distanceXY < distance) { distance = distanceXY; }
			}
		};
		return distance;
	}
	
	@TestCaseFilter
	public Boolean TooClose(TestCase<Double,Double> x) {
		return (Distance(x) <0.00001);
	}
	
	int numTestRuns =0; 
	@TestExecuter
	public Trigonometrics testMath(Double x) {
		numTestRuns++;
		Trigonometrics result = new Trigonometrics(0,0,0);
		result.sin = Math.sin(x);
		result.cos = Math.cos(x);
		result.tan = Math.tan(x);
		return result;
	}
	
	double error = 0.000000000001; 
	
	@Metamorphism(
			applicableTestCase="seed",
			message="Special Sin(x) value")
	public boolean specialSinValueAssertion(TestCase<Double, Trigonometrics> tc) {
			if (expected.get(tc.id).output == null) { return true; };
			return (Math.abs(tc.output.sin - expected.get(tc.id).output.sin) < error) ;
	}
	
	@Metamorphism(
			applicableTestCase="seed",
			message="Special Cos(x) value")
	public boolean specialCosValueAssertion(TestCase<Double, Trigonometrics> tc) {
			if (expected.get(tc.id).output == null) { return true; };
			return (Math.abs(tc.output.cos - expected.get(tc.id).output.cos) < error) ;
	}
	
	@Metamorphism(
			applicableTestCase="seed",
			message="Special Tan(x) value")
	public boolean specialTanValueAssertion(TestCase<Double, Trigonometrics> tc) {
			if (expected.get(tc.id).output == null) { return true; };
			return (Math.abs(tc.output.tan - expected.get(tc.id).output.tan) < error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "PiMinus",
			message="The rule: Sin(pi-x) = Sin(x)")
	public boolean PiMinusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin - originalTc.output.sin) < error) ;
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "PiMinus",
			message="The rule: Cos(pi-x) = -Cos(x)")
	public boolean PiMinusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos + originalTc.output.cos) < error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism = "PiMinus",
			message="The rules: Tan(pi-x) = -Tan(x)")
	public boolean PiMinusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan + originalTc.output.tan) < error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="PiPlus",
			message="The rule: Sin(pi + x) = -Sin(x)"
			)
	public boolean PiPlusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin + originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="PiPlus",
			message="The rule: Cos(pi + x) = -Cos(x)"
			)
	public boolean PiPlusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos + originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="PiPlus",
			message="The rule: Tan(pi+x) = Tan(x)"
			)
	public boolean PiPlusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan - originalTc.output.tan) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiPlus",
			message="The rule: Sin(pi/2+x) = Cos(x)"
			)
	public boolean HalfPiPlusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin - originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiPlus",
			message="The rule: Cos(pi/2+x) = -Sin(x)"
			)
	public boolean HalfPiPlusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos + originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiPlus",
			message="The rule: Tan(pi/2+x) = -1/Tan(x)"
			)
	public boolean HalfPiPlusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan + 1/originalTc.output.tan) <= error);
	}
	
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiMinus",
			message="The rule: Sin(pi/2-x) = Cos(x)"
			)
	public boolean HalfPiMinusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin - originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiMinus",
			message="The rule: Cos(pi/2-x) = Sin(x)"
			)
	public boolean HalfPiMinusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos - originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="HalfPiMinus",
			message="The rule: Tan(pi/2-x) = 1/Tan(x)"
			)
	public boolean HalfPiMinusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan - 1/originalTc.output.tan) <= error);
	}
	
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiMinus",
			message="The rule: Sin(2pi-x) = -Sin(x)"
			)
	public boolean TwoPiMinusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin + originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiMinus",
			message="The rule: Cos(2pi-x) = Cos(x)"
			)
	public boolean TwoPiMinusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos - originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiMinus",
			message="The rule: Tan(2pi-x) = -Tan(x)"
			)
	public boolean TwoPiMinusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan + originalTc.output.tan) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiPlus",
			message="The rule: Sin(2pi+x) = Sin(x)"
			)
	public boolean TwoPiPlusSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin - originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiPlus",
			message="The rule: Cos(2pi+x) = Cos(x)"
			)
	public boolean TwoPiPlusCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos - originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="TwoPiPlus",
			message="The rule: Tan(2pi+x) = Tan(x)"
			)
	public boolean TwoPiPlusTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan - originalTc.output.tan) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negate",
			message="The rule: Sin(-x) = -Sin(x)"
			)
	public boolean negateSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.sin + originalTc.output.sin) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negate",
			message="The rule: Cos(-x) = Cos(x)"
			)
	public boolean negateCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.cos - originalTc.output.cos) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="negate",
			message="The rule: Tan(-x) = -Tan(x)"
			)
	public boolean negateTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> originalTc = testSuite.get(tc.getOrigins().get(0));
			return (Math.abs(tc.output.tan + originalTc.output.tan) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="sum",
			message="The rule: Sin(x+y) = Sin(x)*Cos(y)+Cos(x)*Sin(y)"
			)
	public boolean sumSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.sin - (x.output.sin * y.output.cos + x.output.cos * y.output.sin)) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="sum",
			message="The rule: Cos(x+y) = Cos(x)*Cos(y) - Sin(x)*Sin(y)"
			)
	public boolean sumCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.cos - (x.output.cos * y.output.cos - x.output.sin * y.output.sin)) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="sum",
			message="The rule: Tan(x+y) = (Tan(x)+Tan(y))/(1-Tan(x)*Tan(y))"
			)
	public boolean sumTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.tan - ((x.output.tan + y.output.tan)/ (1 - x.output.tan * y.output.tan))) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="diff",
			message="The rule: Sin(x-y) = Sin(x)*Cos(y)-Cos(x)*Sin(y)"
			)
	public boolean diffSinAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.sin - (x.output.sin * y.output.cos - x.output.cos * y.output.sin)) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="diff",
			message="The rule: Cos(x-y) = Cos(x)*Cos(y) + Sin(x)*Sin(y)"
			)
	public boolean diffCosAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.cos - (x.output.cos * y.output.cos + x.output.sin * y.output.sin)) <= error);
	}
	
	@Metamorphism(
			applicableTestCase="mutant",
			applicableDatamorphism="diff",
			message="The rule: Tan(x-y) = (Tan(x)-Tan(y))/(1+Tan(x)*Tan(y))"
			)
	public boolean diffTanAssertion(TestCase<Double, Trigonometrics> tc) {
			TestCase<Double, Trigonometrics> x = testSuite.get(tc.getOrigins().get(0));
			TestCase<Double, Trigonometrics> y = testSuite.get(tc.getOrigins().get(1));
			return (Math.abs(tc.output.tan - ((x.output.tan - y.output.tan)/ (1 + x.output.tan * y.output.tan))) <= error);
	}
	
	@Analyser
	public void visualization() {
		new VisualizeTrignometricalFunctions(testSuite.testSet);
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
