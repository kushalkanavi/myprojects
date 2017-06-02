import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kushalkanavi on 5/19/17.
 */

// Runnable and ExecutorService
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ExerciseThread> threads = new ArrayList<ExerciseThread>();


        Scanner numberofthread = new Scanner(System.in);
        System.out.println("Enter number of threads to be created");
        int nothread = numberofthread.nextInt();

        ExecutorService executor = Executors.newFixedThreadPool(nothread);

        Scanner countofthread = new Scanner(System.in);
        System.out.println("Enter number of times thread should count");
        int cothread = countofthread.nextInt();

        System.out.println();

        // No of threads, How much should thread count
        for (int x = 0; x < (nothread*cothread); x += cothread) {
            ExerciseThread thread = new ExerciseThread(x, x + cothread);
            thread.start();
            threads.add(thread);
        }
        for(ExerciseThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        for (int x = 0; x < (nothread*cothread); x += cothread) {
            ThreadRunnable thread = new ThreadRunnable(x, x + cothread);
            Thread t = new Thread(thread);
            t.start();
        }

        //System.out.println();

        /*for (int x = 0; x < (nothread*cothread); x += cothread) {
            ExerciseThread thread = new ExerciseThread(x, x + cothread);
            executor.execute(new Thread(thread));
        }
        executor.shutdown();*/
    }
}