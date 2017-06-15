package pers.you.java.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.apache.accumulo.core.master.thrift.FateService.Processor.beginFateOperation;



public class FJDemo {

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> result = forkJoinPool.submit(new MTask(0, 1000001));
        try {
            System.out.println(result.get());
            forkJoinPool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
}


class MTask extends RecursiveTask<Long>{

   static final int  THRESHOLD = 1000;
    
   private int begin,end;
   public MTask(int begin,int end){
       this.begin = begin;
       this.end = end;
   }
    
    @Override
    protected Long compute() {
        long sum = 0;
        if((end - begin) <= THRESHOLD){
            for(int i = begin;i<end;i++){
                sum +=i;
            }
        }else{
            int mid = (begin+end)/2;
            MTask left = new MTask(begin, mid);
            left.fork();
            MTask right = new MTask(mid+1, end);
            right.fork();
            
            Long lr = left.join();
            System.out.println(begin + " - " + mid + ":" +lr);
            Long rr = right.join();
            System.out.println(mid+1 + " - " + end+ ":" +rr);
            sum = lr  + rr;
        }
        // TODO Auto-generated method stub
        return sum;
    }
   
    
}
