/* EXERCISE:
   In this exercise you will modify the zoo gate counter that you wrote last week and make it threadsafe.

   Change your counter class so that no two Gates can increase the Counter at the same time (HINT: you may use the Counter's monitor).*/

public class Gate implements Runnable {
    Counter counter;
    int visitorsNumber;

    public Gate (Counter counter, int visitorsNumber) {
        this.counter = counter;
        this.visitorsNumber = visitorsNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < visitorsNumber; i++) {
            counter.addOne();
        }
    }
}
