public class OD3Impl implements OD3I {

    private boolean eFaite = false;
    private boolean fFaite = false;

    public synchronized void E() {
        System.out.println("E");
        eFaite = true;
        notifyAll();
    }

    public synchronized void waitE() {
        while (!eFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void F() {
        System.out.println("F");
        fFaite = true;
        notifyAll();
    }

    public synchronized void waitF() {
        while (!fFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
