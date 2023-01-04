package com.bridgelabs.stock_account_management;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static int option;
    public static void menu() throws FileNotFoundException {
        System.out.println("Menu:\n1. Stock report 2. Account - withdraw 3. Exit");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        switch(option) {
            case 1:
                StockPortfolio.uc1_stockReport(); //uc1 - stock report //related classes {stock, stockFileReader, stockPortfolio}
                menu(); //recursion, so that user will get menu option everytime
                break;
            case 2:
                Account.uc2_Account(); //uc2 - account management - withdraw and balance //related calsses {Account}
                menu();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        menu();
    }
}
