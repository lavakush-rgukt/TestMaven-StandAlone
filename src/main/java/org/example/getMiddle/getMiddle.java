package org.example.getMiddle;

import java.util.Scanner;

public class getMiddle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        if(word.length()==0 || word.length()==1){
            System.out.println(word);
        }


        if(word.length()%2==0){
            int first = (word.length()/2)-1;
            int second = first+1;
            System.out.println(String.valueOf(word.charAt(first))+String.valueOf(word.charAt(second)) );
        }else{
            System.out.println( String.valueOf(word.charAt(word.length()/2)));
        }
    }
}
