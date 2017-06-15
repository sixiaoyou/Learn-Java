package backup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;


/**类的说明
 * 类名：TimeOperation
 * 作者：柏晨浩
 * 时间：2016年9月18日
 * 类的功能：包含一些关于时间的方法
 */
public class TimeOperation{
		private static Logger logger = Logger.getLogger(TimeOperation.class);  
		
/**
 * 获取当前日期的下一天日期
 * @param dataTime
 * @return nextDate
*/
public String getNextDate(String dataTime){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			java.util.Date dt = null;
			try {
				dt = sdf.parse(dataTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Calendar cal=Calendar.getInstance();  
			cal.setTime(dt); 
			Date date = new Date();
			cal.add(Calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动 
		    date=cal.getTime();   
		    String nextDate = sdf.format(date);
		    logger.info("数据日期为: "+dataTime+"该日期的下一天为："+" "+nextDate);
		    return nextDate;
	}
}

