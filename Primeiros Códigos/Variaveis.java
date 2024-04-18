public class Variaveis {

    public static void main(String[] args) {
        // texto é nome da referencia que eu usei para um determinado tipo (variável)
        // que fica armazenada dentro dos eslotes da memória ram
        // variável para texto
        var texto = "Olá";
        texto = "Mundo";
        System.out.println(texto);

        //variável para números
        var num = 10;
        num = 8;
        System.out.println(num);

        // variáveis -> tipo: Textos (Strings)
        // variáveis -> tipo: Números (Int)
        // variáveis -> tipo: Números Reais (Double)
        // variáveis -> tipo: Booleanas (verdadeiro ou falso)

        // TIPOS DE DADOS

        // tipo  NomeDaReferencia = ConteudoDaReferencia
        String login = "Ola"; // Representação de Texto (ASCII)
        int num2 = 12; // Representação de Números Inteiros
        double percent = 34.7; // Representação de Números Reais
        boolean is_driver = true; // Representação Booleana (Estado verdadeiro ou falso)

        System.out.println(login);
        System.out.println(num2);
        System.out.println(percent);
        System.out.println(is_driver);

        // varáveis
        // SÃO ESPAÇOS DE MEMÓRIA ALOCADO (REPRESENTADO POR TIPOS)

        int number; // Declarando variavel
        number = 78; // Uma vez declarada eu posso atribuir um valor pra ela
        System.out.println(number + 10);
    }
}
