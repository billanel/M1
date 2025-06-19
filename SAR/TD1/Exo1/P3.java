package Exo1;

public class P3 extends Thread {
    JobController bc;
    JobController ce;
    JobController eg;

    public P3(JobController bc, JobController ce, JobController eg) {
        this.bc = bc;
        this.ce = ce;
        this.eg = eg;
    }

    public void run() {
        bc.isJobDone();
        C();
        ce.jobDone();
        eg.isJobDone();
        G();
    }

    public void C() {
        System.out.print("C ");
    }

    public void G() {
        System.out.print("G ");
    }
}
