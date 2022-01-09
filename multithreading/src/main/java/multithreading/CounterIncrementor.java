package multithreading;

public class CounterIncrementor implements Runnable {
  private static int counter;

  public static int getCounter() {
    return counter;
  }

  private static Object free = new Object();

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      log("przed");
//        incrementCounter();
//        incrCounterByThis();
      incrementCounterBySynchronizer();
      log("po: " + counter);
    }
  }

  private void log(String content) {
    System.out.println(Thread.currentThread() + " " + content);
  }

  private void incrementCounterBySynchronizer() {
    synchronized (free) {
      getAnInt();
    }
  }

  private void incrCounterByThis() {
    synchronized (this) {
      getAnInt();
    }
  }

  private synchronized void incrementCounter() {
    getAnInt();
  }

  private int getAnInt() {

    int tmp = counter;
    tmp++;
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    counter = tmp;

    return counter;
  }
}

