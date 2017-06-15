package platform_to_hbase;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTest {
	public static void main(String[] args){
	String[] a ={"hello","world"};
	try{
		System.out.println(a[3]);
	}
	catch(Exception e){
    StringWriter sw = new StringWriter() ;  
    e.printStackTrace(new PrintWriter(sw));  
    StringBuffer buffer = sw.getBuffer() ;  
    System.out.println(buffer);
    System.out.println(buffer);
		String wrong=e.getMessage();
	
		}
	}
}
