import java.util.concurrent.Semaphore;

class ReaderWriter {
    static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount = 0;

    static class Reader implements Runnable {
        public void run() {
            try {
             
                readLock.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire();
                }
                readLock.release();

            
                System.out.println(Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println(Thread.currentThread().getName() + " has FINISHED READING");

            
                readLock.acquire();
                readCount--;
                if (readCount == 0) {
                    writeLock.release();
                }
                readLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Writer implements Runnable {
        public void run() {
            try {
          
                writeLock.acquire();
                System.out.println(Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println(Thread.currentThread().getName() + " has finished WRITING");
                writeLock.release();
                
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ReaderWriter readerWriter = new ReaderWriter();
        Reader r = new Reader();
        Writer w = new Writer();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(w);
        Thread t4 = new Thread(r);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");
        t4.setName("Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
