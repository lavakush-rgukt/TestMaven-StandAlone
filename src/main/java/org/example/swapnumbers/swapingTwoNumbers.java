package org.example.swapnumbers;

public class swapingTwoNumbers {
    public static void main(String[] args) {
        int a=1;
        int b=2;

        //without using 3rd variable
        a = a+b;
        b= a-b;
        a= a-b;


        a=1;
        b=2;
        //using multiplecation and division
        a=a*b;
        b=a/b;
        a=a/b;

        System.out.println( a+" "+b);
    }
}
