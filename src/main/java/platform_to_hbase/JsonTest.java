package platform_to_hbase;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {

public String encapsulateToJson(){ 
		String ResultCode = "1";
		String Message = null;
		String correct="0";
		String Json=null;
		if(ResultCode.equals(correct)){
			Json = "[{ResultCode:"+ResultCode+",Message:"+Message+"}]";
		}
		else{
			ResultCode ="0";
			Message="出错啦!!!";
			Json=  "[{ResultCode:"+ResultCode+",Message:"+Message+"}]";
		}
		
		return Json;
	}

public void compileJson(){
	String jsonData="[{ResultCode:0,Message:出错啦!!!}]";
	JSONArray dataJsonArray = null;
	JSONObject dataJsonObj = null;
	try {
		dataJsonArray= new JSONArray(jsonData);
	} catch (JSONException e) {
	}
	int dSize = dataJsonArray.length();
	String tableValue= null;
	for (int j = 0; j < dSize; j++) {
	
		try {
			dataJsonObj = dataJsonArray.getJSONObject(j);
		} catch (JSONException e1) {
		}
	}
	try {
		System.out.println(dataJsonObj.get("ResultCode"));
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//public JsonTest(){
//	System.out.println(encapsulateToJson());
//}
public static void main(String[] args){
			JsonTest jt = new JsonTest();
			jt.compileJson();
	}	
}
