package view;

import helper.Utils;
import model.Producer;

import java.util.*;

public class Marketplace {

    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Producer> producers;
    private static Map<Producer, Integer> car;

    public static void main(String[] args) {

        producers = new ArrayList<Producer>();
        car = new HashMap<Producer, Integer>();
        Marketplace.menu();
    }
    private static void menu(){
        System.out.println("=========================================");
        System.out.println("============== Marketplace ==============");
        System.out.println("=========================================");

        System.out.println("Selecione uma opção abaixo");
        System.out.println("1 - Cadastrar Produto");
        System.out.println("2 - Listar Produto");
        System.out.println("3 - Comprar Produto");
        System.out.println("4 - Visualizar Carrinho");
        System.out.println("5 - Sair do Sistema");

        int option = 0;

        try{
            option = Integer.parseInt(Marketplace.teclado.nextLine());
        }catch (InputMismatchException e){
            Marketplace.menu();
        }catch (NumberFormatException f) {
            Marketplace.menu();
        }

        switch (option){
            case 1:
                Marketplace.cadastrarProduto();
                break;
            case 2:
                Marketplace.listarProduto();
                break;
            case 3:
                Marketplace.comprarProduto();
                break;
            case 4:
                Marketplace.visualizarCarrinho();
                break;
            case 5:
                System.out.println("Volte Sempre!");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção invalida.");
                Utils.pausar(2);
                Marketplace.menu();
                break;
        }

    }
    private static void cadastrarProduto(){
        System.out.println("Cadastro de Produto");
        System.out.println("===================");

        System.out.println("Informe o nome do produto");
        String nome = Marketplace.teclado.nextLine();

        System.out.println("Informe o preço do produto:");
        Double preco = Marketplace.teclado.nextDouble();

        Producer producer = new Producer(nome, preco);

        Marketplace.producers.add(producer);

        System.out.println("O produto " + producer.getNome() + " Foi cadastrado com sucesso. ");
        Utils.pausar(2);
        Marketplace.menu();

    }
    private static void listarProduto(){
        if(Marketplace.producers.size() > 0){
            System.out.println("Listagem de produtos");
            System.out.println();

            for(Producer p :Marketplace.producers){
                System.out.println(p);
                System.out.println();
            }
            }else{
            System.out.println("Ainda não existe produtos cadastrados");
        }

        Utils.pausar(2);
        Marketplace.menu();
    }
    private static void comprarProduto(){
        if(Marketplace.producers.size() > 0){
            System.out.println("Informe o codigo do produto que deseja comprar: ");
            System.out.println();

            System.out.println("============= Produtos Disponiveis =============");
            for(Producer p : Marketplace.producers){
                System.out.println(p);
                System.out.println("---------------------------------");
            }
            int codigo = Integer.parseInt(Marketplace.teclado.nextLine());
            boolean tem = false;

            for(Producer p : Marketplace.producers){
                if(p.getCodigo() == codigo){
                    int quant = 0;
                    try {
                        quant = Marketplace.car.get(p);
                        Marketplace.car.put(p , quant + 1);
                    }catch(NullPointerException e){
                        Marketplace.car.put(p , 1);
                    }
                    System.out.println("O produto " + p.getNome() + "foi adicionado ao carrinho");
                    tem = true;
                }
                if(tem){
                    System.out.println("Deseja adicionar outros produtos ao carrinho?");
                    System.out.println("Informe 1 para sim ou 0 para não: ");
                    int op = Integer.parseInt(Marketplace.teclado.nextLine());

                    if(op ==1){
                        Marketplace.comprarProduto();
                    }else {
                        System.out.println("Por favor, aguarde enquanto fechamos seu pedido...");
                        Utils.pausar(2);
                        Marketplace.fecharPedido();
                    }
                }else{
                    System.out.println("Não foi encontrado o produto com o cogido " + codigo);
                    Utils.pausar(2);
                    Marketplace.menu();
                }
            }
        }else {
            System.out.println("Ainda não existe produto cadastrado no mercado.");
            Utils.pausar(2);
            Marketplace.menu();
        }
    }
    private static void visualizarCarrinho(){
        if(Marketplace.car.size() > 0){
            System.out.println("Produto no carrinho");

            for(Producer p : Marketplace.car.keySet()){
                System.out.println("Produto: " + p + "\nQuantidade: " + Marketplace.car.get(p));
            }
        }else {
            System.out.println("Ainda não existe produtos no carrinho.");
        }

        Utils.pausar(2);
        Marketplace.menu();
    }

    private static void fecharPedido(){
        Double valorTotal = 0.0;
        System.out.println("Produtos do carrinho");
        System.out.println("-----------------------");

        for(Producer p : Marketplace.car.keySet()){
            int quant = Marketplace.car.get(p);
            valorTotal += p.getPreco() * quant;
            System.out.println(p);
            System.out.println("Qantidade: " + quant);
            System.out.println("---------------------");
        }
        System.out.println("Sua fatura é: " + Utils.doubleParaString(valorTotal));
        Marketplace.car.clear();
        System.out.println("Obrigado pela preferencia");
        Utils.pausar(5);
        Marketplace.menu();
    }




}
