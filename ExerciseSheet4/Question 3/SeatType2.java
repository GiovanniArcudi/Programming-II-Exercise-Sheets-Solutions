import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.threading.Seat;

import java.util.concurrent.locks.ReentrantLock;

public class SeatType2 implements Seat {
    ReentrantLock leftFork;
    ReentrantLock rightFork;

    @Override
    public synchronized void askFork1() {
        leftFork.lock();
    }

    @Override
    public synchronized void askFork2() {
        rightFork.lock();
    }

    @Override
    public synchronized void assignForks(ReentrantLock reentrantLock, ReentrantLock reentrantLock1) {
        this.leftFork = reentrantLock;
        this.rightFork = reentrantLock1;
    }
}
