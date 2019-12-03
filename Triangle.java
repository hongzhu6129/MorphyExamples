package morphy.examples;
public class Triangle {
	public int x =0;
	public int y =0;
	public int z =0;

	public Triangle() {
		x=0; y=0; z=0; 
	}
	
	public Triangle(int a, int b, int c) {
		x=a; y=b; z=c; 
	}
	
	public String toString() {
		String str = "<"+x+"|"+y+"|"+z+">";
		return str;
	}
	
	public void valueOf(String str) {
		String[] part = str.split("\\|");
		String xStr = part[0].substring(1);
		x = Integer.valueOf(xStr);
		String yStr = part[1];
		y = Integer.valueOf(yStr);
		String zStr = part[2];
		zStr = zStr.substring(0,zStr.length()-1);
		z = Integer.valueOf(zStr);
	}
}
