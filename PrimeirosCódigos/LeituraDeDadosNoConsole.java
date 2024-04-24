import java.util.Scanner;

public class LeituraDeDadosNoConsole {
    public static void main(String[] args) {
        Scanner scanear = new Scanner(System.in);

        System.out.print("Digite um nome ou palavra qualquer: ");
        String nomePalavra = scanear.nextLine();
        System.out.println("Digite um número inteiro: ");
        int numeroInteiro = scanear.nextInt();
        System.out.println("Digite um número com ponto flutuante: ");
        double numeroDouble = scanear.nextDouble();

        System.out.printf(
            "Nome: %s\nNúmero Inteiro: %d\nNúmero de ponto flutuante: %.1f", nomePalavra, numeroInteiro, numeroDouble
        );
        scanear.close();
    }
}
