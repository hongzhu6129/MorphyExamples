package morphy.examples;

public class Triangle1 {
	public int x, y, z; 
	
	public Triangle1(int a, int b, int c) {
		x = a; y = b; z = c;
	}

	public TriangleType Classify() {
		int swap = x;
		TriangleType triangleType; 
		if (x <= 0.0 || (y <= 0.0 || z <= 0.0))
			triangleType = TriangleType.noneTriangle;
		if (y < x) {
			swap = x;
			x = y; 
			y = swap;
			};
		if (z < y) {
			swap = y;
			y = z; 
			z = swap;
			};
		if (y < x) {
			swap = x;
			x = y; 
			y = swap;
			};
		if (x + y <z){
			triangleType = TriangleType.noneTriangle;
			};
		if (x==y && y==z){
			triangleType = TriangleType.equilaterial;
			}
		else {if (x==y || y==z){
			triangleType = TriangleType.isoscelene;
		}
		else triangleType = TriangleType.scalene;
		};
		return triangleType;
	}
}
