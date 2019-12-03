package morphy.examples;

public class TwoImage {
    public String path;
    public String i1;
    public String i2;

    public TwoImage() {
        this.path = "C:\\\\";
        this.i1 = "";
        this.i2 = "";
    }
    
    public TwoImage(String path, String i1, String i2) {
        this.path = path;
        this.i1 = i1;
        this.i2 = i2;
    }

    public String toString() {
        String str = "<"+ path + "|"+ i1 + "|" + i2 + ">";
        return str;
    }

    public void valueOf(String str) {
    	str = str.substring(1, str.length()-1);
        path = str.split("\\|")[0];
        i1 = str.split("\\|")[1];
        i2 = str.split("\\|")[2];
    }

    public String getCmd() {
        String p1 = path + "\\" + i1;
        String p2 = path + "\\" + i2;
        return p1 + " " + p2;
    }
}
