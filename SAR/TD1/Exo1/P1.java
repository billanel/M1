package Exo1;

public class P1 extends Thread {
    JobController ab;
    JobController bd;
    JobController de;
    JobController ef;

    public P1(JobController ab, JobController bd, JobController de, JobController ef) {
        this.ab = ab;
        this.bd = bd;
        this.de = de;
        this.ef = ef;
    }

    public void run() {
        A();
        ab.jobDone();
        bd.isJobDone();
        D();
        de.jobDone();
        ef.isJobDone();
        F();
    }

    public void A() {
        System.out.print("A ");
    }

    public void D() {
        System.out.print("D ");
    }

    public void F() {
        System.out.print("F ");
    }
}
