package pers.you.java.jsch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;
import com.jcraft.jsch.JSchException;

public class TestJsch {
	//kylin编码后的用户名、密码
	private static String encoding;
	private static final String KYLIN_LIMIT="500";
	private static final String KYLIN_PROJECT="OADepartment";

		

	
	private static StringBuffer excute(String para,String method, String params){
		StringBuffer out = new StringBuffer();
		try {
			URL url = new URL("http://168.168.207.3:7070/kylin/api"+para);
			System.out.println(url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);
			connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//			connection.setRequestProperty("Content-Type", "application/json");
			if (params != null) {
				byte[] outputInBytes = params.getBytes("UTF-8");
				OutputStream os = connection.getOutputStream();
				os.write(outputInBytes);
				os.close();
			}
			InputStream content = (InputStream) connection.getInputStream();
			//解决乱码问题
			BufferedReader in = new BufferedReader(new InputStreamReader(content,Charset.forName("UTF-8")));
			String line;
			while ((line = in.readLine()) != null) {
				out.append(line);
				System.out.println(out);
			}
			in.close();
			connection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}

	
	private static StringBuffer query(String params) {
		String method = "PUT";
		String para = "/cubes/interfaceone/rebuild";
		return excute(para,method, params);
	}

	private static StringBuffer login() {
		String method = "POST";
		String para = "/user/authentication";
		
		//byte[] key = (user + ":" + passwd).getBytes();
		byte[] key = ("ADMIN:KYLIN").getBytes();
		encoding = Base64.encodeBase64String(key);
		return excute(para,method, null);
	}
	public static StringBuffer  addSegment(String addStartTime,String addEndTime){
		login();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		StringBuffer queryResult = new StringBuffer();
		try {
			
			Date start = format.parse("2016-09-30"+" "+"00:00:00");
			Date end = format.parse("2016-10-04"+" "+"00:00:00");
			String body ="{\"startTime\":\""+start.getTime()+"\", \"endTime\":\""+end.getTime()+"\", \"buildType\":\"BUILD\"}";
			System.out.println(body);

			queryResult.append(query(body));
			System.out.println(queryResult);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
//		System.out.println("excutesql = " + sql);
//		String body = "{\"sql\": \""+ sql +"\",\"offset\":0,\"limit\":" + KYLIN_LIMIT + ",\"acceptPartial\":false, \"project\":\"" + KYLIN_PROJECT + "\"}";
	
		return queryResult;
	}
}
