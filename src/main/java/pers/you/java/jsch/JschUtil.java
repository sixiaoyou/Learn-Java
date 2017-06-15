package pers.you.java.jsch;

import com.jcraft.jsch.*;
import util.PropertyUtil;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;



/**类的说明
 *类名：JschUtil
 *作者：邱超
 *时间：2016-09-08
 *功能说明：远程登录Linux服务器，调用kylin API
 */
public class JschUtil {

		public JschUtil() {
			super();
			PropertyUtil.loadConfig();
		}

/**
 * 
 * @param cmd
 * @return
 * @throws JSchException
 * @throws IOException
 */
		public static StringBuffer exec(String cmd) throws JSchException, IOException{
			JSch jsch = new JSch(); // 创建JSch对象  
	        String userName ="root";// 用户名  
	        String password = "yJun0819&0711";// 密码  
	        String host ="168.168.207.3";// 服务器地址  
	        int port = 22;//端口号 
	        Session session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象  
	        session.setPassword(password); // 设置密码  
	        Properties config = new Properties();  
	        config.put("StrictHostKeyChecking", "no");  
	        session.setConfig(config); // 为Session对象设置properties  
	        int timeout = 60000000;  
	        session.setTimeout(timeout); // 设置timeout时间  
	        session.connect(); // 通过Session建立链接  
	        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");  
	        channelExec.setCommand(cmd);  
	        channelExec.setInputStream(null);  
	        channelExec.setErrStream(System.err);  
	        channelExec.connect();  
	        InputStream in = channelExec.getInputStream();  
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));  
	        String buf = null;  
	        StringBuffer sb = new StringBuffer();  
	        while ((buf = reader.readLine()) != null) {  
	            sb.append(buf);  
	            System.out.println(sb);
	        }  
	        reader.close();  
	        channelExec.disconnect();  
	        if (null != session) {  
	            session.disconnect();  
	        } 	
	    	return sb;
	     }
}




