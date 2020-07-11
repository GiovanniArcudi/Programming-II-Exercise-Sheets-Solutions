/* EXERCISE:
   In this exercise you will modify the zoo gate counter that you wrote last week and make it threadsafe.

   Change your counter class so that no two Gates can increase the Counter at the same time (HINT: you may use the Counter's monitor).*/

import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.UnitCounter;

public class Counter implements UnitCounter {
    private int counter;

    @Override
    public synchronized void addOne() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
