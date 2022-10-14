package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class WorkWithFile {
    void addFile(int path) throws Exception {
        FileWriter writer = new FileWriter("result.txt");
        writer.write(Integer.toString(path));
        writer.flush();
    }


    ArrayList <Integer> readFile() throws Exception {
        File file = new File("task.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        //int[] input = new int[5];
        ArrayList <Integer> input= new ArrayList<>();

        //int i = 0;
        while ((st = br.readLine()) != null) {
            if (st.contains("\s")) {
                String[] arr = st.split("\s");
                int pos_x, pos_y;
                pos_x = Integer.parseInt(arr[0]);
                pos_y = Integer.parseInt(arr[1]);
                input.add( pos_x);
                input.add(pos_y);


            } else {
                input.add( Integer.parseInt(st));

            }
        }

        return input;
    }
}
