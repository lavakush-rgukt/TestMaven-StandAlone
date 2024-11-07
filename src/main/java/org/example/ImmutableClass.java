package org.example;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClass {

    public static void main(String[] args) {

        int a=1;
        String b="Abinav";

        Map<String,String> m = new HashMap<>();
        m.put("a","a");
        m.put("b","b");

        ImmutableObj i = new ImmutableObj(a,b, m);
        m.put("b","c");




        System.out.println("after->"+i.toString());

    }
}

