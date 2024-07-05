package br.com.screematchsemweb.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}


// <T> T esse é o generics do JAVA que é usado para quando não sabemos o que irá retormar