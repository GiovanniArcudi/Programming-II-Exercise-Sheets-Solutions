public class Belt extends CyclicQueue {
    private final Object lockEnqueue = new Object();
    private final Object lockDequeue = new Object();
    private final Object lockWaitNotify = new Object();

    // Class constructor.
    public Belt(int capacity) {
        super(capacity);
    }

    @Override
    public void enqueue(int i) {
        synchronized (lockEnqueue) {
            while (isFull()) {
                try {
                    synchronized (lockWaitNotify) {
                        lockWaitNotify.wait();
                    }
                } catch (InterruptedException ignore) { }
            }
            super.enqueue(i);

            synchronized (lockWaitNotify) {
                lockWaitNotify.notify();
            }
        }
    }

    @Override
    public int dequeue() {
        int output;

        synchronized (lockDequeue) {
            while (isEmpty()) {
                try {
                    synchronized (lockWaitNotify) {
                        lockWaitNotify.wait();
                    }
                } catch (InterruptedException ignore) { }
            }
            output = super.dequeue();

            synchronized (lockWaitNotify) {
                lockWaitNotify.notify();
            }
            return output;
        }
    }
}
