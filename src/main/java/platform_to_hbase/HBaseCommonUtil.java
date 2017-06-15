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

public class HBaseCommonUtil {
	Map<String, HTable> tableMap;
	HBaseConfiguration conf = new HBaseConfiguration();
	private static Logger logger = Logger.getLogger(HBaseCommonUtil.class);

	public HBaseCommonUtil() {
		tableMap = new HashMap<String, HTable>();
		conf.set("hbase.zookeeper.quorum", "168.168.207.1:2182");
	}

	public void judgeTableMapStatus(String tableName, String rowKey, String operationType, StringBuffer Message) {
		if (tableMap.get(tableName) == null) {
			try {
				tableMap.put(tableName, new HTable(conf, tableName));
			} catch (IOException e) {
				logger.error("处理错误|本次处理数据所属表名:  " + tableName + "本次处理数据的主键:  " + rowKey + "本次数据操作类型:  " + operationType
						+ "出错原因:	" + Message);
			}
		}
	}

	public void insertData(String tableName, String rowKey, String ResultCode, String operationType) {
		HTable table = tableMap.get(tableName);
		Put put = new Put(Bytes.toBytes(rowKey));
		Iterator it = valueJsonObj.keys();

		while (it.hasNext()) {
			String jsonkey = (String) it.next();
			try {
				put.add(Bytes.toBytes("detail"), Bytes.toBytes(jsonkey),
						Bytes.toBytes(valueJsonObj.getString(jsonkey)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			table.put(put);
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			ResultCode = "0";
			Message.append(sw.getBuffer());
			logger.error("处理错误|本次处理数据所属表名:  " + tableName + "本次处理数据的主键:  " + rowKey + "本次数据操作类型:  " + operationType
					+ "出错原因:	" + Message);
		}
	}

	public void deleteData(String tableName, String rowKey, String ResultCode, String operationType,
			StringBuffer Message, JSONObject valueJsonObj) {
		HTable table = tableMap.get(tableName);
		Delete del = new Delete(rowKey.getBytes());
		try {
			table.delete(del);
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			ResultCode = "0";
			Message.append(sw.getBuffer());
			logger.error("处理错误|本次处理数据所属表名:  " + tableName + "本次处理数据的主键:  " + rowKey + "本次数据操作类型:  " + operationType
					+ "出错原因:	" + Message);
		}
	}

	public void updateData(String tableName, String rowKey, String ResultCode, String operationType,
			StringBuffer Message, JSONObject valueJsonObj) {
		HTable table = tableMap.get(tableName);
		Put put = new Put(Bytes.toBytes(rowKey));
		Iterator it = valueJsonObj.keys();
		while (it.hasNext()) {
			String jsonkey = (String) it.next();
			try {
				put.add(Bytes.toBytes("detail"), Bytes.toBytes(jsonkey),
						Bytes.toBytes(valueJsonObj.getString(jsonkey)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			table.put(put);
		} catch (IOException e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			ResultCode = "0";
			Message.append(sw.getBuffer());
			logger.error("处理错误|本次处理数据所属表名:  " + tableName + "本次处理数据的主键:  " + rowKey + "本次数据操作类型:  " + operationType
					+ "出错原因:	" + Message);
		}
	}

}
