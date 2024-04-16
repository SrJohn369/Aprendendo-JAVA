public class FormatacaoDeTexto {
    /*
     * formatar textos em Java é utilizando o método format(),
     * da classe String. Esse método permite formatar um texto
     * utilizando diversos placeholders, que são representados pelo
     * caractere % seguido de uma letra que indica o tipo de dado que
     * será inserido no placeholder. Por exemplo, %s indica que uma String
     * será inserida no placeholder, %d indica um valor inteiro e %f indica um
     * valor de ponto flutuante. Vamos ver um exemplo:
     */
    public static void main(String[] args) {
        String nome = "Maria";
        int idade = 30;
        double valor = 55.9999;
        System.out.println(String.format("Meu nome é %s, eu tenho %d anos e hoje gastei %.2f reais", nome, idade, valor));

        /* também pode ser usado com Text Block */
        int aulas = 4;

        String mensagem = """
                Olá, %s!
                Boas vindas ao curso de Java.
                Teremos %d aulas para te mostrar o que é preciso para você dar o seu primeiro mergulho na linguagem!
                """.formatted(nome, aulas);

        System.out.println(mensagem);

    }
}
