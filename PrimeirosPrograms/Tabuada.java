/*Crie um programa que solicite ao usuário um número e 
exiba a tabuada desse número de 1 a 10. */

package PrimeirosPrograms;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite um número pra saber sua tabuada: ");
        int num = leitor.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", i, num, (i * num));
        }
        leitor.close();
    }
}
