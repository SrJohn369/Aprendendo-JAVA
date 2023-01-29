package noções_básicas;
/* primeiro vamos importar a classe Scanner pra receber as entradas, que a gente conhece em Python
 * como input. Se a gente quiser receber dados é obrigatório importar essa classe*/
import java.util.Scanner;

public class Variáveis_EntradaDeDados 
{
	public static void main(String[] args)
	{
		// Vamos ter que criar um objeto usando a classe Scanner para a entrada de dados do usuário
		Scanner input = new Scanner(System.in);
		/* Nosso objeto é o input, criamos um novo objeto na classe Scanner para sistema, ou seja, System
		 * e in para entrada de dados input. O nome input na criação do objeto é opcional, eu João,
		 * prefiro assim, até mesmo por causa do Python, me acostumei com essa palavra significando
		 * entrada*/
		String nomePessoa;
		/* Então criamos uma variável que vai receber o nome da pessoa. Não preciso explicar o que é
		 * uma variável né?!kkkk, mas tem algo aqui muito diferente de Python, aqui você tem que declarar
		 * o tipo de variável primeiro e depois o nome da variável, outra coisa também é que você pode
		 * dar um valor para a variável ou não, como na variável acima que não tem um valor definido ainda*/
		String xicara = "café"; // Nunca esqueça de colocar ; no final da linha.
		
		System.out.print("Digite seu nome: ");
		/* Agora atribuímos o que for digitado à variável nomePessoa por meio do objeto que a gente criou
		   usando o método next(), usariamos o método nextLine() caso houvesse uma quebra de linha no print*/
		nomePessoa = input.next();
		System.out.println("Olá "+nomePessoa+" Seja muito bem vindo(a)!!");
		// no println() não podemos usar vírgulas para separar as strings das variáveis
		System.out.printf("Olá %s Seja muito bem vindo(a)!!\n", nomePessoa);
		System.out.printf("Preciso de uma xícara de %s\n", xicara);
		/* mas podemos usar o prinf(), já que se trata de uma formatação. Da mesma forma em Python
		 * %s é s de string acredito que conhecem esse tipo de formatação
		 */
		System.out.printf("%s você quer um copo de %s\n", nomePessoa, xicara);
		
	}
}