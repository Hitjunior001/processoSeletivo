package classes;

public class Pessoa {

    String nome;
    String dataNascimento;

    public Pessoa(){
    }

    public Pessoa(String nome, String dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return this.nome;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }
}
