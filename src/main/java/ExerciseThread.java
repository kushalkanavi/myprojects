/**
 * Created by kushalkanavi on 5/30/17.
 */
public class ExerciseThread extends Thread{


    public void run()  {
        for (int i=0;i<10;++i){
            System.out.println(Thread.currentThread().getName()+" - (A)Iteration Value: "+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExerciseThread1 extends Thread{
    public void run()  {
        for (int i=0;i<5;++i){
            System.out.println(Thread.currentThread().getName()+" - (B)Iteration Value: "+i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
