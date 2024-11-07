package org.example.reverseNumber;

import java.util.Scanner;

public class reversceNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int num=0;
        while(a!=0){
            num = num*10 + a%10;
            a=a/10;
        }
        System.out.println(num);
    }
}
