
/**
 * Created by kushalkanavi on 5/19/17.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {

        for (int x = 0; x < 5; x++) {
            ExerciseThread temp = new ExerciseThread();
            ExerciseThread1 temp1 =new ExerciseThread1();
            temp.start();
            temp1.start();
            try {
                temp.join(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                temp1.join(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}