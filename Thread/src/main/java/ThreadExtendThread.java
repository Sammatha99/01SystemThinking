class ThreadExtendThread extends Thread {
    private  String name;

    public ThreadExtendThread(Addcount a , String name){
        this.name = name;
    }
    public void run(Addcount a){
        for (int i=0; i < 1000; i++) {
            //a.add();
        }
    }
}


class ThreadImRunnable implements Runnable {
    private int shareVar = 0 ;

    public int getShareVar() {
        return shareVar;
    }

    public /*synchronized*/ void addVar (){
        shareVar++ ;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            addVar();
            System.out.println("ID:" + Thread.currentThread().getId() +
                    ", Name: " + Thread.currentThread().getName()
                    + ", shareVariable = " + shareVar);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}