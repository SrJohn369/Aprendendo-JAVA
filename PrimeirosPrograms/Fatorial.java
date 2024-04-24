/*Crie um programa que solicite ao usuário um 
número e calcule o fatorial desse número. */

package PrimeirosPrograms;

import java.util.Scanner;;

public class Fatorial {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o numero para calcular o fatorial: ");
        int fatorando = leitor.nextInt();
        int result = 1;

        for (int i = fatorando; i > 0 ; i--) {
            result *= i;
            System.out.println(result);
        }

        System.out.println("O fatorial de " + fatorando + "! é igual a: " + result);

        leitor.close();
    }
}
