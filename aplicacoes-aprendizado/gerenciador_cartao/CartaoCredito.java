import java.util.ArrayList;
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
    public boolean compraValida(Compra compra) {
        if (this.saldo > compra.getValor()) {
            this.compras.add(compra);
            this.saldo -= compra.getValor();
            this.saldoDevedor = this.limite - this.saldo;
            return true;
        }
        return false;
    }
}