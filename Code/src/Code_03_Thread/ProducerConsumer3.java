package Code_03_Thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: zhanglei
 * @Date: 2019/11/8 15:16
 * @Description: 生产者和消费者 BlockingQueue阻塞队列
 */
public class ProducerConsumer3 {
    public static final Integer MAX_SIZE=3;
    public LinkedBlockingQueue linkedBlockingQueue=new LinkedBlockingQueue(MAX_SIZE);
    //生产者
    public class producer implements Runnable{
        @Override
        public void run() {
                while(linkedBlockingQueue.size()==MAX_SIZE){
                    System.out.println("当前仓库已满");
                }
                try {
                    linkedBlockingQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产者生产，仓库容量为"+linkedBlockingQueue.size());
                }
    }
    //消费者
    public class consumer implements Runnable{
        @Override
        public void run() {
                while(linkedBlockingQueue.size()==0){
                    System.out.println("当前仓库已空");
                    try {
                        linkedBlockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费者消费，仓库容量为"+linkedBlockingQueue.size());
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
