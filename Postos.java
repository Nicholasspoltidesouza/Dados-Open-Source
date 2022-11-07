import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.FileSystemAlreadyExistsException;

public class Postos  {

  private ArrayList<Revenda> revendas;

  public Postos() {
    revendas = new ArrayList<>();
  }

  public boolean cadastraPosto(Revenda revenda) {
    revendas.add(revenda);
    return true;
  }

  public Revenda pesquisaRevenda(String nome) {
    for (Revenda revenda : revendas) {
      if (revenda.getNomePosto().equals(nome)) {
        return revenda;
      }
    }
    return null;
  }

  public ArrayList<Revenda> listaDados() {
    if (revendas == null)
      return null;
    return (ArrayList<Revenda>) revendas.clone();
  }

  public Revenda pesquisaPorParteNome(String nomePosto) {
    for (Revenda revenda : revendas) {
      if (revenda.getNomePosto().contains(nomePosto))
        return revenda;
    }
    return null;
  }

  /*public List<ArrayList<Revenda>> getLista() {
    return Arrays.asList(revendas);
  }

  public List<ArrayList<Revenda>> ordemCrescente() {
    return Collections.sort(revendas);
  }

  @Override
  public int compareTo(Revenda revenda) {
    for (Revenda rev : revendas) {
      int nomeMun = Integer.parseInt(rev.getNomeMunicipio());
      if (nomeMun < nomeMun) {
        return -1;
      }
      if (nomeMun > nomeMun) {
        return 1;
      }
    }
    return 0;
  }*/
}
