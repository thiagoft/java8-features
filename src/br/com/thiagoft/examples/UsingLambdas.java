package br.com.thiagoft.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The Lambda expressions are used for Interfaces that have one method to implement.
 * An interface with a single abstract method are called Functional Interface.
 *
 * @author thiagofonseca
 */
public class UsingLambdas {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("test");
        words.add("another test of this code");
        words.add("developer's life");

        /**
         * The new default method of List sort works like the code below.
         */
        //before java 8
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length()) {
                    return -1;
                } else if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        /**
         * Lambda expression for the code above
         */
        words.sort((String s1, String s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else {
                if (s1.length() > s2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });



        /**
         * Simplifying the lambda expression.
         * The compiler knows the arguments type, then you don't have to write it.
         */
        words.sort((string1,string2) -> {
            if (string1.length() < string2.length()) {
                return -1;
            } else {
                if (string1.length() > string2.length()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        /**
         * Function is a new Interface of the java 8, it means: given a String, return a Integer;
         * "comparing" is a static default method of Comparator.
         */
        Function<String, Integer> function = string -> string.length();
        //the code bellow represents the lambda expression above
//        Function<String, Integer> function = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String string) {
//                return string.length();
//            }
//        }
        //or
        /**
         * This example use a "reference method", it means given a String, return it's method length
         */
//        Function<String, Integer> function = String::length;
        Comparator<String> comparator = Comparator.comparing(function);
        words.sort(comparator);

        /**
         * The code above can be simplified
         */
        words.sort(Comparator.comparing(string -> string.length()));

        /**
         * The new default method of Iterable forEach works like the code below.
         */
        words.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        /**
         * If I'm using the Consumer Interface obviously the "accept" method have to be implemented then
         * I can use Lambda for that. The compiler is the responsible to know that a forEach receive a
         * Consumer and also implements a method with N arguments, in this case a String.
         */
        words.forEach((String s) -> {
            System.out.println(s);
        });

        /**
         * If the method has a single argument then you can just use the name of the variable and also
         * when the method has a single statement you can take off the "{}"
         */
        words.forEach(string -> System.out.println(string));
        /**
         * This example use a "reference method", it means given a System.out, return it's method println
         */
        words.forEach(System.out::println);
    }
}
