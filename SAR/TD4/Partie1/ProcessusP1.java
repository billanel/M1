public class ProcessusP1 extends Thread {

    private OD1I od1;
    private OD2I od2;
    private OD3I od3;

    public ProcessusP1(OD1I o1, OD2I o2, OD3I o3) {
        this.od1 = o1;
        this.od2 = o2;
        this.od3 = o3;
    }

    public void run() {
        od1.waitA();
        od1.waitB();
        od3.waitE();
        od2.G();
        od1.waitC();
        od3.waitF();
    }

}
