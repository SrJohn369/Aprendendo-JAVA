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
+ O que são funções Lambda?
+ Como funciona de fato este forEach e quando foi introduzido no Java?
+ Como funciona essa sintaxe: temporadas.forEach(`System.out::println`); ?
+ O que é Streams?

#### RESPOSTAS
```txt
O que são funções Lambda?

As funções Lambda - chamadas de funções anônimas -
são uma maneira de definir funções que são frequentemente 
usadas uma única vez, direto no local onde elas serão usadas.

```
---
```txt
Como funciona de fato este forEach e quando foi introduzido no Java?


Em Java, uma função lambda é definida da seguinte maneira:
(argumentos) -> { corpo-da-função }

Por exemplo, podemos definir uma função lambda que 
adicione dois números da seguinte maneira:
(a, b) -> { return a + b; }

Exemplos de uso de funções Lambda:

List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

for(Integer i: lista) {
  if(i % 2 == 0) {
    System.out.println(i);
  }
}
--------------------------------------------

podemos simplificar esse código:

List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
```  

---  

```
O que é Streams?

========
As streams são uma nova forma de trabalhar com coleções 
de dados no Java, introduzidas a partir do Java 8. 
Elas permitem realizar operações de forma mais eficiente 
e concisa, utilizando uma abordagem funcional.

Uma stream é uma sequência de elementos que pode ser 
processada em paralelo ou em série.

Ela pode ser criada a partir de uma coleção, 
um array, um arquivo, entre outros.

As operações intermediárias são aquelas que podem 
ser aplicadas em uma stream e retornam uma nova 
stream como resultado. Essas operações não são 
executadas imediatamente, mas apenas quando uma 
operação final é chamada.

OPERAÇÕES INTERMEDIÁRIAS:
+ Filter: permite filtrar os elementos da stream com base 
em uma condição. Exemplo:
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> numerosPares = numeros.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());

System.out.println(numerosPares); // Output: [2, 4, 6, 8, 10]

=======
+ Map: permite transformar cada elemento da stream em outro tipo de dado. 
Exemplo:

List<String> palavras = Arrays.asList("Java", "Stream", "Operações", "Intermediárias");

List<Integer> tamanhos = palavras.stream()
                                .map(s -> s.length())
                                .collect(Collectors.toList());

System.out.println(tamanhos); // Output: [4, 6, 11, 17]

=======
OPERAÇÕES FINAIS
As operações finais são aquelas que encerram a stream e retornam um resultado concreto.
Algumas operações finais comuns são o forEach, collect e count.
Exemplos:

+ ForEach: permite executar uma ação em cada elemento da stream.
List<String> nomes = Arrays.asList("João", "Maria", "Pedro", "Ana");

nomes.stream()
     .forEach(nome -> System.out.println("Olá, " + nome + "!"));

// Output:
// Olá, João!
// Olá, Maria!
// Olá, Pedro!
// Olá, Ana!

======
+ Collect: permite coletar os elementos da stream em uma 
coleção ou em outro tipo de dado.
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

Set<Integer> numerosPares = numeros.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toSet());

System.out.println(numerosPares); // Output: [2, 4, 6, 8, 10]

```
## Alguns Assuntos
```txt
Padrões

Os formatos de data e hora são especificados por strings padrão de data e hora, 
a tabela a seguir mostra a sintaxe padrão que deve ser utilizada para o padrão de formatação:

Letra	Componente data/hora	    Exemplo
G	    Designador de era	        DC
y	    Ano	                        2010; 10
M	    Mês no ano	                Julho; jul; 10
w	    Semana no ano	            27
W	    Semana no mês	            2
D	    Dia no ano	                189
d	    Dia no mês	                10
F	    Dia da semana no mês	    2
E	    Dia na semana	            Terça-feira; ter
a	    Marcador de am/pm	        PM
H	    Hora no dia (0-23)	        0
k	    Hora no dia (1-24)	        24
K	    Hora em am/pm (0-11)	    0
h	    Hora em am/pm (1-12)	    12
m	    Minuto na hora	            30
s	    Segundo no minuto	        55
S	    Fração de um segundo	    978

EXEMPLO:
==================================================================================================
import java.text.SimpleDateFormat;
import java.util.Date;

public class Datas {

    public static void main(String[] args) {

        String pattern = "E, dd MMM yyyy HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

    }
}
==================================================================================================
SAÍDA:  sáb., 19 nov. 2022 02:58:14 BRT”:

LocalDate

O LocalDate representa uma data. Uma data sem fuso horário no sistema de calendário 
ISO-8601, tem como formato padrão yyyy-MM-dd. Essa classe não armazena ou representa 
uma hora ou fuso horário. Em vez disso, é uma descrição da data, 
normalmente usada para aniversários.

Data atual

Vamos utilizar o LocalDate para criar a data atual, a de hoje:
==================================================================================================
import java.time.LocalDate;

public class Datas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

    }
}
==================================================================================================
SAÍDA: 2022-11-19

Criando datas

Agora, vamos criar uma nova data para representar a data de um aniversário. 
Para isso, importaremos o pacote java.time.month;
==================================================================================================
import java.time.LocalDate;
import java.time.Month;

public class Datas {
    
    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate aniversarioAlice = LocalDate.of(2005, Month.SEPTEMBER, 15);
        System.out.println(aniversarioAlice);
    }
}
==================================================================================================
SAÍDA: 2005-09-15

Também podemos brincar com esse código e calcular a idade atual da aniversariante. 
Uma forma de fazer isso na mão seria subtraindo o método getYear das datas, dessa forma:
==================================================================================================
import java.time.LocalDate;
import java.time.Month;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate aniversarioAlice = LocalDate.of(2005, Month.SEPTEMBER, 15);
        System.out.println(aniversarioAlice);

        int idade =  hoje.getYear() - aniversarioAlice.getYear();
        System.out.println(idade);
    }

}
==================================================================================================
SAÍDA: 
2022-11-19
2005-09-15
17

Período

Ao executar esse código temos o resultado esperado, que neste caso é 17 anos. 
Mas e se quiséssemos descobrir a diferença de dias e meses também? Daria pra fazer da 
mesma forma utilizando o get, no entanto, existe algo pronto para nos ajudarmos. 
Nesse caso, podemos utilizar a classe Period.

Para saber a diferença entre duas datas podemos utilizar seu método between, da seguinte forma:
==================================================================================================
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate aniversarioAlice = LocalDate.of(2005, Month.SEPTEMBER, 15);
        System.out.println(aniversarioAlice);

        int idade = aniversarioAlice.getYear() - hoje.getYear();
        System.out.println(idade);

        Period periodo = Period.between(hoje, aniversarioAlice);
        System.out.println(periodo);

    }
}
==================================================================================================
Repare que a saída desse nosso println vai ser um pouco estranha, um exemplo seria: P-17Y-2M-4D.

Isso significa um período de 17 anos, 2 meses e 4 dias.

LocalTime

O local time representa um horário, seu formato padrão é hh:mm:ss.zzz.
Horário atual

Assim como fizemos com o LocalDate, dessa vez vamos imprimir o horário atual:
==================================================================================================
import java.time.LocalTime;

public class Horarios {

    public static void main(String[] args) {
        LocalTime hoje = LocalTime.now();
        System.out.println(hoje);
    }
}
==================================================================================================
SAÍDA: Perceba o resultado é a data atual no formato hh:mm:ss.zzz:

06:02:21.029460400

Criando horários

Agora, vamos criar um novo horário para representar as horas em que Alice nasceu:
==================================================================================================
import java.time.LocalTime;

public class Horarios {

    public static void main(String[] args) {
        LocalTime hoje = LocalTime.now();
        System.out.println(hoje);

        LocalTime aniversarioHoraAlice = LocalTime.of(22, 33, 15);
        System.out.println(aniversarioHoraAlice);
    }
}
==================================================================================================
O resultado será no formato hh:mm:ss, pois colocamos dessa forma no LocalTime.of() :

22:33:15 

LocalDateTime
Horário e data atual

O LocalDateTime representa uma data com a hora, visto como ano-mês-dia-hora-minuto-segundo. 
O tempo é representado como yyyy-MM-dd-HH-mm-ss.zzz.
==================================================================================================
import java.time.LocalDateTime;

public class DataHorario {

    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();
        System.out.println(hoje);
    }
}
==================================================================================================
Resultado:

2022-11-19T04:11:17.108565200

DateTimeFormatter

Você deve ter notado que os resultados estão em formatos que não estamos acostumados a trabalhar. 
Podemos então trabalhar com diversos formatadores de datas existentes!

Exemplos de formatos de data e hora:
Formato	                        Exemplo
MM/dd/yyyy	                    19/11/2022
dd-M-yyyy hh:mm:ss	            19-11-22 12:07:23
dd MMMM yyyy	                19 de novembro de 2022
dd MMMM yyyy zzzz	            19 de novembro de 2022, Horário Padrão de Brasília
E, dd MMM yyyy HH:mm:ss z	    Sáb, 19 de novembro de 2022, 12:07:23 BRT

Além disso, também podemos mudar a forma de exibir o mês. Se utilizarmos letras em quantidades diferentes, 
consequentemente o resultado também é. Vejamos:

Tipo	        Padrão	        Exemplo
Mês completo	MMMM	        Setembro
Mês abreviado	MMM	            Set.
Mês numérico	MM	            09

Para formatarmos, vamos utilizar o DateTimeFormatter. Existem diversos já prontos, 
mas há ainda a alternativa de você criar o seu próprio formato no padrão já conhecido de dd/MM/yyyy hh:mm:ss.

Para fazer isso basta você utilizar o método ofPattern. Como vimos nas tabelas anteriores, 
podemos escolher como será impresso.
==================================================================================================
DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
==================================================================================================
Agora podemos a partir da nossa data, neste caso hoje, chamar o método format passando esse formatador:

==================================================================================================
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatando {

    public static void main(String[] args) {
        LocalDateTime hoje = LocalDateTime.now();
        System.out.println(hoje);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(hoje.format(formatador));

    }
}
==================================================================================================
Agora sim, ao executar temos o resultado:

19/11/2022 04:38:11


Como temos estudado no curso, Streams nos permitem manipular coleções de elementos (como Lists ou Sets) 
de forma mais sofisticada e eficiente do que os métodos tradicionais. Eles são especialmente úteis quando 
precisamos realizar operações em massa nesses elementos, como filtrar, transformar ou agregar.

E a função Peek, o que é?

A função”peek” é uma operação intermediária de uma stream. Uma operação intermediária é aquela que 
processa os dados da stream, mas não a finaliza, ou seja, ela permite que mais operações sejam feitas 
depois dela. A função peek é usada para "espiar" os elementos da stream sem alterá-los, o que pode ser muito 
útil para depuração. Essa função vai receber cada elemento da stream e realizar alguma operação de efeito 
colateral (como imprimir o elemento), mas vai devolver o mesmo elemento sem alterar nada.

Por que eu deveria usar isso?

O uso de Streams e a função peek podem te ajudar a escrever códigos mais elegantes, fáceis de ler, e diminuir a 
possibilidade de erros. Além disso, eles podem fazer seu código rodar mais rápido em certos casos, pois os 
Streams permitem a paralelização das operações, ou seja, executar várias operações ao mesmo tempo.

Exemplos de código

Vamos ver agora um exemplo simples de como podemos usar a função peek com streams. Imagine que temos uma 
lista com números e queremos multiplicar cada um deles por 2 e depois somar os resultados.

List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

int soma = numeros.stream()
                .peek(n -> System.out.println("Elemento: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Conteúdo depois do map: " + n))
                .reduce(0, (total, numero) -> total + numero);

System.out.println("A soma dos números é: " + soma);

Nesse código, nós criamos uma stream com a lista de números, espiamos cada número para imprimir 
(com a função.peek), multiplicamos o valor por dois, espiamos também para conferir o valor da 
multiplicação e depois somamos os resultados.

Veja como aparece no terminal após a execução da aplicação:

Elemento: 1
Conteúdo depois do map: 2
Elemento: 2
Conteúdo depois do map: 4
Elemento: 3
Conteúdo depois do map: 6
Elemento: 4
Conteúdo depois do map: 8
Elemento: 5
Conteúdo depois do map: 10
A soma dos números é: 30

Process finished with exit code 0

Isso nos ajuda a ter certeza de que o processo está sendo feito corretamente. Aqui conseguimos perceber 
que a soma dos números 2 + 4 + 6 + 8 + 10 foi calculada corretamente, resultando em 30. Ou seja, a função 
lambda em nosso método reduce está fazendo exatamente o que era planejado. E pudemos conferir isso, com o peek.

Esse é apenas um exemplo básico, mas lembre-se que a função peek pode ser usada em qualquer lugar dentro da sua stream,
sempre que você quiser ver quais elementos estão passando por aquele ponto.

```