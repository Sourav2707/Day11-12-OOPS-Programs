package com.bridgelabs.stock_account_management;
import java.util.Scanner;
public class Account {
    static double balance = 10000; //account balance is by default set to 10000 RS
    static double withdraw;
    public static void uc2_Account() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to be withdrawn");
        withdraw = sc.nextDouble();
        if(withdraw <= balance) {
            balance = balance - withdraw;
            System.out.println(withdraw+" has been debited and the balance is "+balance);
        }
        else {
            System.out.println("Insufficient balance, your balance is "+balance+"and the entered amount is "+withdraw);
        }
    }
}
