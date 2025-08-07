
/*RUNNABLE 상태에서 yield() 메서드를 이용한 CPU 사용 양보*/

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
        	try{Thread.sleep(1000);} catch(InterruptedException e) {}
            System.out.println(name + " - " + i);
            Thread.yield();  // 다른 스레드에게 양보            
        }
    }
}

public class YieldInRunnableState_re {
    public static void main(String[] args) {
        Thread threadA = new Thread(new MyRunnable("Thread-A"));
        Thread threadB = new Thread(new MyRunnable("Thread-B"));

        threadA.start();
        threadB.start();
    }
}

