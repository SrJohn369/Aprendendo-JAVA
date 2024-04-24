/*
 * Declare uma variável do tipo double precoProduto e
 * uma variável do tipo int (quantidade). Calcule o valor total
 * multiplicando o preço do produto pela quantidade e apresente 
 * o resultado em uma mensagem.
 */
public class PrecoDoProduto {
    public static void main(String[] args) {
        double precoProduto = 5.67;
        int quantidade = 45;

        double precoTotal = precoProduto * quantidade;

        System.out.printf("O valor total da compra é: %.2f", precoTotal);
    }
}
