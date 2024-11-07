package org.example.StringSplit;

import java.util.Arrays;
import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        System.out.println("lleng "+s.length());
        System.out.println("lleng "+((s.length()%2)==0));
        System.out.println("lleng "+(s.length()/2));
        int arrLen= s.length()%2==0?s.length()/2:(s.length()/2)+1;
        String[] st = new String[arrLen];

        int arrayIndex=0;
        for(int i=0;i<s.length();i=i+2){
            String ss = s.charAt(i)+"";
            if((i+1) <s.length()){
                ss = ss+ s.charAt(i+1);
            }


             st[arrayIndex] = ss;
            arrayIndex++;
        }

        if((s.length()%2!=0) && (st[st.length-1].length()==1)){
            st[st.length-1] = st[st.length-1] +"_";
        }

        for (String temp: st
             ) {
            System.out.println(temp);
        }



    }
}
