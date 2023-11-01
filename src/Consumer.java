public class Consumer implements Runnable {

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int item = buffer.getData();
            System.out.println(Thread.currentThread().getName()+ "Consumed " + item);
        }
    }
}
