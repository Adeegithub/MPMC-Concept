public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);
        Producer producer3 = new Producer(buffer);
        Producer producer4 = new Producer(buffer);

        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Consumer consumer3 = new Consumer(buffer);
        Consumer consumer4 = new Consumer(buffer);

        Thread producerThread1 = new Thread(producer1, "producerThread1: ");
        Thread producerThread2 = new Thread(producer2, "producerThread2: ");
        Thread producerThread3 = new Thread(producer3, "producerThread3: ");
        Thread producerThread4 = new Thread(producer4, "producerThread4: ");

        Thread consumerThread1 = new Thread(consumer1, "consumerThread1: ");
        Thread consumerThread2 = new Thread(consumer2, "consumerThread2: ");
        Thread consumerThread3 = new Thread(consumer3, "consumerThread3: ");
        Thread consumerThread4 = new Thread(consumer4, "consumerThread4: ");

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        producerThread4.start();

        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();
        consumerThread4.start();
    }
}