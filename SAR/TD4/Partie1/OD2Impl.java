public class OD2Impl implements OD2I {

    private boolean gFaite = false;

    public synchronized void G() {
        System.out.println("G");
        gFaite = true;
        notifyAll();
    }

    public synchronized void waitG() {
        while (!gFaite) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
