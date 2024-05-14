/*Crie um menu que oferece duas opções ao usuário: 
"1. Calcular área do quadrado" e "2. Calcular área do círculo". 
Solicite a escolha do usuário e realize o cálculo da área com 
base na opção selecionada. */

package primeirosprogramas;

import java.util.Scanner;

public class AreaCalculo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Escolha um Opção\n1. Calcular área do quadrado\n2. Calcular área do círculo.");
        int escolha = leitor.nextInt();

        switch (escolha) {
            case 1:
            // Area do Quadrado
                System.out.print("Digite o lado do quadarado: ");
                double lado = leitor.nextDouble();

                double areaQuadrado = lado * lado;
                System.out.println("A area deste quadrado é: " + areaQuadrado);
                break;
            case 2:
            // Area do Circulo
                System.out.print("Digite o raio do circulo: ");
                double raio = leitor.nextDouble();

                double areaCirculo = 3.14 * (raio * raio);
                System.out.println("A area deste circulo é: " + areaCirculo);
                break;
        
            default:
                System.out.println("Valor invalido");
                break;
        }

        leitor.close();
    }
}
