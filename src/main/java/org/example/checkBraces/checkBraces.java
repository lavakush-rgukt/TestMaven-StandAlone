package org.example.checkBraces;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class checkBraces {
    public static void main(String[] args) {
        String braces = "(){}[]";
        boolean result = false;
        if(braces.length()%2!=0){
            result = false;
        }
        Stack<Character> stack= new Stack<>();

        for(Character c:braces.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else if(c==')' || c=='}' || c==']'){
                if(stack.isEmpty()){
                    result =false;
                    break;
                }
                Character lastbracker = stack.pop();
                if(!isMatchingPair(lastbracker,c)){
                    result = false;
                }


            }
        }

        result = stack.isEmpty();



    }

    private static boolean isMatchingPair(Character open, Character close) {

        return (open=='{' && close=='}' ) || (open=='[' && close==']' ) ||(open=='(' && close==')' );
    }


}
