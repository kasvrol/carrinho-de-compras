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
    }

    private static void listarProduto() {
    }

    private static void cadastrarProduto() {
    }

}
