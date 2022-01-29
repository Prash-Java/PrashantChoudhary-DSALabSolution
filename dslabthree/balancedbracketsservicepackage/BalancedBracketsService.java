package com.greatlearning.dslabthree.balancedbracketsservicepackage;

import java.util.Stack;

public class BalancedBracketsService {
    public static boolean checkIfBracketsSequenceIsBalanced(String bracketsExpression) {
        Stack<Character> stack = new Stack<>();
        char poppedCharacter;
        for (int i = 0; i < bracketsExpression.length(); i++) {
            char currentBracket = bracketsExpression.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
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
        return (stack.isEmpty());
    }
}
