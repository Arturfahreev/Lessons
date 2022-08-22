package multithreading;

public class TestThread {
    public static void main(String[] args) {
        Thread myThread = new MyThread();
        myThread.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + " " + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("MyThread" + " " + i);
        }
    }
}
