public class Multithreading {

    private static int counterFinal;

    public static void main(String[] args) throws InterruptedException {


        Runnable runnable = () -> {
            int counter = 0;
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
            counterFinal += counter;
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counterFinal);
        System.out.println(counterFinal);


    }
}
