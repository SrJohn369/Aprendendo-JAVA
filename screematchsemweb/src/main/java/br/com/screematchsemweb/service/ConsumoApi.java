package br.com.screematchsemweb.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    // 
    public String obterDados(String endereco) {
        // criar uma instância de cliente para fazer as requisições
        HttpClient client = HttpClient.newHttpClient();
        /* config de requisição 
         * com o método newBuilder() irá construir uma requisição que por sua vez
         * precisará de um endereço para tal, onde é passado na uri
        */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        // criar uma var do tipo HttpResponse<String> para tentar capturar uma resposta
        HttpResponse<String> response = null;
        // tenta capturar a resposta
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // queremos retornar uma resposta String da 
        //requisição, e faremos usando a função body() na response
        String json = response.body();
        return json;
    }
}

// ====================================================
/* URI significa Uniform Resource Identifier, 
que é um padrão para identificar recursos na web. 

É um identificador único que representa um recurso na 
internet, como uma página web, um arquivo, 
um serviço, etc.

Existem dois tipos principais de URI: 
URL (Uniform Resource Locator) e 
URN (Uniform Resource Name).

O URL é o tipo mais comum de URI, que especifica onde 
um recurso está localizado (endereço) e como 
acessá-lo (protocolo).

O URN é um identificador único para um recurso, mas 
não especifica sua localização, apenas seu nome.

A URI é composta por diferentes partes, como o 
esquema (http, https, ftp, etc.), o nome de domínio, 
a porta, o caminho do recurso, etc.

*/
// ====================================================