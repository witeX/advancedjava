import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsExercise {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopWatchRunnable());
        thread.start();

        AtomicInteger integer = new AtomicInteger(1);
        System.out.println("Main thread starts");
        Thread.sleep(5000);
        System.out.println("Main thread is still running");
        Thread.sleep(5000);
        System.out.println("Main thread ends");
    }

    private static class StopWatchThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                System.out.println("Stop watch: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class StopWatchRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 15; i++) {
                System.out.println("Stop watch: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
