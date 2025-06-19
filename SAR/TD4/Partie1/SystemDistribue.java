public class SystemDistribue {

    public static void main(String[] args) {
        OD1I od1 = new OD1Impl();
        OD2I od2 = new OD2Impl();
        OD3I od3 = new OD3Impl();

        ProcessusP1 p1 = new ProcessusP1(od1, od2, od3);
        ProcessusP2 p2 = new ProcessusP2(od1, od2, od3);
        ProcessusP3 p3 = new ProcessusP3(od1, od2, od3);

        p1.start();
        p2.start();
        p3.start();

        try {
            p1.join();
            p2.join();
            p3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
