package multithreading;

public class ThreadLei02 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start(); //开启多线程，新的线程自动执行run方法
        while (true) {
            Thread.sleep(1000); //睡眠1秒
            System.out.println("Mian方法在运行");
        }
    }

    static class MyThread extends Thread { //继承 Thread类
        public void run() { //重写父类的 run方法
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
}
