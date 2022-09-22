
package programação1;

import java.util.ArrayList;
import java.util.Scanner;


public class Estoque {
     private produto dados[] = new produto[500];
     private int  indice =0; 
     
     
     public static void main(String[] args) {
        
         Estoque add  = new Estoque ();
         add.titulo();
         add.menuDeOperacoes();
    }
     private void titulo() {
        System.out.println("SUPREMO PERSONNALITE 8.13.0.0 - RYI DISTRIBUIDORA" );
    }
     private void menuDeOperacoes(){
         produto cs = new produto ();
        int op ;
        do {
            op = OpMenu();
            switch (op) {
                case 1:
                     Opmenu1();  //ok
                    break;
                case 2:
                    movimentar(); //ok
                    break;
                case 3:
                    relatorioProdutos();  //ok
                    break;
                case 0:
                    System.out.println("Saindo do sistema"); //ok
                    break;
                default:
                    System.out.println("Opção inválida"); //ok
                    break;
            }
        } while (op != 0);
        
    }
    
     private int OpMenu(){
         int op;
        System.out.println("MENU PRINCIPAL\n"+
                "1 - CADASTRO DE PRODUTOS\n" +
                "2 - ALTERAÇÃO DE PRODUTOS\n" + 
                "3 - RELATÓRIOS\n" +
                "0 - FINALIZAR\n" +
                "OPÇÃO:");
        op = getEscolhaMenu();
        return op;
    }
     private int getEscolhaMenu() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }
    
     private void Opmenu1() {
        int opcao;
         System.out.println("1 - INCLUSÃO\n" +
                "2 - ALTERAÇÃO\n" +
                "3 - CONSULTA\n" +
                "4 - EXCLUSÃO\n" +
                "0 - RETORNAR\n");
        opcao = getEscolhaMenu();
        switch (opcao) {
            case 1:
                cadastroDeProdutos();
                break;
            case 2:
                alterarProdutos();
                break;
            case 3:
               consultar();
                break;
            case 4:
               excluirProdutos();
                break;
            default:
                   System.out.println("Opção inválida");
                break;
        }
    }
     
     private void movimentar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ALTERAÇAO DOS PRODUTOS");
        System.out.println("1 - ENTRADA\n" +
                "2 - SAÍDA\n" +
                "0 - RETORNAR\n" +
                "OPÇÃO: \n");
        int opMovimento = scanner.nextInt();
        switch (opMovimento) {
            case 1:
                 entrada();
                break;
            case 2:
                  saida();
                break;
            case 0:
                System.out.println("Retornando para o menu");
                break;
            default:
              System.out.println("Opção Invalida");
                break;
        }
    }
     
     private void relatorioProdutos() {
        if (indice == 0) {
            System.out.println("LISTA VAZIA\n\n");
            System.out.println("SELECIONE OUTRA OPÇÃO ABAIXO");
            Opmenu1();
        }else if (indice >=1){
            
            System.out.println("*****RELATÓRIO DE PRODUTOS CADASTRADOS*****");
            for (int i = 0; i < indice; i++) {
            System.out.println("---------------------------");
            System.out.println("ID: " + i + "\n" + dados[i]);           
        }          
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("APERTE  [R] + ENTER PARA CONTINUAR");
        var toUpperCase = scanner.next().toUpperCase();  
        
    }
     
     
     private String confirmaOp() {
        Scanner scanner = new Scanner(System.in);
        String seleciona;
        System.out.println("CONFIRMA ( S/N ) ?");
        seleciona = scanner.next();
        return seleciona;
    }
      
      
     private String repitir() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.println("REPETIR OPERAÇÃO ( S/N ) ? ");
        escolha = scanner.next();
        return escolha;
    }
     
     private void cadastroDeProdutos() {
        String escolha;
        do {

            if (dados.length == indice) {
                System.err.println("ESTOQUE CHEIO"
                        + "CADASTRAR NOVOS PRODUTOS");
                System.out.println("\n\n");
                Opmenu1();
            } else {
                System.out.println("\n*****INCLUIR NOVOS PRODUTOS*****\n");
            }
            produto produtos = setproduto();
            escolha = confirmaOp();
            if (escolha.equalsIgnoreCase("S")) {
                dados[indice] = produtos;
                indice ++;

            }
            escolha = repitir();

        } while (escolha.equalsIgnoreCase("S"));
    }  
      
     private produto setproduto() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("**INFORME OS DADOS DO PRODUTO**");
        System.out.print("NOME: ");
        String nome = scanner.nextLine().toUpperCase();

        while ((validaProduto(nome) == false)) {
            System.err.println("ESTE PRODUTO JÁ ESTÁ CADASTRADO\n INFORME UM NOME VÁLIDO");
            nome = scanner.nextLine().toUpperCase();
        }

        System.out.print("PREÇO: ");
        double preco = scanner.nextDouble();
        while (preco <= 0) {
            System.err.println("ERRO!!!\nO PREÇO DO PRODUTO DEVE SE MAIOR QUE 0\n");
            System.out.print("INFORME UM VALOR VÁLIDO: ");
            preco = scanner.nextDouble();
        }

        System.out.print("UNDADE PRODUTO: ");
     
        scanner = new Scanner(System.in);
        String unidade = scanner.nextLine().toUpperCase();
        System.out.print("QUANTIDADE: ");
        int quantidade = scanner.nextInt();
        while (quantidade <= 0) {
            System.err.println("\nA QUANTIDADE INFORMADA DEVE SER MAIOR QUE ZERO");
            quantidade = scanner.nextInt();
        }

        produto produtos = new produto();
        produtos.setNome(nome);
        produtos.setPreco(preco);
        produtos.setUnidade(unidade);
        produtos.setQuantidade(quantidade);

        return produtos;
    }
    
     private boolean validaProduto(String nomeProduto) {
        boolean controle = true;
        for (int i = 0; i < indice; i++) {

            if (nomeProduto.equalsIgnoreCase(dados[i].getNome())) {
                controle = false;
                System.err.println("\nERRO!!!");
                break;
            } else {

            }
        }
        Invalido(controle);
        return controle;
    }
     
     private void Invalido(boolean controle) {
        if (controle) {
            System.out.println("Produto não cadastrado");
        }
    }
    
            
     
     private void alterarProdutos() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n*****ALTERAÇÃO DE PRODUTOS*****\n");
            System.out.print("NOME DO PRODUTO: ");
            String nomeConsulta = scanner.nextLine().toUpperCase();
            boolean controle = true;
            for (int i = 0; i < indice; i++) {
                if (nomeConsulta.equalsIgnoreCase(dados[i].getNome())) {
                    controle = false;
                    System.err.println("\nALTERANDO DADOS DO PRODUTO...\n");
                    produto produtos = setproduto();
                    escolha = confirmaOp();
                    if (escolha.equalsIgnoreCase("S")) {
                       dados[i] = produtos;
                    }
                    break;
                }
            }
             Invalido(controle);
            escolha = repitir();

        } while (escolha.equalsIgnoreCase("S"));
    }
     
     private void consultar() {

        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.titulo();
            System.out.println("CONSULTA DE PRODUTOS");
            System.out.println("Informe o nome do produto");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < indice; i++) {
                if (nomeConsulta.equalsIgnoreCase(dados[i].getNome())) {
                    controle=false;
                    System.out.println(dados[i].toString());
                    break;
                }
            }
            Invalido(controle);
            escolha = repitir();

        } while (escolha.equalsIgnoreCase("S"));
    }
     
     private void excluirProdutos() {

        String esc;
        do {
            Scanner scan = new Scanner(System.in);
            if (indice == 0) {
                System.err.println("\nLISTA DE PRODUTOS VAZIA!!");
               Opmenu1();
            }
            System.out.println("\nEXCLUSÃO DE PRODUTOS\n");
            System.out.print("NOME DO PRODUTO: ");
            String nomeConsulta = scan.nextLine().toUpperCase();
            boolean controle = true;
            ArrayList<produto> arrayList = new ArrayList();
            arrayList.add(new produto());
            for (int i = 0; i < indice; i++) {
                scan = new Scanner(System.in);
                produto produtos = arrayList.get(i);
                if (!nomeConsulta.equalsIgnoreCase(dados[i].getNome())) {
                } else {
                    controle = false;
                    System.out.println(dados[i].toString());
                    System.out.print("CONFIRMA EXCLUSÃO ( S/N )_");
                    esc = scan.next();
                    if (esc.equalsIgnoreCase("S")) {
                        for (int j = i; j < indice - 1; j++) {
                            dados[j] = dados[j + 1];
                        }
                        indice--;
                    }
                    break;
                }
            }
            Invalido(controle);
            esc = repitir();

        } while (esc.equalsIgnoreCase("S"));
    }
     
    private double valorProduto(double valorUnit) {
        Scanner scanner = new Scanner(System.in);

        if (valorUnit <= 0) {
            System.err.println("ERRO, O VALOR DO PRODUTOD DEVE SER MAIOR 0");
            System.out.print("\nINFORME UM VALOR VÁLIDO: ");
            valorProduto(valorUnit = scanner.nextDouble());
            System.out.println("\n");
        } else {

        }
        return valorUnit;
    }
     
    private void saida() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("SAIDA DE PRODUTOS");
            System.out.print("NOME DO PRODUTO: ");
            String nomeProduto = scanner.nextLine().toUpperCase();

            boolean controle = true;
            for (int i = 0; i < indice; i++) {
                if (nomeProduto.equalsIgnoreCase(dados[i].getNome())) {
                    controle = false;
                    produto produtosMovimentacao = dados[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidade());
                    System.out.print("QTDE SAÍDA : ");
                    int quantidadeSaida = scanner.nextInt();
                    System.err.println("QTDE FINAL : " + (produtosMovimentacao.getQuantidade() - quantidadeSaida));
                    if (produtosMovimentacao.getQuantidade() < quantidadeSaida) {
                        System.out.println("Quantidade maior que no estoque, saída não é possível");
                        break;
                    }
                    escolha = confirmaOp();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setDiminuirQuantidade(quantidadeSaida);
                        dados[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            Invalido(controle);
            escolha = repitir();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void entrada() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ENTRADA DE PRODUTOS");
            System.out.print("NOME DO PRODUTO: ");
            String nomeProduto = scanner.nextLine();
            produto produtosMovimentacao;
            boolean controle = true;
            for (int i = 0; i <indice; i++) {
                if (nomeProduto.equalsIgnoreCase(dados[i].getNome())) {
                    controle = false;
                    produtosMovimentacao = dados[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidade());
                    System.out.print("QTDE ENTRADA : ");
                    int quantidadeEntrada = scanner.nextInt();
                    System.out.print("QTDE FINAL : " + (produtosMovimentacao.getQuantidade() + quantidadeEntrada));
                    escolha = confirmaOp();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setAdicionarQuantidade(quantidadeEntrada);
                        dados[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            Invalido(controle);

            escolha = repitir();

        } while (escolha.equalsIgnoreCase("S"));
    }

     
}
 
 