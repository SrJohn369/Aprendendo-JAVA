/*
 * Declare uma variável do tipo double valorEmDolares. 
 * Atribua um valor em dólares a essa variável. Considere 
 * que o valor de 1 dólar é equivalente a 4.94 reais. Realize a 
 * conversão do valor em dólares para reais e imprima o resultado formatado.
 */

public class ValorEmDolar {
    public static void main(String[] args) {
        double valoDoDolar = 4.94;
        double qntDeDolares = 1200;

        double valorEmReais = valoDoDolar * qntDeDolares;

        System.out.printf("A conversão de $%.2f dólar em Real é: R$%.2f reais", qntDeDolares, valorEmReais);
    }
}
