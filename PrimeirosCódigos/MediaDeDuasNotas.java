// Crie um programa que realize a média de duas notas decimais e exiba o resultado.
public class MediaDeDuasNotas {
    public static void main(String[] args) {
        double nota1 = 7.8;
        double nota2 = 9.4;
        double media = (nota1 + nota2) / 2;

        String mensagem = "A média das notas %.2f e %.2f é igual a %.2f";

        System.out.println(String.format(mensagem, nota1, nota2, media));
    }
}
