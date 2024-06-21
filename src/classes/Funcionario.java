package classes;

import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Locale;

public class Funcionario extends Pessoa{
    double salario;
    String funcao;

    public Funcionario(){}

    public Funcionario(String name, String dataNascimento, double salario, String funcao){
        super(name, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public double getSalario(){
        return this.salario;
    }

    public String getFuncao(){
        return this.funcao;
    }

    //Funcão criada para reaproveitar o codigo
    //Considerando a locailzação BR e um método de formatação conforme dito no item 3.3 do processo
    //informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.

    public static ArrayList<Funcionario> getAllFuncionarios(ArrayList<Funcionario> funcionarios) {
        Locale localeBR = new Locale("pt","BR");
        NumberFormat salarioReal = NumberFormat.getCurrencyInstance(localeBR);
        System.out.println("==== Tabela de Funcionarios ====");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("| Nome: " + funcionario.getNome() + "|Nascimento: " + funcionario.getDataNascimento() + "| Salario: " + salarioReal.format(funcionario.getSalario()) + "| Funcao: " + funcionario.getFuncao() + "|");
        }
        System.out.println("==== Fim da tabela de Funcionarios ====");

        return funcionarios;
    }

    public void setSalario(double newSalario){
        this.salario = newSalario;
    }
}
