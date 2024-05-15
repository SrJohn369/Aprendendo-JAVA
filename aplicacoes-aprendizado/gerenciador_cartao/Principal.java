import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        // LER DADOS ========================
        Scanner lerDados = new Scanner(System.in);

        // INICIAR CLASSES ====================
        CartaoCredito myCard = new CartaoCredito();

        // 
        
        // LAÇO DE ESCOLHA ====================
        while (true) {

            System.out.print("\n================ MENU CARTÃO ================\n"
                                + "1\tComparar coisas no cartão\n2\tVerificar cartão\n"
                                + "99\tFinalizar"
                                + "\nEscolha: "
                                );
            int escolha = lerDados.nextInt();

            switch (escolha) {
                // Comparar coisas no cartão
                case 1:
                    System.out.print("""
                        ==================== PRODUTOS A VENDA ===========================

                            1 - Camisa R$ 45,90                 2 - Calça R$ 37,90
                            3 - Hamburger R$ 29,80              4 - Jogo R$ 67,90
                            5 - Computador Gamer R$ 1.599,99    6 - Celula R$ 899,99

                            ========================================================
                            Escolha: """
                    );
                    int escolhaCompra = lerDados.nextInt();     
                    switch (escolhaCompra) {
                        //Camisa R$ 45,90
                        case 1:
                            Compra camisaCompra = new Compra(45.90, "Camisa");
                            myCard.comprar(camisaCompra);;
                            break;
                    
                        // Calça R$ 37,90
                        case 2: 
                            Compra calcaCompra = new Compra(37.90, "Calça");
                            myCard.comprar(calcaCompra);
                            break;

                        // Hamburger R$ 29,80
                        case 3:
                            Compra hamburgerCompra = new Compra(29.80, "Hamburger");
                            myCard.comprar(hamburgerCompra);
                            break;

                        // Jogo R$ 67,90
                        case 4:
                            Compra jogoCompra = new Compra(67.90, "Jogo");
                            myCard.comprar(jogoCompra);
                            break;

                        // Computador Gamer R$ 1.599,99
                        case 5:
                            Compra computadorCompra = new Compra(1_599.99, "Computador");
                            myCard.comprar(computadorCompra);
                            break;

                        // Celula R$ 899,99
                        case 6:
                            Compra celulaCompra = new Compra(899.99, "Celula");
                            myCard.comprar(celulaCompra);
                            break;
                        
                        default:
                            System.out.println("============ VALOR INVÁLIDO =============");
                            break;
                    }
                    break;

                // Verificar cartão
                case 2:
                    System.out.printf(
                        "\n==== DADOS E FATURA DO CARTÃO ====\n" 
                        + "LIMITE:\t\t\tR$ %.2f\n"
                        + "LIMITE DISPONÍVEL:\tR$ %.2f\n"
                        + "FATURA:\t\t\tR$ %.2f\n"
                        + "\n++++++ COMPRAS ++++++\n\n"
                        + "%s"
                        + "\n====================================\n", 
                        myCard.getLimite(), myCard.getSaldo(), 
                        myCard.getSaldoDevedor(), myCard.listarCompras()
                    );
                    break;

                // FINALIZAR TUDO
                case 99:
                    System.out.println("\n ============ PROGRAMA FINALIZADO =============");
                    break;

                // VALOR INVÁLIDO
                default:
                    System.out.println("============ VALOR INVÁLIDO =============");
                    break;
            }
            if (escolha == 99) {
                lerDados.close();
                break;
            }

        }
        
    }
}