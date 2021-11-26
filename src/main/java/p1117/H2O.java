package p1117;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class H2O {

     Semaphore h = new Semaphore(2);

     Semaphore o = new Semaphore(1);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if (h.availablePermits() == 0 && o.availablePermits() == 0) {
            h.release(2);
            o.release(1);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        if (h.availablePermits() == 0 && o.availablePermits() == 0) {
            h.release(2);
            o.release(1);
        }
    }


    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(1);

        int n = 12;

        Runnable[] runnables = new Runnable[]{
                () -> System.out.println("O"),
                () -> System.out.println("H"),
                () -> System.out.println("H")
        };

        H2O h2O = new H2O();

        for (int i = 0; i < n; i++) {
            int idx = i % 3;

            new Thread(() -> {
                try {
                    downLatch.await();
                    if (idx == 0) {
                        h2O.oxygen(runnables[idx]);
                    } else {
                        h2O.hydrogen(runnables[idx]);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        downLatch.countDown();
    }
}
