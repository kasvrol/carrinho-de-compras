public class Produtos {
    private static int count = 1;
    private int id;
    private String name;
    private Double price;

    public Double getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getName() {
        return name;
    }

    public void setName(Double name) {
        this.name = price;
    }

    public Produto(String name, Double price){
        this.id = Produtos.count;
        this.name = name;
        this.price = price;

        Produtos.count++;
    }

}
