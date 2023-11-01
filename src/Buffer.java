import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    //This Class will act as a monitor

    public static final int MAX_SIZE = 4;
    //Shared Variable
    private Queue<Integer> data;
    private ReentrantLock reentrantLock = new ReentrantLock();

    //Creating two conditions
    private Condition notFull = reentrantLock.newCondition();
    private Condition full = reentrantLock.newCondition();

    public Buffer() {
        this.data = new LinkedList<Integer>();
    }

    public int getData() {
        try {
            reentrantLock.lock();
            while (data.size() == 0) {
                //wait for the data to be produced
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            full.signalAll();
            return data.poll();
            //reentrantLock.unlock();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void putData(int data) {
        try {
            reentrantLock.lock();
            while (this.data.size() == MAX_SIZE) {
                //wait for the data to be consumed
                try {
                    full.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            notFull.signalAll();
            //produce data into the buffer
            this.data.offer(data);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void printBuffer() {
        try {
            reentrantLock.lock();
            System.out.println("Buffer contents: " + data);
        } finally {
            reentrantLock.unlock();
        }
    }
}
