public class Ctrl {

    private boolean aFaite = false;
    private boolean bFaite = false;
    private boolean cFaite = false;

    public synchronized void waitA() {
        if (!aFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void signalerA() {
        aFaite = true;
        notifyAll();
    }

    public synchronized void waitB() {
        if (!bFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void signalerB() {
        bFaite = true;
        notifyAll();
    }

    public synchronized void waitC() {
        if (!cFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void signalerC() {
        bFaite = true;
        notifyAll();
    }

}
