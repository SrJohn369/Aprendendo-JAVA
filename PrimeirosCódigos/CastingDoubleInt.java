// Declare uma variável do tipo double e uma variável do tipo int. 
// Faça o casting da variável double para int e imprima o resultado.

public class CastingDoubleInt {

    public static void main(String[] args) {
        double var1 = 9.6;
        int var2 = 5;

        int resultado = (int) (var1 + var2);

        System.out.printf("resultado da soma %.1f + %d = %d", var1, var2, resultado);
    }
}