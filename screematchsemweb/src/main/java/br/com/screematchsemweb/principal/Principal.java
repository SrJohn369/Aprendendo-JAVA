package br.com.screematchsemweb.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.screematchsemweb.model.DadosSerie;
import br.com.screematchsemweb.model.DadosTemporada;
import br.com.screematchsemweb.service.ConsumoApi;
import br.com.screematchsemweb.service.ConverteDados;

public class Principal {
    // ATRIBUTOS
    private Scanner leia = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    
    // CONSTANTES
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=443ba9e4";
    //var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=443ba9e4");
    public void exibeMenu(){
        System.out.print("Digite o nome da série: ");
        var nomeSerie = leia.nextLine();
        var json = consumo.obterDados(ENDERECO+nomeSerie.replace(" ", "+")+API_KEY);
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
        //Coleta dados de todas as temporadas
		for (int i=1; i<=dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO+nomeSerie.replace(" ", "+")+"&season="+i+API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		// temporadas.forEach(System.out::println);
        //percorre cada temporada
        temporadas.forEach( 
            // irá percorrer cada episodio dentro da temporada
            t -> t.episodios().forEach(
                // irá percorrer cada titulo dentro do episodio
                e -> System.out.println(e.titulo())
            )
        );
        // t -> está funcionando como uma função anônima

    }
}
