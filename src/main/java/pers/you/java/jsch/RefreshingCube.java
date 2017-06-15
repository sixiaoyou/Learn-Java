package pers.you.java.jsch;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jcraft.jsch.JSchException;

import pers.you.java.jsch.JschUtil;;



public class RefreshingCube {
	/**
	 * Refresh操作调用Kylin的返回buf值
	 */
	StringBuffer refreshBuffer = new StringBuffer();
	
	/**
	 * Refresh操作
	 * @param refreshStarttime 
	 * @param refreshEndtime
	 * @param refreshCube
	 * @return refreshBuffer
	 */
	public StringBuffer refreshCube() {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				try {
					Date startTime = format.parse("2016-10-04 08:00:00");
					Date endTime = format.parse("2016-10-05 08:00:00");
					
					//调用Kylin Refresh Restful API
					String cmd = "curl -X PUT --user ADMIN:KYLIN -H 'Content-Type: application/json;charset=utf-8' -d '{\"startTime\":'"+startTime.getTime()+"', \"endTime\":'"+endTime.getTime()+"', \"buildType\":\"BUILD\"}' http://168.168.207.3:7070/kylin/api/cubes/interface_clone/rebuild";
					refreshBuffer = JschUtil.exec(cmd);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
				} catch (JSchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return refreshBuffer;
			}
	public static void main(String[] args){
		RefreshingCube refresh = new RefreshingCube();
		refresh.refreshCube();
	}
}
