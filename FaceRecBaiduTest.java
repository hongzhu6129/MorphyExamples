package morphy.examples;

import com.face.baidu.run.ApiTesting;
import com.face.baidu.run.BaiduApi;
import morphy.annotations.TestExecuter;

public class FaceRecBaiduTest extends TwoImageRandomTesting{

	@TestExecuter
	public Double baiduTest(TwoImage images) {
		ApiTesting apiTesting = new BaiduApi();
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
