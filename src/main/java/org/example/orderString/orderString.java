package org.example.orderString;

import java.util.*;
import java.util.stream.Collectors;

public class orderString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();

        //"is2 Thi1s T4est 3a"

        String[] stArr = st.split(" ");

        Map<String,Integer> mp= new LinkedHashMap<>();
        for (String tempSt:stArr
             ) {
            mp.put(tempSt,Integer.parseInt(tempSt.replaceAll("[^1-9]","")));
        }
        System.out.println(mp);
        String sttt =  mp.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(x->x.getKey())
                .collect(
                        Collectors.joining(" ")
                );

        System.out.println(sttt);
    }
}
