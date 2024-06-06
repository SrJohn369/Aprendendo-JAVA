package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException{
        // Fazendo a busca
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o nome de um filme para buscar: ");
        String objeto = ler.nextLine();

        // Busca dinamica
        String endereco = "https://www.omdbapi.com/?t=" + objeto + "&apikey=443ba9e4";

        // Fazendo uma requsição HTTP request
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build();

        // resposta do endpoint
        HttpResponse<String> response = client
        .send(request, BodyHandlers.ofString()); 

        // saida
        System.out.println(response.body());
        ler.close();

        
    }
}
