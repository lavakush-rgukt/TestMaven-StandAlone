package org.example.createPhoneNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class createPhoneNumber {
    public static void main(String[] args) {
        int[] numbers= {1,2,3,4,5,6,7,8,9,0};

        String st = Arrays.stream(numbers)
                .boxed()
                .map(x->String.valueOf(x))
                .collect(Collectors.joining(""));

        String temp = "("+st.substring(0,3)+") "+st.substring(3,6)+"-"+st.substring(6,9);

        System.out.println(temp);
    }
}
