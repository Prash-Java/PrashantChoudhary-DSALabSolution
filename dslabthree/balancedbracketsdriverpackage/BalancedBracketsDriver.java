package com.greatlearning.dslabthree.balancedbracketsdriverpackage;

import com.greatlearning.dslabthree.balancedbracketsservicepackage.BalancedBracketsService;

import java.util.Scanner;

//Driver Class
public class BalancedBracketsDriver {
    //Object Instances From Service Class And Scanner Class
    static BalancedBracketsService balancedBracketsService = new BalancedBracketsService();
    static Scanner sc = new Scanner(System.in);
    //Main Driver Method
    public static void main(String[] args) {
        System.out.println("Please Enter String With Brackets Sequences:");
        String bracketsString = sc.nextLine();
        boolean status = false;
        //checking if entered bracket sequences contains at least a pair brackets, otherwise it definitely cant be balanced
        if (bracketsString.length() > 1) {
            //calling service class method that will eventually return boolean value
            status = balancedBracketsService.checkIfBracketsSequenceIsBalanced(bracketsString);
            if (status == true) {
                System.out.println("The entered String has Balanced Brackets");
            } else {
                System.out.println("The entered Strings do not contain Balanced Brackets");
            }
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}