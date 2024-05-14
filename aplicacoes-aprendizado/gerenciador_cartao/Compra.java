
public class Compra {
    // ATRIBUTOS =================
    private double valor;
    private String produto;

    // CONSTRUTOR =================
    public Compra(double valor, String produto) {
        this.valor = valor;
        this.produto = produto;
    }

    // GETTERS SETTERS =================
    public double getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    // MÉTODOS =================

}
