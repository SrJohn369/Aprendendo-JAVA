package br.com.screematchsemweb.model;

import com.fasterxml.jackson.annotation.JsonAlias;

// record porque vamos apenas represendar os dados
public record DadosSerie(
        @JsonAlias("TItle") String titulo,
        @JsonAlias("totalSessions") Integer totalTemporadas,
        @JsonAlias("imdbRating") String avaliacao) {

}

// @JsonAlias é usado aqui para indicar que "Title" no json é para ser interpretado para titulo
// relacionando 
/*Estudar @JsonAlias @JsonProperty */