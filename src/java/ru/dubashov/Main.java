package ru.dubashov;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println(" no arguments in command line. Try again.");
        } else {
            String path = args[0];
            List<Integer> list = ReadXML.getNumbers(path);
            Collections.sort(list);

//          Делим список пополам и выводим его
            for (int i = list.size() / 2 - 1, j = list.size() / 2; i >= 0; i--, j++) {
                System.out.println(list.get(i) + " " + j + list.get(j));
            }
        }
    }
}






