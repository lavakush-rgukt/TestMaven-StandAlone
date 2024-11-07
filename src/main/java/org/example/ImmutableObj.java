package org.example;


import java.util.HashMap;
import java.util.Map;

public final class ImmutableObj{

    private  final int a;
    private  final String name;
    private final Map<String,String> map;



    public  ImmutableObj(int a, String name, Map<String, String> map){
        this.a=a;
        this.name=name;

        //we need to perform deep copy insted to giving refrence
        Map<String, String> tempMap = new HashMap<>();

        // Iterating using for-each loop
        for (Map.Entry<String, String> entry : map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.map = tempMap;
    }

    public int getA(){
        return this.a;
    }

    public String getName(){
        return this.name;
    }

    public Map<String, String> getMap() {
        // Iterating using for-each loop
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        return tempMap;
    }

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "a=" + a +
                ", name='" + name + '\'' +
                ", map=" + map +
                '}';
    }
}
