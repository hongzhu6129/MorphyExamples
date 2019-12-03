package morphy.examples;
import morphy.annotations.*;

public class TriangleTest1 extends TriangleTestSpec { 
	@TestExecuter
	public TriangleType TriangleClassifier1(Triangle tc) {
		int x = tc.x;
		Triangle1 tx = new Triangle1(x, tc.y, tc.z); 
		return tx.Classify();
	}
}
