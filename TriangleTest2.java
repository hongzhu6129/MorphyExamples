package morphy.examples;

import morphy.annotations.Datamorphism;
import morphy.annotations.MakeSeed;
import morphy.annotations.Metamorphism;
import morphy.annotations.TestCase;
import morphy.annotations.TestExecuter;
import morphy.annotations.TestPool;
import morphy.annotations.TestSetContainer;

public class TriangleTest2 extends TriangleTestSpec {
	@TestExecuter
	public TriangleType TriangleClassifier(Triangle tc) {
		Triangle2 x = new Triangle2(tc.x, tc.y, tc.z); 
		return x.Classify();
	}
}
