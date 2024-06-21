import classes.Funcionario;
import com.sun.jdi.Value;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.time.format.DateTimeFormatter;



public class Main {
    public static void main(String[] args) {
        //Item 3 do processo seletivo
        //Instaciando a lista de funcionarios
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        //Salvando formato para printar salario com milha e virgula conforme pedido.
        Locale localeBR = new Locale("pt","BR");
        NumberFormat salarioReal = NumberFormat.getCurrencyInstance(localeBR);

        //Criando os funcionarios
        Funcionario Maria = new Funcionario("Maria", "18/10/2000", 2009.44, "Operador");
        Funcionario Joao = new Funcionario("João", "12/05/1990", 2284.38, "Operador");
        Funcionario Caio = new Funcionario("Caio", "02/05/1961", 9836.14, "Coordenador");
        Funcionario Miguel = new Funcionario("Miguel", "14/10/1988", 19119.88, "Diretor");
        Funcionario Alice = new Funcionario("Alice", "05/01/1995", 2234.68, "Recepcionista");
        Funcionario Heltor = new Funcionario("Heltor", "19/11/1999", 1582.72, "Operador");
        Funcionario Arthur = new Funcionario("Arthur", "31/03/1993", 4071.84, "Contador");
        Funcionario Laura = new Funcionario("Laura", "08/07/1994", 3017.45, "Gerente");
        Funcionario Heloisa = new Funcionario("Heloísa", "24/05/2003", 1606.85, "Eletricista");
        Funcionario Helena = new Funcionario("Helena", "02/09/1996", 2799.93, "Gerente");

        //Item 3.1 do processo seletivo
        //Adicionando os funcionarios na lista
        funcionarios.add(Maria);
        funcionarios.add(Joao);
        funcionarios.add(Caio);
        funcionarios.add(Miguel);
        funcionarios.add(Alice);
        funcionarios.add(Heltor);
        funcionarios.add(Arthur);
        funcionarios.add(Laura);
        funcionarios.add(Heloisa);
        funcionarios.add(Helena);

        //Mostrar todos os funcionarios
        Funcionario.getAllFuncionarios(funcionarios);


        //Item 3.2 do processo seletivo
        System.out.println("\n=============================");
        System.out.println("Removendo o funcionario Joao...");
        System.out.println("=============================\n");

        //Remover o joão da lista de funcionarios usando metodo de referencia
        funcionarios.remove(Joao);

        System.out.println("\n=============================");
        System.out.println("Funcionario Joao removido");
        System.out.println("=============================\n");

        //Item 3.3 do processo seletivo
        //Mostrar os funcionarios novamente sem o João
        Funcionario.getAllFuncionarios(funcionarios);

        //Item 3.4 do processo seletivo
        //Aumentar o salário em 10%
        System.out.println("\n=============================");
        System.out.println("Aumentando salário em 10%...");
        System.out.println("=============================\n");

        //Iterando a lista de funcionarios pra realizar o aumento
        for(Funcionario funcionario : funcionarios){
            //10% = 0.1, pra aumento usamos o valor 1.1
            double newSalario = funcionario.getSalario() * 1.1;

            //Setando o novo salario em cada funcionario
            funcionario.setSalario(newSalario);
        }
        //Aumentar o salário em 10%
        System.out.println("\n=============================");
        System.out.println("Salario aumentado em 10%");
        System.out.println("=============================\n");

        //Mostrar os funcionarios com salario aumetando em 10%
        Funcionario.getAllFuncionarios(funcionarios);

        //Item 3.5 do processo seletivo
        //Agrupar os funcionarios por funcao usando o método map
        //Vamos criar uma lista de função para cada tipo.
        Map<String, ArrayList<Funcionario>> funcaoFuncionarios = new HashMap<>();
        for(Funcionario funcionario : funcionarios){
            //Checar pra ver se não já foi botado a função pra não haver repetição de listas
            if(!funcaoFuncionarios.containsKey(funcionario.getFuncao())){
                //Salvar a lista da função caso não exista e criar uma lista dessa nova função
                funcaoFuncionarios.put(funcionario.getFuncao(), new ArrayList<>());
            }
            //Após criar a lista de cada função, iremos adicionar cada funcionario referente a função
            //Vamos pegar a lista criada dentro do map e vamos pegar a chave que é a função do funcionario
            //e assim adicionar o funcionario correspodente
            funcaoFuncionarios.get(funcionario.getFuncao()).add(funcionario);
        }

        //Item 3.6 do processo seletivo
        //Após ter criado o map de função e as listas, iremos iterar a lista de função pra agrupamento
        //e depois iterar a lista de funcionarios que
        System.out.println("\n==== Tabela de Funcionarios por função ====");
        for(String funcao : funcaoFuncionarios.keySet()){
            //Colocando as função primeiro pra agrupar
            System.out.println("Função: " + funcao);
            //Iterando os funcionarios por função usando funcao como key no map
            for (Funcionario funcionario : funcaoFuncionarios.get(funcao)) {
                System.out.println("| Nome: " + funcionario.getNome() + "| Nascimento: " + funcionario.getDataNascimento() + "| Salario: " + salarioReal.format(funcionario.getSalario()) + "|");
            }
            System.out.println("-----");

        }
        System.out.println("==== Fim da Tabela de Funcionarios por função ====");

        //Item 3.8 do processo seletivo
        System.out.println("\n==== Tabela de Funcionarios de mes 10 ou 12 ====");
        for(Funcionario funcionario : funcionarios){
            //Definir um formato padrão de data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //Como os valores de dataNascimento tem padrão, irei converter de String para Date e pegar o mês com a função
            LocalDate getData = LocalDate.parse(funcionario.getDataNascimento(), formatter);
            //Comparando se o mês é 10 ou 12 com as strings formatada de cada funcionario
            if(getData.getMonth().equals(Month.of(10)) ||
                getData.getMonth().equals(Month.of(12))){
                System.out.println("| Nome: " + funcionario.getNome() + "| Nascimento: " + funcionario.getDataNascimento() + "| Salario: " + salarioReal.format(funcionario.getSalario()) + "|");
            }
        }
        System.out.println("==== Fim Tabela de Funcionarios de mes 10 ou 12 ====");

        //Item 3.9 do processo seletivo
        //Para imprimir o funcionario de maior idade, iremos iterar como feito no item passado e convertendo as datas
        //após, iremos calcular idade de cada funcionario e criar uma nova lista e pegar o de maior idade;

        System.out.println("\n==== Funcionario com a maior idade ====");
        //Criando um map pra criar um com nome e idade;
        Map<String, Long> listFuncionariosNomeIdade = new HashMap<String, Long>();
        for(Funcionario funcionario : funcionarios) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate getData = LocalDate.parse(funcionario.getDataNascimento(), formatter);
            //Considerando a data 21/06/2024 como a atual.
            LocalDate dataAtual = LocalDate.parse("21/06/2024", formatter);
            //Método simples para saber idade, sem considerar o mês, apenas o ano
            long idade = dataAtual.getYear() - getData.getYear();
            listFuncionariosNomeIdade.put(funcionario.getNome(), idade);
        }

        //Criar variavel de menor idade e nome
        long maiorIdade = 1;
        String nomeMaiorIdade = "";

        //Após criar o map com nome e idade dos funcionarios, iremos iterar esse map pegando a key que é a idade e pegaremos o nome também que o value
        //Assim criaremos o metodo de pegar o maior valor dessa iteração.
        for (Map.Entry<String, Long> entry : listFuncionariosNomeIdade.entrySet()) {
            String nome = entry.getKey();
            long idade = entry.getValue();

            if (idade > maiorIdade) {
                maiorIdade = idade;
                nomeMaiorIdade = nome;
            }
        }
        // Funcionario com maior idade
        System.out.println("| Funcionário com maior idade: " + nomeMaiorIdade + " | Idade: " + maiorIdade + "|" );





    //Item 3.10 do processo seletivo
        System.out.println("\n=============================");
        System.out.println("Ordenando a lista de funcionarios por nome...");
        System.out.println("=============================\n");
    //Para ordenar de maneira rapido e eficiente, apenas usando o metodo sort do collections
        //Criando uma nova Array pra não desconfigurar a original.
        ArrayList<Funcionario> listaOrdenada = new ArrayList<>(funcionarios);
        Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));
        //Printar a lista de usuários após rodar a função sort.
        Funcionario.getAllFuncionarios(listaOrdenada);



    //Item 3.11 do processo seletivo
    //Criar uma variavel e uma iteração de funcionarios do salario somando com a variavel
    double salarioTotal = 0; //Começando com 0

    for(Funcionario funcionario : funcionarios){
        salarioTotal += funcionario.getSalario();
        System.out.println("Salario do funcionario: "+ funcionario.getNome() + "|" + funcionario.getSalario());
    }
    //Printando o salario total de todos funcionarios
    System.out.println("=== Total Salario somado ===");
    //Usando formato padrão de real
    System.out.println("Total: " + salarioReal.format(salarioTotal));

    //Item 3.12 do processo seletivo
        //Iterar a lista de funcionarios, pegar o salario e realizar o calculo de quantos salarios minimos
        //Considerando salario minimo seja 1212, e a variavel como double

        for(Funcionario funcionario : funcionarios){
            double qtdSalarioMinimoDouble = funcionario.getSalario()/1212;
            double qtdSalarioMinimoInt = Math.round(funcionario.getSalario()/1212);

            System.out.println("| Nome: " + funcionario.getNome() + "| Qtd Salario min em Double: " + qtdSalarioMinimoDouble + "| Qtd arredondada aproximada: " + qtdSalarioMinimoInt);
        }



    }
}