package com.greatlearning.dslabthree.balancedbracketsdriverpackage;

import com.greatlearning.dslabthree.balancedbracketsservicepackage.BalancedBracketsService;

import java.util.Scanner;

public class BalancedBracketsDriver {
    static BalancedBracketsService balancedBracketsService=new BalancedBracketsService();
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Please Enter String With Brackets Sequences:");
        String bracketsString= sc.nextLine();
        boolean status=false;
        if(bracketsString.length()>1){
            status=balancedBracketsService.checkIfBracketsSequenceIsBalanced(bracketsString);
            if(status==true){
                System.out.println("The entered String has Balanced Brackets");
            }
            else{
                System.out.println("The entered Strings do not contain Balanced Brackets");
            }
        }
        else{
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
