package br.com.screematchsemweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.screematchsemweb.model.DadosEpisodio;
import br.com.screematchsemweb.model.DadosSerie;
import br.com.screematchsemweb.model.DadosTemporada;
import br.com.screematchsemweb.service.ConsumoApi;
import br.com.screematchsemweb.service.ConverteDados;

@SpringBootApplication
public class Main implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// instânciar a classe de consumo
		var consumoApi = new ConsumoApi();
		// passamos o endereço
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=443ba9e4");
		System.out.println(json);
		System.out.println("\n\n\n\n");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		System.out.println("\n\n\n\n");
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season=1&Episode=1&apikey=443ba9e4");
		DadosEpisodio ddEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(ddEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();

		for (int i=1; i<=dados.totalTemporadas(); i++) {
			json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&Season"+i+"&apikey=443ba9e4");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
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
