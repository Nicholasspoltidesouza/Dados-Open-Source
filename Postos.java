import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.FileSystemAlreadyExistsException;

public class Postos {

  private ArrayList<Revenda> revendas;
  private ComparaNomePostos compara;

  public Postos() {
    revendas = new ArrayList<>();
  }

  public void cadastraPosto(Revenda revenda) {
    revendas.add(revenda);
  }

  public ArrayList<Revenda> listaDados() {
    if (revendas == null)
      return null;
    return (ArrayList<Revenda>) revendas.clone();
  }

  public ArrayList<Revenda> mostraPostos(String nomePosto) {
    ArrayList<Revenda> pesquisaParteNome;
    pesquisaParteNome = new ArrayList<Revenda>();
    for (int i = 0; i < revendas.size(); i++) {
      Revenda revenda = revendas.get(i);
      if (revenda.getNomePosto().contains(nomePosto)) {
        pesquisaParteNome.add(revenda);
      }
    }
    if (pesquisaParteNome.size() > 0) {
      return pesquisaParteNome;
    } else
      return null;
  }

  public ArrayList<Revenda> ordenaPostosCrescente() {
    revendas.sort(new ComparaNomePostos());
    return revendas;
  }
}