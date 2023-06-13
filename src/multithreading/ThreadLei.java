package multithreading;

public class ThreadLei {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.run();
        while (true) {
            Thread.sleep(1000); //睡眠1秒
            System.out.println("Mian方法在运行");
        }
    }


}

class MyThread {
    void run() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(" MyThread类run方法在运行");
        }
    }
}