package multithreading;

public class RunnableLei03 {
    public static void main(String[] args) {
        //创建两个线程
        Thread MinPriority = new Thread(new MinPriority(), "优先级低的线程");
        Thread MaxPriority = new Thread(new MinPriority(), "优先级高的线程");
        MinPriority.setPriority(Thread.MIN_PRIORITY); //设置线程的优先级为1
        MaxPriority.setPriority(Thread.MAX_PRIORITY); //设置线程的优先级为10，最高优先级
        //开启两个线程
        MinPriority.start();
        MaxPriority.start();
    }
}

class MaxPriority implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在输出：" + i);
        }
    }
}

class MinPriority implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在输出：" + i);
        }
    }
}
