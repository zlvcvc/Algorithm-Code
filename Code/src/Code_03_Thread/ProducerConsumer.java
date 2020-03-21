package Code_03_Thread;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;

/**
 * @Auther: zhanglei
 * @Date: 2019/11/8 14:20
 * @Description: 生产者和消费者   wait()和notify()模式
 */
public class ProducerConsumer {
    public static final Integer MAX_SIZE=3;
    public LinkedList<Integer> list=new LinkedList<Integer>();
    //生产者
    public class producer implements Runnable{
        @Override
        public void run() {
            synchronized(list){
                while(list.size()==MAX_SIZE){
                    System.out.println("当前仓库已满");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(1);
                System.out.println("生产者生产，仓库容量为"+list.size());
                list.notify();
            }
        }
    }
    //消费者
    public class consumer implements Runnable{
        @Override
        public void run() {
            synchronized(list){
                while(list.size()==0){
                    System.out.println("当前仓库已空");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.removeFirst();
                System.out.println("消费者消费，仓库容量为"+list.size());
                list.notify();
            }
        }
    }
    public static void main(String args[]){
        ProducerConsumer producerConsumer=new ProducerConsumer();
        producer producer=producerConsumer.new producer();
        consumer consumer=producerConsumer.new consumer();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(producer);
            thread.start();
            Thread thread1=new Thread(consumer);
            thread1.start();
        }
    }
}
