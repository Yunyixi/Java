package multithreading;

public class RunnableLei04 {
    public static void main(String[] args) {
        SaleThread saleThread = new SaleThread();
        SaleThread01 saleThread01 = new SaleThread01();
        SaleThread02 saleThread02 = new SaleThread02();
        /*new Thread(saleThread, "线程1").start();
        new Thread(saleThread, "线程2").start();
        new Thread(saleThread, "线程3").start();
        new Thread(saleThread, "线程4").start();*/
        /*new Thread(saleThread01, "线程a").start();
        new Thread(saleThread01, "线程b").start();
        new Thread(saleThread01, "线程c").start();
        new Thread(saleThread01, "线程d").start();*/
        new Thread(saleThread02, "线程a1").start();
        new Thread(saleThread02, "线程b1").start();
        new Thread(saleThread02, "线程c1").start();
        new Thread(saleThread02, "线程d1").start();
    }

    private static class SaleThread implements Runnable {
        private int tickets = 10;

        @Override
        public void run() {
            while (tickets > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "----卖出的票" + tickets--);
            }
        }
    }

    private static class SaleThread01 implements Runnable {
        Object lock = new Object();
        private int tickets01 = 10;

        @Override
        public void run() {
            while (true) {
                synchronized (lock) { //只允许一个线程运行
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (tickets01 > 0) {
                        System.out.println(Thread.currentThread().getName() + "----卖出的票" + tickets01--);
                    } else {
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class SaleThread02 implements Runnable {
        private int tickets03 = 10;

        @Override
        public void run() {
            while (true) {
                saleTicket(); //买票方法
                if (tickets03 < 0) {
                    break;
                }
            }
        }

        private synchronized void saleTicket() { //卖票方法
            if (tickets03 > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "----卖出的票" + tickets03--);
            }
        }
    }
}

