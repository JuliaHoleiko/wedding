
package com.company;

public class Main {



    public static void main(String[] args) {

        Wedding.Graph graph = new Wedding.Graph();
        graph.addPair(1, 2);
        graph.addPair(2, 4);
        graph.addPair(1, 3);
        graph.addPair(3, 5);
        graph.addPair(8, 10);

        graph.findPairs();
    }
}

