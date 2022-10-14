
package com.company;


import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        WorkWithFile wr = new WorkWithFile();
        ArrayList arr  = wr.readFile();
        int size = (int) arr.get(0);
        System.out.println(size);

        Wedding.Graph graph = new Wedding.Graph();
        for(int i = 1; i < size*2; i=i+2){
            graph.addPair((Integer) arr.get(i), (Integer) arr.get(i+1));
        }
        graph.findPairs();
    }
}

