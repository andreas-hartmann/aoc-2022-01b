package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/resources/input"));
        List<Integer> inputs = new ArrayList<>();
        while (sc.hasNext()) {
            String inputLine = sc.nextLine();
            if (inputLine.isBlank()) {
                inputs.add(-1);
            } else {
                inputs.add(Integer.parseInt(inputLine));
            }
        }

        int buf = 0;
        List<Integer> sums = new ArrayList<>();
        for (Integer input : inputs) {
            if (input != -1) {
                buf += input;
            } else {
                sums.add(buf);
                buf = 0;
            }
        }

        sums.sort(reverseOrder());

        int total = 0;
        System.out.println("Top three calories carried:");
        for (int i = 0; i < 3; i++) {
            total += sums.get(i);
            System.out.println(sums.get(i));
        }

        System.out.println("Total sum: " + total);
    }
}