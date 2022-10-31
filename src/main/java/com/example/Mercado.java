package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Comprar");
        System.out.println("4 - Carrinho");
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
                System.out.println("Obrigada pela preferência");
                // System.exit();
            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
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
                    int quantity = 0;
                    try {
                        quantity = carrinho.get(p);
                        carrinho.put(p, quantity++);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getName() + " adicionado ao carrinho");
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
                    } else {
                        System.out.println(" Produto não encontrado.");
                        menu();
                    }
                }
            }
        } else {
            System.out.println("Não existem produtos cadastrados.");
            menu();
        }
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

    private static void cadastrarProduto() {
        System.out.println("Nome do produto: ");
        String name = input.next();

        System.out.println("Preço do produto: ");
        Double price = input.nextDouble();

        Produto produto = new Produto(name, price);
        produtos.add(produto);

        System.out.println(produto.getName() + " cadastrado com sucesso!");
        menu();
    }

}
