package com.example;

import com.example.Utils;

public class Produto {
    private static int count = 1;
    protected int id;
    protected String name;
    protected Double price;

    /**
     * @param name
     * @param price
     */

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Produto(String name, Double price) {
        this.id = Produto.count;
        this.name = name;
        this.price = price;

        Produto.count++;
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + "\nNome do produto: " + this.getName() + "\nPreço do produto: "
                + Utils.doubleToString(this.getPrice());
    }
}
