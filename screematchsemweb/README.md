# JAVA SPRINGBOOT sem Web
Durante os estudos me apareceram questionamentos e o formato dessa documentção de estudo está assim:  

---
CÓDIGO:
```java
System.out.println(json);
```
PERGUNTAS:  
Dúvida 1?  
Dúvida 2?  
RESPOSTAS:  
```txt
### Dúvida 1? ###
Resposta 1
```
```txt
### Dúvida 2? ###
Resposta 2
```
---
## função principal
#### CÓDIGO:  
```java
@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(null);
		System.out.println(json);
	}
```  
---  
#### PERGUNTAS:  
+ O que significa esses 3 pontos nesse trecho do código em `String...`?  
```java
public void run(String... args) throws Exception 
```  
---

#### RESPOSTAS:   
Os três pontos (...) nesse contexto são chamados de "parâmetro variádico" (varargs, em inglês).  
Em Java, quando você declara um método com um parâmetro variádico, isso significa que você pode passar um número variável de argumentos daquele tipo para o método. Nesse caso, o método run() está declarado com String... args, o que significa que você pode passar zero ou mais argumentos do tipo String para esse método.  
Isso é útil quando você não sabe antecipadamente quantos argumentos o método precisará receber. Por exemplo, se você estiver criando um método para somar números, você pode usar um parâmetro variádico para permitir que o usuário passe quantos números quiser:    

Por Exemplo:  
```java
public int soma(int... numeros) {
    int total = 0;
    for (int numero : numeros) {
        total += numero;
    }
    return total;
}
```
## Classe ConsumoApi
### Função obterDados
CÓDIGO:  
```java
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
```
---
#### PERGUNTAS:  
+ Quais funções estão presentes na classe `HttpClient` e para quê servem?
+ Quais funções estão presentes na classe `HttpRequest` e para quê servem?
+ O que é URI?  
+ O que é o IOException?
+ O que é o InterruptedException?
+ O que é o RuntimeException?
---
#### RESPOSTAS: 
```txt
### O que é URI? ###

URI significa Uniform Resource Identifier, 
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
```

## Record DadosSerie
### CÓDIGO:
```java
// record porque vamos apenas represendar os dados
@JsonIgnoreProperties(ignoreUnknown = true) // usado para ignorar tudo que não estiver nos parametros da record
public record DadosSerie(
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String avaliacao) {}

// @JsonAlias é usado aqui para indicar que "Title" no json é para ser interpretado para titulo
// relacionando 
/*Estudar @JsonAlias @JsonProperty */
```
OBS: Olhar a documentação 

## Classe Principal
### função exibe menu
#### CODIGO
```java
    temporadas.forEach(System.out::println);
    //percorre cada temporada
    temporadas.forEach( 
        // irá percorrer cada episodio dentro da temporada
        t -> t.episodios().forEach(
            // irá percorrer cada titulo dentro do episodio
            e -> System.out.println(e.titulo())
        )
    );
    // t -> está funcionando como uma função anônima
```

#### PERGUNTAS:
+ Como funciona de fato este forEach e quando foi introduzido no Java?
+ Como funciona essa sintaxe: temporadas.forEach(`System.out::println`); ?

#### RESPOSTAS