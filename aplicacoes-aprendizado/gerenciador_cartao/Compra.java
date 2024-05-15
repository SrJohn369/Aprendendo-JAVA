
public class Compra implements Comparable<Compra>{
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

    @Override
    public int compareTo(Compra outraCompra) {
        // OBS: Quer dizer que se quando compara o valor do Objeto atual com o 
        // valor do outro objeto ela vai ordenar os valores do menor para o maior
        // o inveso disso irá ordenar do maior para o menor
        return Double.valueOf(outraCompra.getValor()).compareTo(Double.valueOf(this.valor));
    }

    // MÉTODOS =================

}
