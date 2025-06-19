import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JTupleSpace {
    private List<JTuple> multiEnsemble;

    public JTupleSpace(JTuple... t) {
        multiEnsemble = new ArrayList<>(Arrays.asList(t));
    }

    public synchronized void ECR(JTuple t) {
        multiEnsemble.add(t);
        notifyAll();
    }

    public synchronized JTuple EXT(JTuple t) {
        while (!multiEnsemble.contains(t)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        JTuple tmp = multiEnsemble.get(multiEnsemble.indexOf(t));
        multiEnsemble.remove(t);
        return tmp;
        // ou return multiEnsemble.remove(multiEnsemble.indexOf(t));
        // et donc ne pas déclarer de variable tmp
    }

    public synchronized JTuple LEC(JTuple t) {
        while (!multiEnsemble.contains(t)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return multiEnsemble.get(multiEnsemble.indexOf(t));
    }

    public String toString() {
        return multiEnsemble.toString();
    }
}
