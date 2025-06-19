public class OD1Impl implements OD1I {

    private boolean aFaite = false;
    private boolean bFaite = false;
    private boolean cFaite = false;

    public synchronized void A() {
        System.out.println("A");
        aFaite = true;
        notifyAll();
    }

    public synchronized void waitA() {
        while (!aFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void B() {
        System.out.println("B");
        bFaite = true;
        notifyAll();
    }

    public synchronized void waitB() {
        while (!bFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void C() {
        System.out.println("C");
        cFaite = true;
        notifyAll();
    }

    public synchronized void waitC() {
        while (!cFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
