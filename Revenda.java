public class Revenda {
  private String regiao;
  private String estado;
  private String nomeMunicipio;
  private String nomePosto;
  private String cnpj;
  private String rua;
  private int numeroDaRua;
  private String complemento;
  private String bairro;
  private String cep;
  private String produto;
  private String valorCompra;
  private String valorVenda;
  private String medida;
  private String bandeira;

  public Revenda(String regiao, String estado, String nomeMunicipio, String nomePosto, String cnpj, String rua,
      int numeroDaRua, String complemento, String bairro, String cep, String produto, String valorVenda,
      String valorCompra, String medida, String bandeira) {
    this.regiao = regiao;
    this.estado = estado;
    this.nomeMunicipio = nomeMunicipio;
    this.nomePosto = nomePosto;
    this.cnpj = cnpj;
    this.rua = rua;
    this.numeroDaRua = numeroDaRua;
    this.complemento = complemento;
    this.bairro = bairro;
    this.cep = cep;
    this.produto = produto;
    this.valorCompra = valorCompra;
    this.valorVenda = valorVenda;
    this.medida = medida;
    this.bandeira = bandeira;
  }

  public String getRegiao() {
    return regiao;
  }

  public String getEstado() {
    return estado;
  }

  public String getNomeMunicipio() {
    return nomeMunicipio;
  }

  public String getNomePosto() {
    return nomePosto;
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getRua() {
    return rua;
  }

  public int getNumeroDaRua() {
    return numeroDaRua;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public String getCep() {
    return cep;
  }

  public String getProduto() {
    return produto;
  }

  public String getValorCompra() {
    return valorCompra;
  }

  public String getValorVenda() {
    return valorVenda;
  }

  public String getMedida() {
    return medida;
  }

  public String getBandeira() {
    return bandeira;
  }

  @Override
  public String toString() {
    return "Revenda [regiao=" + regiao + ", estado=" + estado + ", nomeMunicipio=" + nomeMunicipio + ", nomePosto="
        + nomePosto + ", cnpj=" + cnpj + ", rua=" + rua + ", numeroDaRua=" + numeroDaRua + ", complemento="
        + complemento + ", bairro=" + bairro + ", cep=" + cep + ", produto=" + produto + ", valorCompra=" + valorCompra
        + ", valorVenda=" + valorVenda + ", medida=" + medida + ", bandeira=" + bandeira + "]";
  }
  
}
