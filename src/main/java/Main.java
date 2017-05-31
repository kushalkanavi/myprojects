import java.util.ArrayList;
import java.util.List;

/**
 * Created by kushalkanavi on 5/19/17.
 */

// Runnable and ExecutorService
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<ExerciseThread> threads = new ArrayList<ExerciseThread>();

        // No of threads, How much should thread count
        for (int x = 0; x < 100; x += 10) {
            ExerciseThread thread = new ExerciseThread(x, x + 10);
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
    }
}