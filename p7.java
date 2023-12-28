import java.util.*;

class sharedBuffered{
    LinkedList<Integer>buffer=new LinkedList<>();
    int capacity;
    sharedBuffered(int capacity){
        this.capacity=capacity;
    }
    void produce(int item) throws InterruptedException{
       synchronized(this)
        {
         if(buffer.size()==capacity){
            wait();
        }
        buffer.add(item);
        System.out.println("Producing item: "+item);
        notifyAll();
        }
    }
    int consume() throws InterruptedException{
        synchronized(this){
            if(buffer.isEmpty()){
                wait();
            }
            int item = buffer.removeFirst();
            System.out.println("Consuming item "+item);
            notifyAll();
            return item;
        }
    }
         
} 
class Producer implements Runnable{
    sharedBuffered sh;
    Producer(sharedBuffered sh){
        this.sh=sh;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                sh.produce(i);
                Thread.sleep(1000);
            }
            catch(Exception e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
class Consumer implements Runnable{
    sharedBuffered sh;
    Consumer(sharedBuffered sh){
        this.sh=sh;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                sh.consume();
                Thread.sleep(1000);
            }
            catch(Exception e){
                Thread.currentThread().interrupt();
            }   
        }
    }
}
class p7{
    public static void main(String args[]){
    sharedBuffered sh=new sharedBuffered(5);
    Thread t1=new Thread(new Producer(sh));
    Thread t2=new Thread(new Consumer(sh));
    t1.start();
    t2.start();
}   
}
