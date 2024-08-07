package br.com.screematchsemweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.screematchsemweb.principal.Principal;


@SpringBootApplication
public class Main implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}

}


/* na classe principal public class ScreenmatchApplication, precisamos informar que ela implementa a
 interface de linha de comando. Portanto, escrevemos implements CommandLineRunner. Essa interface 
 permitirá realizar algumas chamadas no método principal, semelhante ao que fazemos na formação de 
 Orientação a Objetos, na qual o método main realizava várias ações. Portanto, escrevemos implements 
 CommandLineRunner. Essa interface permitirá realizar algumas chamadas no método principal, semelhante 
 ao que fazemos na formação de Orientação a Objetos, na qual o método main realizava várias ações. 
 
 Quando uma interface é implementada, temos um contrato. Portanto, preciso implementar os métodos ainda 
 não implementados, que nesse caso, é o run.

 Quando o método run é implementado, o que o código indica que quando o public static void main chamar o 
SpringApplication.run, ele invocará esse método run que estamos implementando.

Esse método run vai atuar como um método main, pois faremos tudo que seria feito em um main comum, 
como na formação anterior.
*/
