package multithreading;

public class demo {//龟兔赛跑线程

    public static void main(String[] args) {
        //创建两个线程模拟龟兔赛跑线程
        new Thread(new rack.gui()).start();
        new Thread(new rack.tu()).start();
    }
}

class rack { //比赛类
    static double guiStack = 0;
    static double tutSack = 0;

    //乌龟线程
    static class gui implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 800; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                guiStack++;//龟名称跑1米
                System.out.println("此时龟跑了：" + guiStack + "米" + " 兔跑了：" + tutSack + "米");
            }
        }
    }

    //兔子线程
    static class tu implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 800; i++) {
                if (tutSack == 600) { //兔子跑到600米休息
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("此时兔子休息");
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (tutSack >= 800) { //兔子跑完
                    break;
                }
                tutSack = tutSack + 2;
            }
        }
    }
}