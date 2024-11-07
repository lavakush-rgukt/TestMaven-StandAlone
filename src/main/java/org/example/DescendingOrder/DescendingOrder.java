package org.example.DescendingOrder;

import java.util.*;
import java.util.stream.Collectors;

public class DescendingOrder {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        String input = String.valueOf(n);

 String ss = Arrays.stream(input.split(""))
         .sorted(Comparator.reverseOrder())
         .map(String::valueOf)
         .collect(Collectors.joining(""));
        System.out.println(ss.toString());



    }
}
