public class Producer implements Runnable {

    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.putData(i);
            System.out.println(Thread.currentThread().getName() + "Produced " + i);
        }
    }
}
