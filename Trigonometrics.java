package morphy.examples;
public class Trigonometrics {
	public double sin, cos, tan =0;
	
	public Trigonometrics() {
		sin=0; cos=0; tan=0; 
	}
	
	public Trigonometrics(double a, double b, double c) {
		sin=a; cos=b; tan=c; 
	}
	
	public String toString() {
		String str = "<"+sin+"|"+cos+"|"+tan+">";
		return str;
	}
	
	public void valueOf(String str) {
		String[] part = str.split("\\|");
		String xStr = part[0].substring(1);
		sin = Double.parseDouble(xStr);
		String yStr = part[1];
		cos = Double.parseDouble(yStr);
		String zStr = part[2];
		zStr = zStr.substring(0,zStr.length()-1);
		tan = Double.parseDouble(zStr);
	}
}
