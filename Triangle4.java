package morphy.examples;

public class Triangle4 {
	public int x, y, z; 
	public Triangle4(int a, int b, int c) {
		x=a; y=b; z=c;
	}

	public TriangleType Classify() {
		int swap = x;
		if (x <= 0.0 || (y <= 0.0 || z <= 0.0))
			return TriangleType.noneTriangle;
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
		if (x + y <= z){
			return TriangleType.noneTriangle;
			};
		if (x==y && y==z){
			return TriangleType.equilaterial;
			}
		else {if (x==y || y==z){
			return TriangleType.isoscelene;
		}
		else 
			return TriangleType.scalene;
		}
	}
}
