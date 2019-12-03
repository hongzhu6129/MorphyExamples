package morphy.examples;
public class Triangle2 {
	int x, y, z;
	public Triangle2(int a, int b, int c) {
		x=a; y=b; z=c;
	}
	
	public TriangleType Classify() {
		TriangleType triangleType; 
		if (x <= 0.0 || y <= 0.0 || z <= 0.0 || x+y <=z || x+z <= y || y+z <= x)
			triangleType = TriangleType.noneTriangle;
		if (x==y && y==z){
			triangleType = TriangleType.equilaterial;
			}
		else {if (x==y || y==z || x==z){
			triangleType = TriangleType.isoscelene;
		}
		else triangleType = TriangleType.scalene;
		};
		return triangleType; 
	}
}