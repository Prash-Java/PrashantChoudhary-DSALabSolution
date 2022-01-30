package com.greatlearning.dslabthree.balancedbracketsservicepackage;

import java.util.Stack;
//Service Class that checks if given brackets sequence is balanced
public class BalancedBracketsService {
    public static boolean checkIfBracketsSequenceIsBalanced(String bracketsExpression) {
        //we implement using inbuilt Stack class
        Stack<Character> stack = new Stack<>();
        //using variable to hold stack.pop() at different stages in program
        char poppedCharacter;
        for (int i = 0; i < bracketsExpression.length(); i++) {
            char currentBracket = bracketsExpression.charAt(i);
            /*below if statement will perform stack.push() operation when character is in (,{,[ only and would byepass below
                codes if relevant opening braces are encountered, so we used continue;*/
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
                continue;
            }
            //this will be checked as it is possible user bracketsString has initial characters like ),},], so stack will be empty
            if (stack.isEmpty()) {
                return false;
            }
            //checking other possible negative cases, this logic also inhibits LIFO, Top of Stack while performing stack.pop()
            switch (currentBracket) {
                case ')':
                    poppedCharacter = stack.pop();
                    if (poppedCharacter == '{' || poppedCharacter == '[') {
                        return false;
                    }
                    break;
                case ']':
                    poppedCharacter = stack.pop();
                    if (poppedCharacter == '(' || poppedCharacter == '{') {
                        return false;
                    }
                    break;
                case '}':
                    poppedCharacter = stack.pop();
                    if (poppedCharacter == ')' || poppedCharacter == ']') {
                        return false;
                    }
                    break;
            }
        }
        //equally important checkpoint, in case if all characters in brackets are checked, and still stack may not be empty
        return (stack.isEmpty());
    }
}
