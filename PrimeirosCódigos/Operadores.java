public class Operadores {
    public static void main(String[] args) {

        //OPERADORES ARITIMÉTICOS

        //ADIÇÃO (+)
        int r1 = 5 + 2;
        System.out.println(r1);


        //SUBTRAÇÃO (-)
        int r2 = 5 - 2;
        System.out.println(r2);


        //MULTIPLICAÇÃO (*)
        int r3 = 5 * 2;
        System.out.println(r3);


        //DIVISÃO (/)
        double r4 = 5 / 2;
        System.out.println(r4);


        //RESTO (%)
        int r5 = 5 % 2;
        System.out.println(r5);


        /* ORDEM DE PRECEDÊNCIA
         * multiplicação, divisão
         * resto
         * soma, subtração
         */

        //OPERADORES UNÁRIOS
        int a = 3;
        a ++; // ---> a = a + 1
        a --; // ---> a = a - 1
        System.out.println(a);

        //PÓS-INCREMENTO
        int numero = 6;
        int valor = 4 + numero++;
        /* como o ++ vem depois do número ele é acrescentado apenas após a soma do 6 + 4 (o mesmo se aplica ao -- ) */
        System.out.println(valor); //resultado 10

        //PRÉ-INCREMENTO
        int numero2 = 6;
        int valor2 = 4 + ++numero2;
        /* como o ++ vem antes do número, o 4 vai somar com 6 já pré-incrementado com 1 (o mesmo se aplica ao -- ) */
        System.out.println(valor2); //resultado 11


        //OPERADORES DE ATRIBUIÇÃO
        // += ---> Somar e atribuir
        int x = 8;
        x += 2; // ou x = x + 2
        System.out.println(x);

        // -= ---> Subtrair e atribuir
        x -= 2; // ou x = x - 2
        System.out.println(x);

        // *= ---> Multiplicar e atribuir
        x *= 2; // ou x = x * 2
        System.out.println(x);

        // /= Dividir e atribuir
        x /= 2; // ou x = x / 2
        System.out.println(x);

        // %= ---> resto e atribuir
        x %= 2; // ou x = x % 2
        System.out.println(x);


        /* CLASSE Math --> Essa classe possui constantes e
        métodos internos para a realização de cálculos matemáticos */

        //PI ---> Constante π
        System.out.println(Math.PI);

        //pow ---> Exponenciação/Potência
        System.out.println(Math.pow(7, 2)); // 7: base, 2:expoente

        //sqrt ---> Raiz Quadrada
        System.out.println(Math.sqrt(25));

        //cbrt ---> Raiz Cúbica
        System.out.println(Math.cbrt(27));

        //Arredondamentos
        // abs ---> Valor Absoluto
        System.out.println(Math.abs(-4.7)); //vai mostrar apenas o número independente do sinal

        //floor ---> Arredondamento para baixo
        System.out.println(Math.floor(4.7)); //resultado 4

        //ceil ---> Arredondamento para cima
        System.out.println(Math.ceil(4.7)); //resultado 5

        //round ---> Arredonda Aritimeticamente
        System.out.println(Math.round(4.7)); //resultado 5, Se fosse 4.1 até 4.4 o resultado seria 4
    }
}
