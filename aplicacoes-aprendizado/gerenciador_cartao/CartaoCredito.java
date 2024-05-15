import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class CartaoCredito {
    // ATRIBUTOS =================
    private double limite;
    private double saldo;
    private double saldoDevedor;
    private List<Compra> compras;
    
    // CONSTRUTOR =================
    public CartaoCredito() {
        // Gerar um valor aleatório
        Random geradorCredito = new Random();
        // Dessa forma o valor vai ficar entre 500 - 2000
        this.limite = geradorCredito.nextInt(1501) + 500;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    // GETTERS SETTERS =================
    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    @Override
    public String toString() {
        return "CartaoCredito [limite=" + limite + ", saldo=" + saldo + ", compras=" + compras + "]";
    }
    
    // MÉTODOS =================
    private boolean compraValida(Compra compra) {
        if (this.saldo > compra.getValor()) {
            this.compras.add(compra);
            this.saldo -= compra.getValor();
            this.saldoDevedor = this.limite - this.saldo;
            return true;
        }
        return false;
    }

    public void comprar(Compra compra) {
        if (compraValida(compra)) {
            System.out.println(
                "\n=== COMPRA REALIZADA COM SUCESSO! ===\n"
                + "\tProduto:\t" + compra.getProduto()
                + "\n\tValor:\t\tR$ " + compra.getValor()
                + "\n========================================"
            );        
        } else {
            System.out.printf(
                "\n=== COMPRA NEGADA! =====\n"
                + "SALDO INSUFICIENTE\n"
                + "SALDO ATUAL: R$ " + "%.2f"
                + "\n========================\n", this.saldo
            );
        }
    }

    public String listarCompras() {
        Collections.sort(compras);
        String tabelaDados = "Produto\t\tValor(R$)\n";

        for (Compra compra: this.compras) {
            tabelaDados += compra.getProduto() + "\t\t" + compra.getValor() + "\n";
        }

        return tabelaDados;
    }
}