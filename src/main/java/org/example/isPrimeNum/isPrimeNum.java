package org.example.isPrimeNum;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class isPrimeNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println("traditional-> "+isPrime(num));

        System.out.println("java8-> "+isPrimeJava8(num));
    }

    private static boolean isPrimeJava8(int num) {


        return num>1 && IntStream.range(2,num).noneMatch(x->num%x==0);
    }

    public static boolean isPrime(int num){
        boolean isDivisible=false;
        for(int i=2;i<num;i++){
            if(num%i==0){
                isDivisible=true;
                break;
            }
        }

        return num>1 && !isDivisible;
    }
}
