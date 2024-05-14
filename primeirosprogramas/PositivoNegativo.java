/*Crie um programa que solicite ao usuário digitar um número.
Se o número for positivo, exiba "Número positivo", caso contrário, 
exiba "Número negativo". */

package primeiros.programs;

import java.util.Scanner;

public class PositivoNegativo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = leitor.nextInt();

        if (numero > 0) {
            System.out.println("O número é positivo!");
        } else {
            System.out.println("O número é negativo!");
        }
        
        leitor.close();
    }
}
