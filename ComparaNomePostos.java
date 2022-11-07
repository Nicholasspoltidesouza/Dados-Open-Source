import java.util.Comparator;

public class ComparaNomePostos implements Comparator {
  @Override
  public int compare(Object a, Object b) {
    Revenda r1, r2;
    r1 = (Revenda) a;
    r2 = (Revenda) b;
    return r1.getNomePosto().compareTo(r2.getNomePosto());
  }
}
