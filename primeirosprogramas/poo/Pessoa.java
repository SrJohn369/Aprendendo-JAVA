package primeirosprogramas.poo;

public class Pessoa {
    private int idade;
    private String nome;
    private String cpf;
    private String sexo;
    private double altura;
    public boolean comendo;

    public String getCpf() {
        return cpf;
    }
    

    public String comer() {
        this.comendo = true;
        return String.format("%s está comendo", this.nome);
    }

}
