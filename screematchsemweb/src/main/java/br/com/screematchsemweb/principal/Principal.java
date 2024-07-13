package br.com.screematchsemweb.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.screematchsemweb.model.DadosEpisodio;
import br.com.screematchsemweb.model.DadosSerie;
import br.com.screematchsemweb.model.DadosTemporada;
import br.com.screematchsemweb.model.Episodio;
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
    public void exibeMenu() {
        System.out.print("Digite o nome da série: ");
        var nomeSerie = leia.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
        //Coleta dados de todas as temporadas
        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
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

        // ===============================================
        // Criando uma lista com todos os episodios de todas as temporadas
        List<DadosEpisodio> dadosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        // Filtrando TOP 10 episodios
        dadosEpisodios.stream()
                .filter(e -> !e.avaliacao().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primeiro filtro(N/A) " + e))
                .sorted(Comparator.comparing(DadosEpisodio::avaliacao).reversed())
                .peek(e -> System.out.println("Ordenação " + e))
                .limit(10)
                .peek(e -> System.out.println("Limite " + e))
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Mapeamento " + e))
                .forEach(System.out::println);

        List<Episodio> episodios =  temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.temporada(), d))
                ).collect(Collectors.toList());
        episodios.forEach(System.out::println);

        // filtrando por data
        System.out.println("A partir de que nao deseja ver os episodios?");
        var ano = leia.nextInt();
        leia.nextLine();

        LocalDate dataBusca = LocalDate.of(ano, 1, 1);
        DateTimeFormatter dformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(
                        e -> e.getDataLancamento() != null &&
                                e.getDataLancamento().isAfter(dataBusca)
                ).forEach(e -> System.out.printf(
                        "Temporada: %d\nEpisódio: %s\nData de Lançamento: %s\n",
                        e.getTemporada(), e.getTitulo(), e.getDataLancamento().format(dformat)
                ));
    }
}
