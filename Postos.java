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
  private ArrayList<Revenda> dados;

  public Postos() {
    revendas = new ArrayList<>();
    dados = new ArrayList<>();
  }

  public void cadastraPosto(Revenda revenda) {
    revendas.add(revenda);
    dados.add(revenda);
  }

  public ArrayList<Revenda> listaDados() {
    if (revendas == null)
      return null;
    return (ArrayList<Revenda>) revendas.clone();
  }

  public void salvaLista() {
    for (Revenda revenda : revendas){
      dados.add(revenda);
    }
  }

  public ArrayList<Revenda> mostraPostos(String nomePosto) {
    ArrayList<Revenda> pesquisaParteNome;
    pesquisaParteNome = new ArrayList<Revenda>();
    for (Revenda revenda : revendas) {
      revenda.getNomePosto();
      if (revenda.getNomePosto().contains(nomePosto)) {
        pesquisaParteNome.add(revenda);
        dados.add(revenda);
      }
    }
    if (pesquisaParteNome.size() > 0) {
      return pesquisaParteNome;
    } else
      return null;
  }

  public ArrayList<Revenda> ordenaPostosCrescente() {
    revendas.sort(new ComparaNomePostos());
    dados.addAll(revendas);
    return revendas;
  }

  public ArrayList<Revenda> ordenaPostosDecrescente() {
    revendas.sort(new ComparaNomePostos().reversed());
    dados.addAll(revendas);
    return revendas;
  }

  public void limpaDados() {
    dados.clear();
}

public boolean salvaDadosArquivo(String nomeArquivo) {
  String line = " ";
  try {
    File csvFile = new File(nomeArquivo + ".csv");
    PrintWriter out = new PrintWriter(csvFile);
    for(Revenda arquivo : dados){
      line = arquivo.toString();
      out.write(line);
    }
    out.close();
  }
  catch (IOException ex){
    System.err.println(ex);
    return false;
  }
  return true;
}
}