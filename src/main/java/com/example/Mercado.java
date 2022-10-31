package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static List<Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new ArrayList<>();
        menu();
    }

    private static void menu() {
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Comprar");
        System.out.println("4 - Ver carrinho");
        System.out.println("5 - Sair");

        int option = input.nextInt();

        switch (option) {
            case 1:
                cadastrarProduto();
                break;
            case 2:
                listarProduto();
                break;
            case 3:
                comprarProduto();
                break;
            case 4:
                verCarrinho();
                break;
            case 5:
                System.out.println("Obrigada pela preferência");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
    }

    private static void cadastrarProduto() {
        System.out.println("Nome do produto: ");
        String name = input.next();

        System.out.println("Preço do produto: ");
        Double price = input.nextDouble();

        Produto produto = new Produto(name, price);
        produtos.add(produto);
        carrinho.add(0);

        System.out.println(produto.getName() + " cadastrado com sucesso!");
        menu();
    }

    private static void listarProduto() {
        if (produtos.size() > 0) {
            System.out.println("Listar produtos! \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void comprarProduto() {
        if (produtos.size() > 0) {
            System.out.println("Código do produto: \n");

            System.out.println("---------------------- Produtos Disponíveis ----------------------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int position = produtos.indexOf(p);
                    int quantity = 0;
                    try {
                        quantity = carrinho.get(position);
                        carrinho.set(position, quantity + 1);
                    } catch (NullPointerException e) {
                        carrinho.set(position, quantity + 1);
                    }

                    System.out.println(carrinho.get(position) + " " + p.getName() + " adicionado ao carrinho");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println(" Deseja adicionar outro produto ao carrinho?");
                        System.out.println(" Digite 1 para sim, ou 0 para finalizar a compra. \n");

                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProduto();
                        } else {
                            finalizarCompra();
                        }
                    }
                } else {
                    System.out.println(" Produto não encontrado.");
                    menu();
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados.");
            menu();
        }
    }

    private static void verCarrinho() {
        System.out.println("Produtos no carrinho: \n");
        if (produtos.size() > 0) {
            for (Produto p : produtos) {
                System.out.println("Produto: " + p + "\n" + "Quantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Não existe produto no carrinho, deseja adicionar?");
            System.out.println(" Digite 1 para sim, ou 0 para sair. \n");
            int option = Integer.parseInt(input.next());

            if (option == 1) {
                comprarProduto();
            } else {
                System.exit(0);
            }
        }
    }

    private static void finalizarCompra() {
        Double valorTotal = 0.0;
        List<Integer> position;
        position.add(0);

        if(carrinho.size()>0){
            for (carrinho : carrinho.) {
                position.add(carrinho.length);
            }
        }
        

        System.out.println("Seus produtos");
        for (carrinho.) {

        }
        for (Produto p : carrinho.get(!0)) {
            int quantity = carrinho.get(p);
            valorTotal += p.getPrice() * quantity;
            System.out.println(p);
            System.out.println("Quantidade: " + quantity);
            System.out.println("----------------------------");
        }

        System.out.println("O valor da sua compra é:" + Utils.doubleToString(valorTotal));
        carrinho.clear();
        System.out.println("Obrigado pela preferência!");
        menu();
    }

}
