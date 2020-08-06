import java.awt.*;

public class demo {
    public static Addcount count = new Addcount();

    public static void main(String[] args) throws InterruptedException {
/*
        Thread a = new Thread(new Runnable() {
            public void run() {
                for (int i= 0; i< 1000;i++) {
                    try {
                        count.add(); //phương thức sử dụng synchronized
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread b = new Thread(new Runnable() {
            public void run() {
                for (int i= 0; i< 1000;i++) {
                    try {
                        count.add(); //phương thức sử dụng synchronized
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        a.start();
        b.start();
        a.join();
        b.join();
         System.out.println(count.getCount());*/

        ThreadImRunnable shareThread = new ThreadImRunnable();
        Thread thread0 = new Thread(shareThread);
        thread0.setName("Luồng 1");
        thread0.start();

        Thread thread1 = new Thread(shareThread);
        thread1.setName("Luồng 2");
        thread1.start();

        System.out.println("Giá trị thuộc tính shareVariable = " + shareThread.getShareVar());
    }
}
