package multithreading;

import static multithreading.Multithreading.*;

public class CounterIncrementor implements Runnable {

    @Override
    public void run() {
        log("Entering thread " + Thread.currentThread());
        while (!free) {
            try {
                log("Start nap");
                Thread.sleep(10);
                log("Finished nap");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        log("Finished waiting");
        if (free) {
            log("Checked and free true");
            free = false;
            log("Setting free to false");
            for (int i = 0; i < 1000; i++) {
                int newCounter = counter;
                log("Counter is " + newCounter + " iteration number: " + i);
                newCounter += 1;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter = newCounter;
            }
            log("Setting free to true");
            free = true;
        } else {
            log("Checked and free is false");
        }
        log("Finished");
    }

    private void log(String content)  {
        System.out.println(Thread.currentThread() + content);
    }
}
