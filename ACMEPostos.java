import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEPostos {

  private Postos posto;
  private Scanner in;

  public void inicializa() {
    posto = new Postos();
    in = new Scanner(System.in);

  }

  public void executa() {
    int opcao;
    try {
      do {
        System.out.println("--------- PÁGINA INICIAL --------");
        System.out.println("Escolha uma opção abaixo: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar arquivo");
        System.out.println("2 - Pesquisar por nome");
        System.out.println("3 - Listar todos os dados");
        System.out.println("4 - Classificar por nome (ordem crescente/decrescente)");
        System.out.println("5 - Salvar dados em arquivo");
        System.out.println("Opção escolhida: ");
        opcao = in.nextInt();
        switch (opcao) {
          case 0:
            break;
          case 1:
            cadastraArquivo();
            break;
          case 2:
            pesquisaNome();
            break;
          case 3:
            listaRevendas();
            break;
          /*
           * case 4:
           * classificaOrdem();
           * break;
           * case 5:
           * salvaArquivo();
           * break;
           */

          default:
            System.out.println("Opcao invalida");
            break;
        }
      } while (opcao != 0);
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
      executa();
    }
  }

  private void pesquisaNome() {
    try {
      System.out.println("Informe o nome do posto:");
      in.nextLine();
      String nome = in.nextLine();
      Revenda revenda = posto.pesquisaRevenda(nome);
      if (revenda == null) {
        System.out.println("Nenhum posto foi localizado com esse nome");
      } else {
        System.out.println(revenda.toString());
      }
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  private void listaRevendas() {
    try {
      System.out.println("Lista de postos:");
      ArrayList<Revenda> revenda = posto.listaDados();
      for (Revenda revendas : revenda) {
        System.out.println(revendas.toString());
      }
      if (revenda == null)
        System.out.println("Nenhum posto cadastrado");
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  public void cadastraArquivo() {
    System.out.println("Informe o diiretorio do arquivo:");
    in.nextLine();
    String nomeArquivo = in.nextLine();
    leArquivo(nomeArquivo);
  }

  public void leArquivo(String nomeArquivo) {
    Path path = Paths.get(nomeArquivo);
    try {
      BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
      String line = " ";
      String regiao;
      String estado;
      String nomeMunicipio;
      String nomePosto;
      String cnpj;
      String rua;
      String numeroRua;
      String complemento;
      String bairro;
      String cep;
      String produto;
      String valorVenda;
      String medida;
      String bandeira;
      while ((line = br.readLine()) != null) {
        String[] linhas = line.split(";");
        regiao = linhas[0];
        estado = linhas[1];
        nomeMunicipio = linhas[2];
        nomePosto = linhas[3];
        cnpj = linhas[4];
        rua = linhas[5];
        numeroRua = linhas[6];
        complemento = linhas[7];
        bairro = linhas[8];
        cep = linhas[9];
        produto = linhas[10];
        valorVenda = linhas[11];
        medida = linhas[12];
        bandeira = linhas[13];

        Revenda revenda = new Revenda(regiao, estado, nomeMunicipio, nomePosto, cnpj, rua,
            numeroRua, complemento, bairro, cep, produto, valorVenda, medida, bandeira);
        posto.cadastraPosto(revenda);
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
