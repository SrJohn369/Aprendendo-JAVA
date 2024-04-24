/*Peça ao usuário para inserir dois números inteiros. 
Compare os números e imprima uma mensagem indicando se 
são iguais, diferentes, o primeiro é maior ou
o segundo é maior. */

package PrimeirosPrograms;

import java.util.Scanner;;

public class VerifyNumber {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Digite o primeiro número INTEIRO: ");
        int primeiroNumero = leitor.nextInt();
        System.out.print("\nDigite o primeiro número INTEIRO: ");
        int segundoNumero = leitor.nextInt();

        if (primeiroNumero == segundoNumero) {
            System.out.println("Os números são iguais");
        } else if (primeiroNumero != segundoNumero) {
            System.out.println("Os números são diferentes");
            if (primeiroNumero > segundoNumero) {
                System.out.println("O primeiro número é maior que o segundo");
            } else {
                System.out.println("O segundo número é maior que o primeiro");
            }
        }
        leitor.close();
    }
}

