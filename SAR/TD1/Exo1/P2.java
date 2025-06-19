package Exo1;

public class P2 extends Thread {
    JobController ab;
    JobController bd;
    JobController bc;
    JobController de;
    JobController ce;
    JobController ef;
    JobController eg;

    public P2(JobController ab, JobController bd, JobController bc, JobController de, JobController ce,
            JobController ef, JobController eg) {
        this.ab = ab;
        this.bd = bd;
        this.bc = bc;
        this.de = de;
        this.ce = ce;
        this.ef = ef;
        this.eg = eg;
    }

    public void run() {
        ab.isJobDone();
        B();
        bd.jobDone();
        bc.jobDone();
        X();
        de.isJobDone();
        ce.isJobDone();
        E();
        ef.jobDone();
        eg.jobDone();
    }

    public void B() {
        System.out.print("B ");
    }

    public void X() {
        System.out.print("X ");
    }

    public void E() {
        System.out.print("E ");
    }
}
