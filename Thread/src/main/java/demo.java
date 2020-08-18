import java.awt.*;
import java.util.concurrent.*;

public class demo {
    public static Addcount count = new Addcount();

    public static void main(String[] args) throws InterruptedException {
        /*
        Thread a = new Thread(new Runnable() {
            public void run() {
                for (int i= 0; i< 1000;i++) {
                    try {
                        count.add(); //phương thức sử dụng synchronized
                        Thread.sleep(10);
                        System.out.println(count.getCount());
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
                        Thread.sleep(10);
                        System.out.println(count.getCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        a.start();
        b.start();
        //a.join();
        //b.join();
*/
 /*       ThreadImRunnable shareThread = new ThreadImRunnable();

        Thread thread0 = new Thread(shareThread);
        thread0.setName("Luồng 1");
        thread0.start();


        Thread thread1 = new Thread(shareThread);
        thread1.setName("Luồng 2");
        thread1.start();
*/
        Addcount a = new Addcount();
        Thread thread0 = new ThreadExtendThread(a);
        Thread thread1 = new ThreadExtendThread(a);

        thread0.setName("luong 1");
        thread1.setName("luong 2");

        thread0.start();
        thread1.start();


    }
}
