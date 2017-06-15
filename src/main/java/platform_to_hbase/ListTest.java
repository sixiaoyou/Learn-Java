package platform_to_hbase;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String args[]){
		List<String> test = new ArrayList();
		int i = 0;

		for(i=0;i<50;i++){
			String hello="hello"+i;
			if(i<=25){
			test.add(hello);
			}
		}
		for(String test1 : test){
			System.out.println(test1);
		}
		test.clear();
		for(String test1 : test){
			System.out.println("清空后的list");
		}	
	}

}
