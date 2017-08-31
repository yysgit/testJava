package threadQueueTest;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * User: 杨永生
 * Date: 15:55 2017/8/8
 * Email: kevin@hiibook.com
 */
public class ThreadPoolTest2 implements Runnable {
    public void run() {
        synchronized(this) {
            try{
                System.out.println("线程名称："+Thread.currentThread().getName());
                Thread.sleep(3000); //休眠是为了让该线程不至于执行完毕后从线程池里释放
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4); //固定为4的线程队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Thread(new ThreadPoolTest2(), "TestThread".concat(""+i)));
            int threadSize = queue.size();
            System.out.println("线程队列大小为-->"+threadSize);
        }
        executor.shutdown();
    }
}