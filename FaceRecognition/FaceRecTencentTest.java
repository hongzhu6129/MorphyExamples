package morphy.examples;

import com.face.baidu.run.ApiTesting;
import com.face.baidu.run.TencentApi;
import morphy.annotations.TestExecuter;

public class FaceRecTencentTest extends TwoImageRandomTesting{

	@TestExecuter
	public Double tencentTest(TwoImage images) {
		ApiTesting apiTesting = new TencentApi();
		String cmd = images.getCmd();
		try {
			String result = apiTesting.similarity(cmd.split(" ")[0], cmd.split(" ")[1]);
			return Double.valueOf(result) / 100;
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
	}

}
