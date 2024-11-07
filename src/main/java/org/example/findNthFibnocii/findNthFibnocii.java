package org.example.findNthFibnocii;

public class findNthFibnocii {

    public static void main(String[] args) {
        int num = fibnoccii(10);
        System.out.println(num);
    }

    private static int fibnoccii(int i) {
        if(i==0) return 0;
        if(i==1) return 1;

        return fibnoccii(i-1)+fibnoccii(i-2);

    }
}
