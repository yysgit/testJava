package thread_Callable;

import java.util.concurrent.*;

/**
 * User: 杨永生
 * Date: 16:50 2017/8/14
 * Email: kevin@hiibook.com
 */
public class Callable_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        //创建两个有返回值的任务
        Callable c1 = new MyCallable("A");
        Callable c2 = new MyCallable("B");
        //执行任务并获取Future对象
        Future f1 = pool.submit(c1);
        Future f2 = pool.submit(c2);
        //从Future对象上获取任务的返回值，并输出到控制台
        System.out.println(">>>"+f1.get().toString());
        System.out.println(">>>"+f2.get().toString());
        //关闭线程池
        pool.shutdown();
    }
}
class MyCallable implements Callable {
    private String oid;

    MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return oid+"任务返回的内容";
    }
}