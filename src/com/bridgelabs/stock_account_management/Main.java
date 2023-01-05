package com.bridgelabs.stock_account_management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int option;
    static int amount;
    static double withdraw;
    static String stockName;
    static String fileName = "C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day11-12-OOPS-Programs\\src\\com\\bridgelabs\\stock_account_management\\StockPortfolio";
    public static void menu() throws IOException {//this file class will help to take the path of the file
        StockAccount stockAccount = new StockAccount(fileName);
        System.out.println("Menu:\n1. Stock report 2. Debit 3. Buy 4. Sell 5. Save 6. PrintReport 7. Exit");
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();
        stockAccount.read();
        switch(option) {
            case 1:
                stockAccount.uc1_stockReport(); //uc1 - stock report //related classes {stock, stockFileReader, stockPortfolio}
                menu(); //recursion, so that user will get menu option everytime
                break;
            case 2:
                System.out.println("Enter the amount to be withdrawn");
                withdraw = sc.nextDouble();
                stockAccount.uc2_debit(withdraw); //uc2 - account management - withdraw and balance //related calsses {Account}
                menu();
                break;
            case 3:
                System.out.println("Enter the name of the stock");
                stockName = sc.next();
                System.out.println("Enter number of stock to be purchased");
                amount = sc.nextInt();
                stockAccount.buy(amount, stockName);
                menu();
                break;
            case 4:
                System.out.println("Enter the name of the stock");
                stockName = sc.next();
                System.out.println("Enter number of stock to be purchased");
                amount = sc.nextInt();
                stockAccount.sell(amount, stockName);
                menu();
                break;
            case 5:
                stockAccount.save(fileName);
                menu();
                break;
            case 6:
                stockAccount.printReport();
                menu();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option");
                menu();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        menu();
    }
}
