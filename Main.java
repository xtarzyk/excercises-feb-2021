public class Main {
    public static void main(String[] args) {

        int counter = 0;

        Runnable runnable;
        runnable = () -> counter++;

        Thread thread1 = new Thread(() -> counter++);
        runnable = thread1::run;
        Thread thread2 = new Thread(() -> counter++);
        Thread thread3 = new Thread(() -> counter++);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(counter);
    }
}
