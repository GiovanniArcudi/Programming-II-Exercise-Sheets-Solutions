import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class SeatType1 implements Seat {
    ReentrantLock leftFork;
    ReentrantLock rightFork;

    @Override
    public synchronized void askFork1() {
        rightFork.lock();
    }

    @Override
    public synchronized void askFork2() {
        leftFork.lock();
    }

    @Override
    public synchronized void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {
        this.leftFork = reentrantLock;
        this.rightFork = reentrantLock1;
    }
}
