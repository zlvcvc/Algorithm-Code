package Code_03_Thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: zhanglei
 * @Date: 2019/11/8 14:45
 * @Description: 生产者和消费者 lock和condition机制
 */
public class ProducerConsumer2 {
    public static final Integer MAX_SIZE=3;
    public LinkedList<Integer> list=new LinkedList<Integer>();
    public static Lock lock=new ReentrantLock();
    public static Condition full=lock.newCondition();
    public static Condition empty=lock.newCondition();
    //生产者
    public class producer implements Runnable{
        @Override
        public void run() {
                lock.lock();
                while(list.size()==MAX_SIZE){
                    System.out.println("当前仓库已满");
                    try {
                        full.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println("生产者生产，仓库容量为"+list.size());
                full.signal();
                empty.signal();
                lock.unlock();
        }
    }
    //消费者
    public class consumer implements Runnable{
        @Override
        public void run() {
                lock.lock();
                while(list.size()==0){
                    System.out.println("当前仓库已空");
                    try {
                        empty.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.removeFirst();
                System.out.println("消费者消费，仓库容量为"+list.size());
                full.signal();
                empty.signal();
                lock.unlock();
        }
    }
    public static void main(String args[]){
        ProducerConsumer producerConsumer=new ProducerConsumer();
        ProducerConsumer.producer producer=producerConsumer.new producer();
        ProducerConsumer.consumer consumer=producerConsumer.new consumer();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(producer);
            thread.start();
            Thread thread1=new Thread(consumer);
            thread1.start();
        }
    }
}
