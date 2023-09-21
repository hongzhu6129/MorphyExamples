package morphy.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveExpResults {
	public static String userDirectory = System.getProperty("user.dir");
	public File expDataFile = new File(userDirectory + File.separator + "ExpDataFile.csv");
	public void saveData(String data) {
		FileWriter fileWriter;
		PrintWriter printWriter;  
		try {
			fileWriter = new FileWriter(expDataFile, true);
			printWriter = new PrintWriter(fileWriter);
		} catch (IOException e) {
			System.out.println("-- Failed to create file to save the test history.");
			System.out.println("\tReason: "+ e.getCause());
			return;
		};
		printWriter.println(data);
		printWriter.close();
		try {
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
