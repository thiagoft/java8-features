package br.com.thiagoft.examples;

import java.util.function.Consumer;

/**
 * Implementation of Consumer Interface
 *
 * @author thiagofonseca
 */
public class ConsumerImplementation implements Consumer<String> {
    @Override
    public void accept(String string) {
        System.out.println(string);
    }
}
