package pers.you.java.jsch;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
			public static void main(String[] args) throws ClientProtocolException, IOException {
				HttpClient httpClient = new DefaultHttpClient();
				try {
					HttpPut request = new HttpPut("http://168.168.207.3:7070/kylin/api/cubes/interface_clone/rebuild");
					StringEntity params = new StringEntity("{\"startTime\":'1475539200000', \"endTime\":'1475625600000', \"buildType\":\"BUILD\"}", "UTF-8");
					request.addHeader("Content-Type","application/json");
					request.addHeader("ADMIN","KYLIN");
					request.setEntity(params);
					HttpResponse response = httpClient.execute(request);
					int statusCode = response.getStatusLine().getStatusCode();
					System.out.println(statusCode);

					if (response != null) {

						String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
						System.out.println(responseBody.toString());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					httpClient.getConnectionManager().shutdown();
				}

			}
		}

