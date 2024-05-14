/*
 * Crie um programa que simula um jogo de adivinhação, que deve gerar um
 * número aleatório entre 0 e 100 e pedir para que o usuário tente adivinhar 
 * o número, em até 5 tentativas. A cada tentativa, o programa deve informar 
 * se o número digitado pelo usuário é maior ou menor do que o número gerado.
 * 
 */

package primeiros.programs;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinha {
    public static void main(String[] args) {
        int numeroCerto = new Random().nextInt(100);
        Scanner leia = new Scanner(System.in);
        int contadorTentativas = 1;

        System.out.println("Adivinhe o número que escolhi.\nDica está entre 0 e 100 (inclusíve).\n\nVocê tem 5 tentativas");
        while (true) {
            System.out.println("Qual número escolhi?");
            System.out.print("Digite o número: ");
            int valorDigitado = leia.nextInt();

            if (valorDigitado == numeroCerto) {
                System.out.printf("PARABÉNS VOCÊ ACERTOOOOU!! EM APENAS %d TENTATIVAS.", contadorTentativas);
                leia.close();
                break;
            } else {
                if (contadorTentativas == 5) {
                    System.out.printf("Que pena suas tentatvivas acabaram. O número certo é %d\n\t\tFIM DE JOGO", numeroCerto);
                    leia.close();
                    break;
                }
                System.out.println("\nSua respota está errada tente de novo!");
                if (numeroCerto > valorDigitado) {
                    System.out.println("Dica: " + "É um número mais ALTO\n");
                } else {
                    System.out.println("Dica: " + "É um número mais BAIXO\n");
                }
                contadorTentativas++;
            }
        }
    }
}
