package br.com.screematchsemweb.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// record porque vamos apenas represendar os dados
@JsonIgnoreProperties(ignoreUnknown = true) // usado para ignorar tudo que não estiver nos parametros da record
public record DadosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String avaliacao) {}

// @JsonAlias é usado aqui para indicar que "Title" no json é para ser interpretado para titulo
// relacionando 
/*Estudar @JsonAlias @JsonProperty */