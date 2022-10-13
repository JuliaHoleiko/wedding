package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Wedding {

        static class Pair {
            int person1;
            int person2;

            public Pair(int person1, int person2) {
                this.person1 = person1;
                this.person2 = person2;
            }
        }

        static class Graph {
            ArrayList<Pair> allPairs = new ArrayList<>();
            HashMap<Integer, Integer> mapOfPersons = new HashMap<>();
            int count;

            Graph() {
                count = 0;

            }

            public void addPair(int person1, int person2) {
                Pair pair = new Pair(person1, person2);

                allPairs.add(pair);
                if (!mapOfPersons.containsValue(person1)) {
                    mapOfPersons.put(count, person1);
                    count++;
                }
                if (!mapOfPersons.containsValue(person2)) {
                    mapOfPersons.put(count, person2);
                    count++;
                }
            }


            public int find(int[] parent, int person) {

                if (parent[person] != person)
                    return find(parent, parent[person]);
                return person;
            }

            public void union(int[] parent, int p1, int p2) {
                int p1_set_parent = find(parent, p1);
                int p2_set_parent = find(parent, p2);

                if (p1_set_parent < p2_set_parent)

                    parent[p2_set_parent] = p1_set_parent;
                else parent[p1_set_parent] = p2_set_parent;
            }

            public void findPairs() {
                int[] parent = new int[count];
                for (int i = 0; i < count; i++) {
                    parent[i] = i;
                }

                for (int i = 0; i < allPairs.size(); i++) {
                    Pair pair = allPairs.get(i);

                    int x_set = find(parent, mapOfPersons.values().stream().toList().indexOf(pair.person1));
                    int y_set = find(parent, mapOfPersons.values().stream().toList().indexOf(pair.person2));

                    if (x_set == y_set) {

                    } else
                        union(parent, x_set, y_set);
                }

                makeSets(parent);

            }

            public void makeSets(int[] parent) {
                HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
                int girls, boys, pairs;
                pairs = 0;

                for (int i = 0; i < parent.length; i++) {

                    if (map.containsKey(parent[i])) {

                        ArrayList<Integer> list = map.get(parent[i]);
                        list.add(mapOfPersons.get(i));//add vertex
                        map.put(parent[i], list);
                    } else {

                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(mapOfPersons.get(i));
                        map.put(parent[i], list);
                    }
                }

                Set<Integer> set = map.keySet();
                Iterator<Integer> iterator = set.iterator();
                ArrayList<Integer> gender = new ArrayList<>();
                while (iterator.hasNext()) {
                    int key = iterator.next();
                    System.out.println("Set Id: " + key + " elements: " + map.get(key));
                    girls = Long.valueOf(map.get(key).stream().filter(x -> x % 2 == 0).count()).intValue();
                    gender.add(girls);
                    boys = map.get(key).size() - girls;
                    gender.add(boys);

                }

                for (int i = 0; i < gender.size() - 2; i++) {
                    if (i % 2 == 0)
                        pairs = pairs + gender.get(i) * gender.get(i + 3);
                    else
                        pairs = pairs + gender.get(i) * gender.get(i + 1);
                }
                System.out.println(pairs);

            }

        }

    }
