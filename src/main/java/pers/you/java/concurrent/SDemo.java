package pers.you.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SDemo {
    public static void main(String[] args){
        List<String> ls = new ArrayList<>();
        ls.add("abc");
        ls.add("def");
        ls.add("aaa");
        ls.add("bbb");
        ls.add("ccc");
        ls.add("ddd");
        ls.add("eee");
        ls.add("fff");
        ls.add("hello");
        
        
//        max终端操作
//        Optional<String> max = ls.stream().max(String::compareTo);
//       System.out.println(max.get());
        
        ls.stream().sorted().forEach(e -> System.out.println(e));
       
        System.out.println(ls.stream().distinct().count());
    }
    
    
}
