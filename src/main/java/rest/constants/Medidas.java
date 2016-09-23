package rest.constants;

public enum Medidas {
 
  UNIDADE(1);
  
  private int valor;

  Medidas(int valor) {
      this.valor = valor;
  }

  public int constante() {
      return valor;
  }
}
