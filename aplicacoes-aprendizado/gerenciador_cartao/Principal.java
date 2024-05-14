import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        // LER DADOS ========================
        Scanner lerDados = new Scanner(System.in);

        // INICIAR CLASSES ====================
        CartaoCredito myCard = new CartaoCredito();
        
        // LAÇO DE ESCOLHA ====================
        while (true) {

            System.out.println("\n================ MENU CARTÃO ================\n"
                                + "1\tComparar coisas no cartão\n2\tVerificar cartão\n"
                                + "99\tFinalizar");
            int escolha = lerDados.nextInt();

            switch (escolha) {
                // Comparar coisas no cartão
                case 1:
                    System.out.println("""
                            1 - Camisa R$ 45,90                 2 - Calça R$ 37,90
                            3 - Hamburger R$ 29,80              4 - Jogo R$ 67,90
                            5 - Computador Gamer R$ 1.599,99    6 - Celula R$ 899,99
                            """);
                    int escolhaCompra = lerDados.nextInt();     
                    switch (escolhaCompra) {
                        //Camisa R$ 45,90
                        case 1:
                            
                            break;
                    
                        default:
                            break;
                    }
                    break;

                // Verificar cartão
                case 2:
                    System.out.printf(
                        "==== DADOS E FATURA DO CARTÃO ====\n" 
                        + "LIMITE:\tR$ %.2f\n"
                        + "LIMITE DISPONÍVEL:\t %.2f\n"
                        + "FATURA:\t %.2f\n"
                        + "++++++ COMPRAS ++++++\n", 
                        myCard.getLimite(), myCard.getSaldo(), myCard.getSaldoDevedor()

                    );
                    break;
                case 99:
                    // FINALIZAR TUDO
                    break;
                default:
                    break;
            }
            if (escolha == 99) {
                lerDados.close();
                break;
            }

        }
        
    }
}