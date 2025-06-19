public class DinerPhilosophes {

    public static void main(String[] args) {
        JTuple F1 = new JTuple(1);
        JTuple F2 = new JTuple(2);
        JTuple F3 = new JTuple(3);
        JTupleSpace table = new JTupleSpace(F1, F2, F3);

        Philosophe p1 = new Philosophe("Philo1", new JTuple(Integer.valueOf(1)), new JTuple(Integer.valueOf(2)), table);
        Philosophe p2 = new Philosophe("Philo2", new JTuple(Integer.valueOf(2)), new JTuple(Integer.valueOf(3)), table);
        Philosophe p3 = new Philosophe("Philo3", new JTuple(Integer.valueOf(3)), new JTuple(Integer.valueOf(0)), table);

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
