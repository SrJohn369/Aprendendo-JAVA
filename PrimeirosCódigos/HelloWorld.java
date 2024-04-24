/* O package vocês que vão definir e a classe também, lembrando que a classe deve ter o mesmo nome
 * do arquivo que vocês criaram dentro do pacote*/
public class HelloWorld 
{
	public static void main(String[] args) 
	{
		// Exibe uma saudação na janela de console
		System.out.println("Hello World");
		/* Diferente de python sempre que você terminar uma linha de código deve colocar ;
		 pro compilador entender que a linha acaba alí, caso contrário vai apresentar erro*/
		System.out.println("Esse println imprime a mensagem e quebra uma linha sem precisar"
				+ " usar o contra barra n.\nConcatenação também serve aqui "+"esse é o exemplo");
		System.out.println(
						   "+----+"
					   + "\n|joão|"
					   + "\n+----+"
					      );
		/* Alí encima fiz a mesma coisa do segundo exemplo só que com uma vizualização melhor 
		   para o resltado que busco */
		System.out.print("00");
		System.out.println(3 + 4);
		// a saída dessas duas linhas de código é 007
	}
}
