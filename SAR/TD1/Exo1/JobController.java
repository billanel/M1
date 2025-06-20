package Exo1;

public class JobController {

    boolean done = false;

    synchronized public void jobDone() {
        done = true;
        this.notify();
    }

    synchronized public void isJobDone() {
        if (!done) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
