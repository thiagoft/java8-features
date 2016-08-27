package br.com.thiagoft.examples;

import java.util.Comparator;

/**
 * Comparator of Strings by Length
 *
 * @author thiagofonseca
 */
public class ComparatorByLength implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return -1;
        } else if (o1.length() > o2.length()) {
            return 1;
        }
        return 0;
    }
}
