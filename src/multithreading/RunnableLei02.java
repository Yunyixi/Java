package multithreading;

public class RunnableLei02 {
    public static void main(String[] args) {
    /*
        //普通多线程
        new TicketWindows().start();
        new TicketWindows().start();
    */

        //共享多线程
        TicketWindows ticketWindows = new TicketWindows();
        new Thread(ticketWindows, "窗口 1").start();
        new Thread(ticketWindows, "窗口 2").start();
        new Thread(ticketWindows, "窗口 3").start();
    }

}

class TicketWindows extends Thread {
    private int tickets = 12;

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tickets > 0) {
                String name = Thread.currentThread().getName();
                System.out.println(name + ":正在发售第 " + tickets-- + " 张票");
            }
        }
    }
}
