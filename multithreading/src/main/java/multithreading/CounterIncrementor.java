package multithreading;
import static multithreading.Multithreading.counter;

public class CounterIncrementor implements Runnable {


  @Override
  public void run() {

    for (int i = 0; i < 1000; i++) {
      int newCounter = counter;
      newCounter += 1;
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      counter = newCounter;
    }
  }
}

