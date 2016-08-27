package br.com.thiagoft.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author thiagofonseca
 */
public class UsingStream {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Macbook Pro",10));
        products.add(new Product("Macbook Air",20));
        products.add(new Product("iPhone",100));
        products.add(new Product("iPad",90));

        /**
         * given a Product compare for attribute amount
         */
        products.sort(Comparator.comparing(product -> product.getAmount()));
        //or
        /**
         * given a Product compare for attribute amount
         */
        products.sort(Comparator.comparing(Product::getAmount));

        /**
         * New Interface of java 8, the Streams provide many tools for work with Collections.
         * In this case, the method filter apply a filter for the Collection and then iterate
         * with a forEach method printing the name of the product.
         *
         * Note:
         * - The stream method works with Fluent Interface then you can see a chain.
         * - The stream manipulation don't affect the original Collection
         */
        products.stream()
                .filter(product -> product.getAmount() >= 90)
                .forEach(product -> System.out.println(product.getName()));

        /**
         * The method map generate a new Type of Stream in dependency of the Predicate.
         * The Java 8 works with tnt double and long to prevent the use of Auto-Boxing/Unboxing,
         * for example the mapToInt. It brings some advantages for example methods that manipulate
         * these type of values, the method sum in this case, sum the result of the filter.
         */
        products.stream()
                .filter(product -> product.getAmount() >= 90)
                .mapToInt(Product::getAmount)
                .sum();

        /**
         * In Java 8, the new Interface Optional represents a possible product, it makes easy to
         * manipulate or prevent NullPointerExceptions. In this same code the use of the method
         * findAny() brings one of the results.
         */
        Optional<Product> productOptional =  products.stream()
                .filter(product -> product.getAmount() > 200)
                .findAny();

        productOptional.ifPresent(product -> System.out.println(product.getName()));

        /**
         * Another way to write this code using lambda
         */
        products.stream()
                .filter(product -> product.getAmount() > 6)
                .findAny()
                .ifPresent(product -> System.out.println(product.getName()));

        /**
         * You can return a List<T> from a Stream as well.
         * The method collect and the Interface Collectors works on the conversion of the
         * stream for the typed collection.
         */
        products = products.stream()
                .filter(product -> product.getAmount() > 6)
                .collect(Collectors.toList());

        /**
         * Map Example
         */
        products.stream()
                .filter(product -> product.getAmount() > 6)
                .collect(Collectors.toMap(
                        product -> product.getName(), //key
                        product -> product.getAmount() //value
                ))
                /**
                 * For maps the forEach receive a BiConsumer as argument
                 *
                 * BiConsumer<String, Integer> biConsumer = (name, amount) -> System.out.println(name+" - "+amount);
                 * given a name give me an amount and print both;
                 */
                .forEach((name, amount) -> System.out.println(name+" - "+amount));


    }

}
