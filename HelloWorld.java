/* Antes de começarem, recomendo fortemente assistirem essas primeiras vídeo aulas do guanabara
 * até ante de ele começar a instalação da IDE e etc. Porque tô pensando numa coisa bem básica nesse
 * começo porque nas aulas lá dele, ele ja começa com insterface gráfica, e aí fica chato de aprender
 * quando a gente estiver pelo menos num nível parecido com o que a gente tem em python aí a gente tenta
 * interface gráfica lá.
 * 
 * Mais uma coisa, recomendo usarem a IDE Eclipse, eu acho melhor do que a maioria que tem por aí,
 * sem contar que é a mais usada, mas efim fica a cargo de vocês. qualquer dúvida me mandem mensagem
 * seja no whatsapp ou telegram. BORA LÁ!!*/

package noções_básicas;
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

/* ALGUMAS CONSIDERAÇÕES
 * 00 - Vou usar o livro que tenho de Java na mesma sequência pra tá apresentando aqui
 * 
 * 1 - Em Java, cada arquivo-fonte pode conter no máximo uma classe pública, e o nome dessa classe 
 * pública deve corresponder ao nome do arquivo que a contém.
 * 
 * 2 - Toda aplicação Java contém um método main. Quando a aplicação inicia, as instruções no método
 * main são executadas.
 * 
 * 3 - O parâmetro String[] args é uma parte obrigatória do método main. A palavra-chave static indica
 * que o método main não opera sobre um objeto
 * 
 * 4 - A janela de console é representada em Java por um objeto chamado out. Assim como precisamos
 * colocar o método main em uma classe, os projetistas do da biblioteca Java precisaram colocar o
 * objeto out em uma classe. Eles o colocaram na classe System, que contém objetos e métodos úteis para
 * acessar recursos do sistema. Assim temos que referenciar System.out, desse modo você está dizendo
 * ao compilador "desejo utilizar o objeto out da classe System". Então nós temos que: 
 *  			System.out.println("Hello World");
 *  Objeto - System.out
 *  Método - println()
 *  Parâmetro de pirntln() - "Hello World" 
 * 
 * 5 - Uma string é sempre uma sequência de caracteres aqui também como em Python.
 * 
 * 6- O método print() como a gente já conhece, aqu ele pode ser utilizado para imprimir algo sem
 * quebrar linha no próximo método de impressão, um exemplo é os quarto e quinto exemplos aqui 
 * da nossa função principal ou seja, nosso método main*/ 