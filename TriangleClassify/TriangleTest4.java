package morphy.examples;
import morphy.annotations.*;

public class TriangleTest4 extends TriangleTestSpec { 
	@TestExecuter
	public TriangleType TriangleClassifier1(Triangle tc) {
		Triangle4 x = new Triangle4(tc.x, tc.y, tc.z); 
		return x.Classify();
	}
}
