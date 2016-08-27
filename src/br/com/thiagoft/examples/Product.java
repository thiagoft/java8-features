package br.com.thiagoft.examples;

/**
 * Product entity to be used on the examples.
 *
 * @author thiagofonseca
 */
public class Product {

    private String name;
    private int amount;

    public Product(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
