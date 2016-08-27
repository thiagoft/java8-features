package br.com.thiagoft.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Some examples of the new features in Collections.
 *
 * @author thiagofonseca
 */
public class UsingNewCollectionMethods {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("test");
        words.add("another test of this code");
        words.add("developer's life");

        //before java 8
//        ComparatorByLength comparator = new ComparatorByLength();
//        Collections.sort(words,comparator);
//        System.out.println(words); //output: [test, developer's life, an other testing this code]

        //after java 8
        ComparatorByLength comparator = new ComparatorByLength();
        words.sort(comparator);
        /**
         * The method sort is a method implemented inside of the Interface List
         * it's possible on Java 8 and called Default Methods, making possible
         * to evolve an Interface without break its implementations.
         */
        System.out.println(words); //output: [test, developer's life, another test of this code]

        //before java 8
        for (String word : words) {
            System.out.println(word);
        }

        //after java 8
        Consumer<String> consumer = new ConsumerImplementation();
        /**
         * The new default method of Iterable forEach works like the code below.
         */
        words.forEach(consumer);

    }

}
