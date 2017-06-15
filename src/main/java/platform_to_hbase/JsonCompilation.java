package platform_to_hbase;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonCompilation {

	String jsonData =  "{'tablename':'log_link_visit_action','rowkey':'01','type':'INSERT','value':{\"idlink_n\":\"0\",\"idsite\":\"hello\",\"idvisitorhex\":\"WDSERT\",\"server_time\":\"2016-10-26 06:10:00\",\"idvisit_n\":\"02\",\"url\":\"www.word.com\","
			+ "\"url_ref\":\"http://www.word.com\",\"time_spent_ref_action\":\"3\",\"type\":\"4\","
			+ "\"errmsg\":\"NULL\",\"gt_ms\":\"NULL\",\"user_id\":\"002345\",\"user_name\":\"you\",\"dept_name\":\"大数据\",\"company_name\":\"ws\"}}";

	/**
	 * 解析cubelist返回buf中的json数组
	 * @throws  
	 */
	public void compileJsonArray()  {
		
		JSONArray dataJsonArray = null;
		JSONArray	 valueJsonArray = null;
		String ResultCode = "1";
		String Message = null;
		String tableValue= null;
		String jsonValue=null;
		JSONObject jsonDataOne=null;

		
//		try {
//			dataJsonArray= new JSONArray(jsonData);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//		}
//		int dSize = dataJsonArray.length();
//	
//		for (int j = 0; j < dSize; j++) {
//			
//
//			JSONObject dataJsonObj = null;
//			try {
//				dataJsonObj = dataJsonArray.getJSONObject(j);
//			} catch (JSONException e1) {
//				// TODO Auto-generated catch block
//			}
//
//			try {
//				jsonValue=dataJsonObj.get("value")+"";
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//			}
//		}


		try {
			jsonDataOne = new JSONObject(jsonData);
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
//		try {
//			jsonValue=jsonDataOne.get("value")+"";
//			valueJsonArray = new JSONArray(jsonValue);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		int vSize = dataJsonArray.length();
//		String columnValue=null;
//		JSONObject valueJsonObj = null;
//		for (int j = 0; j < vSize; j++) {
//
//			try {
//				valueJsonObj = valueJsonArray.getJSONObject(j);
//			} catch (JSONException e1) {
//				// TODO Auto-generated catch block
//			}
//		}
			try {
				jsonValue=jsonDataOne.get("value")+"";
				JSONObject valueJsonObj = new JSONObject(jsonValue);
				Iterator it= valueJsonObj.keys();
				while (it.hasNext()) {
					String jsonkey=(String) it.next();
					System.out.println(valueJsonObj.getString(jsonkey));
				}
				
			}catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
	

		
	public JsonCompilation(){
		compileJsonArray();
	}
	
	public static void main(String[] args){
		JsonCompilation jc = new JsonCompilation();
	}
}
