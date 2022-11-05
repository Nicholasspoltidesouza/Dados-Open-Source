import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ACMEEnergy {

  private Conglomerado conglomerado;
  private Scanner in;

  public void inicializa() {
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
        System.out.println("4 - Classificar por nome (ordem crescente/decrescente");
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
            listaDados();
            break;
          case 4:
            classificaOrdem();
            break;
          case 5:
            salvaArquivo();
            break;

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
      System.out.println("Informe o nome do municipio:");
      in.nextLine();
      String nome = in.nextLine();
      Usina usina = conglomerado.pesquisaUsina(nome);
      if (usina == null) {
        System.out.println("Nenhuma usina foi localizada com esse nome");
      } else {
        if (usina instanceof UsinaRenovavel) {
          System.out.println(
              "" + usina.getNome() + " Producao de MWH:" + usina.getProducaoMWh() + " Custo MWH:" + usina.getCustoMWh()
                  + " Fonte de energia:" + ((UsinaRenovavel) usina).getFonteDeEnergia());
        }
        if (usina instanceof UsinaNaoRenovavel) {
          System.out.println(
              "" + usina.getNome() + " Producao de MWH:" + usina.getProducaoMWh() + " Custo MWH:" + usina.getCustoMWh()
                  + " Combustivel:" + ((UsinaNaoRenovavel) usina).getCombustivel() + " Durabilidade (anos):"
                  + ((UsinaNaoRenovavel) usina).getDurabilidade());
        }
      }
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  private void listaUsinas() {
    try {
      System.out.println("Lista de usinas:");
      ArrayList<Usina> usina = conglomerado.listaTodasUsinas();
      for (Usina usinas : usina) {
        if (usinas instanceof UsinaRenovavel) {
          System.out.println("" + usinas.getNome() + " Producao de MWH:" + usinas.getProducaoMWh() + " Custo MWH:"
              + usinas.getCustoMWh()
              + " Fonte de energia:" + ((UsinaRenovavel) usinas).getFonteDeEnergia() + "\n");
        }
        if (usinas instanceof UsinaNaoRenovavel) {
          System.out.println(" " + usinas.getNome() + " Producao de MWH:" + usinas.getProducaoMWh() + " Custo MWH:"
              + usinas.getCustoMWh()
              + " Combustivel:" + ((UsinaNaoRenovavel) usinas).getCombustivel() + " Durabilidade (anos):"
              + ((UsinaNaoRenovavel) usinas).getDurabilidade() + "\n");
        }
      }
      if (usina == null)
        System.out.println("Nenhuma usina cadastrada");
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  private void consultaPreco() {
    try {
      System.out.println("Informe o nome da usina que deseja consultar o preco:");
      in.nextLine();
      String nome = in.nextLine();
      System.out.println(conglomerado.consultaPreco(nome));
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  private void salvaArquivo() {
    try {
      System.out.println("Informe o nome do arquivo em que os dados serao salvos:");
      in.nextLine();
      String nomeArquivo = in.nextLine();
      conglomerado.salvaDadosArquivo(nomeArquivo);
    } catch (InputMismatchException ex) {
      in.nextLine();
      System.err.println("Erro: entrada de dados incorreta.");
    }
  }

  public String leArquivo() {
    System.out.println("Informe o diretorio do arquivo:");
    in.nextLine();
    String path = in.nextLine();
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
    String valorCompra; 
    String medida; 
    String bandeira;
    try {
      BufferedReader br = new BufferedReader(new FileReader(path));
      while ((line = br.readLine()) != null) {
        String[] linhas = line.split(";");
        regiao = linhas[0];
        estado = linhas[1];
        nomeMunicipio = linhas[2];
        nomePosto = linhas[3];
        cnpj = linhas[4];
        rua = linhas[5];
        numeroRua = linhas[6];
        int numeroDaRua = Integer.parseInt(numeroRua);
        complemento = linhas[7];
        bairro = linhas[8];
        cep = linhas[9];
        produto = linhas[10];
        valorVenda = linhas[11];
        valorCompra = linhas[12];
        medida = linhas[13];
        bandeira = linhas[14];
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
