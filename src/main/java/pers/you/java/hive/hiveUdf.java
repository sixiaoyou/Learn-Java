package pers.you.java.hive;

import org.apache.hadoop.hive.ql.exec.UDF;

public class hiveUdf extends UDF{
	public Integer evaluate(String s)
    {
        if(s==null)
        {
            return null;
        }else{
            return s.length();
        }
    }
}
