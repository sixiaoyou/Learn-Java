package platform_to_hbase;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class testLocalHbase {
	HBaseCommonUtil hbaseUtil;
	HBaseConfiguration conf = new HBaseConfiguration();
	private static Logger logger = Logger.getLogger(testLocalHbase.class);
	Map<String, HTable> tableMap;
	String jsonData = "{'tablename':'hello','rowkey':'11','type':'DELETE','value':{'idsite':'hellofour','userid':'00006','username':'world'}}";

	public testLocalHbase() {
		hbaseUtil = new HBaseCommonUtil();
		compileJson(jsonData);
	}

	/**
	 * 解析cubelist返回buf中的json数组
	 */
	public String compileJson(String jsonData) {

		String tableName = null;
		String tableValue = null;
		String rowKey = null;
		String ResultCode = "1";
		StringBuffer Message = null;
		String returnJson = null;
		String operationType = null;
		JSONArray dataJsonArray = null;
		JSONArray valueJsonArray = null;
		JSONObject valueJsonObj = null;
		JSONObject dataJsonObj = null;

		try {
			dataJsonObj = new JSONObject(jsonData);
		} catch (JSONException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			dataJsonObj = new JSONObject(jsonData);
			dataJsonObj = new JSONObject(jsonData);
			tableName = dataJsonObj.get("tablename") + "";
			rowKey = dataJsonObj.get("rowkey") + "";
			operationType = dataJsonObj.get("type") + "";
			tableValue = dataJsonObj.get("value") + "";
		} catch (JSONException e2) {
			StringWriter sw = new StringWriter();
			e2.printStackTrace(new PrintWriter(sw));
			ResultCode = "0";
			Message.append(sw.getBuffer());
			logger.error(Message);
		}

		try {
			valueJsonObj = new JSONObject(tableValue);
		} catch (JSONException e1) {
			StringWriter sw = new StringWriter();
			e1.printStackTrace(new PrintWriter(sw));
			ResultCode = "0";
			Message.append(sw.getBuffer());
			logger.error(Message);
		}

		// 执行新增操作
		if (operationType.equals("INSERT")) {
			hbaseUtil.judgeTableMapStatus(tableName, rowKey, operationType, Message);
			hbaseUtil.insertData(tableName, rowKey, ResultCode, operationType, Message, valueJsonObj);

		}
		// 执行删除操作
		else if (operationType.equals("DELETE")) {
			hbaseUtil.judgeTableMapStatus(tableName, rowKey, operationType, Message);
			hbaseUtil.deleteData(tableName, rowKey, ResultCode, operationType, Message, valueJsonObj);
		}

		// 执行更新操作
		else {
			hbaseUtil.judgeTableMapStatus(tableName, rowKey, operationType, Message);
			hbaseUtil.updateData(tableName, rowKey, ResultCode, operationType, Message, valueJsonObj);
		}
		returnJson = "[{ResultCode:" + ResultCode + ",Message:" + Message + "}]";
		return returnJson;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		testLocalHbase tlh = new testLocalHbase();
		long end = System.currentTimeMillis();
		System.out.println("程序运行总耗时为 " + (end - start) + "ms");
	}
}
