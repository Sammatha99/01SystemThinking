class ThreadExtendThread extends Thread {
    private  Addcount addcount = null;
    public ThreadExtendThread(Addcount addcount){
        this.addcount = addcount;
    }

    public void run(){
        for (int i=0; i < 1000; i++) {
            try {
                addcount.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ID:" + Thread.currentThread().getId() +
                    ", Name: " + Thread.currentThread().getName()
                    + ", shareVariable = " + addcount.getCount() /*shareVar*/);
        }
    }
}


class ThreadImRunnable implements Runnable {
    private int shareVar = 0 ; //biến share

    public int getShareVar() {
        return shareVar;
    }

    public synchronized void addVar (){
        synchronized (this){
            shareVar++;}
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