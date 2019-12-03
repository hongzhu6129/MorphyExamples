package morphy.examples;
public class Triangle3 {
	public int x,y,z;
	public Triangle3(int a, int b, int c) {
		x=a; y=b; z=c;
	}
	
	public TriangleType Classify() {
		if (x <= 0.0 || y <= 0.0 || z <= 0.0 || x+y <=z || x+z <= y || y+z <= x) {
			return TriangleType.noneTriangle;
		}
		if (x==y && y==z){
			return TriangleType.equilaterial;
			}
		else {if (x==y || y==z || x==z){
			return TriangleType.isoscelene;
		}
		else 
			return TriangleType.scalene;
		}
	}
}