package org.example;

import java.util.Stack;

class an {
    static int noOfLegs=2;
     void bark(){
         System.out.println("Animal barks");
     }



}
class dog extends an{
    @Override
    void bark() {
        System.out.println("dog barks");
    }
}


class cat extends an{
    @Override
    void bark() {
        System.out.println("cat barks");
    }
}


public class Animal{
    public static void main(String[] args){

    //Calculator c = (a,b)-> a+b;
    //int output = c.add(1,2);
    //System.out.println(output);

        Calculator c = MultiCalc::mult;
        int output = c.add(2,2);

        System.out.println(output);

        Stack s= new Stack();
        s.push("a");
        s.push(1);

    }

}

class MultiCalc{
    public static int mult(int a,int b){
        return a*b;
    }

    public static int mult2(int a,int b){
        return a*b;
    }
}