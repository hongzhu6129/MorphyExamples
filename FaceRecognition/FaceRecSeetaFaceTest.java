package morphy.examples;

import morphy.annotations.TestExecuter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FaceRecSeetaFaceTest extends TwoImageRandomTesting{

	@TestExecuter
	public Double seetaFaceTest(TwoImage images) {
		String dir = ImageConfig.seetaFacePath;
		String cmd = dir + File.separator + "Identification.exe " + images.getCmd();
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String result = stdout.readLine();
			stdout.close();
			return Double.valueOf(result);
		} catch (IOException e) {
			e.printStackTrace();
			return 0.0;
		}
	}
}
