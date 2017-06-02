import java.util.IllegalFormatException;

/**
 * Created by kushalkanavi on 5/30/17.
 */
public class ExerciseThread extends Thread {

    private final int start;
    private final int end;

    public ExerciseThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() throws RuntimeException {
        for (int i = start; i < end; ++i){
            System.out.println(Thread.currentThread().getName() + " - (A)Iteration Value: "+i+" Thread");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("foo");
    }
}

class ThreadRunnable implements Runnable{

    private int Start;
    private int End;

    public ThreadRunnable(int start, int end) {
        Start = start;
        End = end;
    }

    public void run() {
        for (int i = Start; i < End; ++i){
            System.out.println(Thread.currentThread().getName() + " - (A)Iteration Value: "+i+" Runnable");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}