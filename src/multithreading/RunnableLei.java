package multithreading;

public class RunnableLei {
    public static void main(String[] args) throws InterruptedException {
        MyThread03 myThread = new MyThread03();
        Thread thread = new Thread(myThread);
        thread.start(); //开启多线程，新的线程自动执行run方法
        while (true) {
            Thread.sleep(1000); //睡眠1秒
            System.out.println("Mian方法在运行");
        }
    }
}

class MyThread03 implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" MyThread类run方法在运行");
        }
    }
}