import java.util.ArrayList;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.FileSystemAlreadyExistsException;

public class Postos {

  ArrayList<Revenda> revendas = new ArrayList<Revenda>();

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
    if (revendas == null) return null;
    return (ArrayList<Revenda>) revendas.clone();
  }

  public Revenda pesquisaPorParteNome(String nomePosto){
    for (Revenda revenda : revendas) {
      if (revenda.getNomePosto().contains(nomePosto)) return revenda;
  }
  return null;
  }
}
