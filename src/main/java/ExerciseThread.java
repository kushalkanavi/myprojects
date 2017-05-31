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

    public void run()  {
        for (int i = start; i < end; ++i){
            System.out.println(Thread.currentThread().getName() + " - (A)Iteration Value: "+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("foo");
    }
}