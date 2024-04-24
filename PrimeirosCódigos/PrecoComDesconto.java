public class PrecoComDesconto {
    public static void main(String[] args) {
        double precoOriginal = 45.70;
        double desconto = 0.25;
        double precoComDesconto = precoOriginal - (precoOriginal * desconto);

        System.out.printf(
            "O preço R$%.2f teve 25%% de desconto ficando com valor de R$%.2f",
            precoOriginal, precoComDesconto
        );
    }
}
