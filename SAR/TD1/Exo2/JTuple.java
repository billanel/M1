import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class JTuple {
    private final List<Object> contenu;

    public JTuple(Object... t) {
        contenu = new ArrayList<>(Arrays.asList(t));
    }

    public String toString() {
        return "<" + contenu.toString() + ">";
    }

    public boolean equals(Object o) {
        return (o instanceof JTuple) && ((JTuple) o).contenu.equals(contenu);
    }

    public boolean match(JTuple t) {
        return this.equals(t);
    }
}
