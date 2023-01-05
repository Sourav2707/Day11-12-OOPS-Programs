package com.bridgelabs.stock_account_management;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class StockAccount implements IAccount{
    static double balance = 10000; //account balance is by default set to 10000 RS
    static Stock stock;
    static ArrayList<Stock> stocks = new ArrayList<>(); //storing each stock's portfolio in this array list
    static String searchByName;
    static int numberOfStocks;
    static double value; //value of the stock based on number of stocks
    static String transaction;
    static ArrayList<String> transactions = new ArrayList<>();
    public void uc1_stockReport() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Available stocks are Reliance, Tata, Infosys, Zoho and HCL");
        System.out.println("Enter the name of the stock which you would like to see");
        searchByName = sc.next(); //in order to see the report user need to search the stock name
        System.out.println("Enter the number of stocks");
        numberOfStocks = sc.nextInt(); //in order to check the value user needs to enter number of stocks
        for(int i = 0; i < stockDetails.size(); i++)
        {
            if(searchByName.equalsIgnoreCase(stocks.get(i).getStockName())) //if the user entered stock name matches to stockPortfolio
            {
                value = numberOfStocks * stocks.get(i).getSharePrice(); //calculating value of the stock based on number of stocks entered by user
                System.out.println(stocks.get(i)+"\nStock Value of "+numberOfStocks+" stock: "+value); //printing stock report
            }
        }
    }
    public void uc2_debit(double withdraw) //as per uc3_implementing in StockAccount class
    {
        if(withdraw <= balance) {
            balance = balance - withdraw;
            transaction = withdraw+" has been debited and the balance is "+balance;
            System.out.println(transaction);
        }
        else {
            transaction = "Insufficient balance, your balance is "+balance+"and the entered amount is "+withdraw;
            System.out.println(transaction);
        }
        transactions.add(transaction);
    }
    ArrayList<String> stockDetails = new ArrayList<>(); //storing the lines from the input file
    int length;
    ArrayList<String> stockName = new ArrayList<>();
    ArrayList<Integer> numberOfShare = new ArrayList<>(); //number of shares left in that company/stock out of hundred
    ArrayList<Integer> sharePrice = new ArrayList<>(); //share price of the company/stock
    String[] stockArray = new String[3];

    //as per uc3 refactoring the code //removed StockFileReader class and implemented in StockAccount class

    static String fileName;
    StockAccount(String fileName) throws IOException {
        this.fileName = fileName;
    }
    public void read() throws FileNotFoundException
    {
        //this file class will help to take the path of the file
        File file = new File(fileName);
        Scanner sc = new Scanner(file); //this scanner will only take the input from this file path
        while(sc.hasNextLine()) {
            stockDetails.add(sc.nextLine()); //this loop will continue unless there is no next line and add each line as a arraylist
        }
        length = stockDetails.size();
        for(int i = 0; i < stockDetails.size(); i++) {
            stockArray = stockDetails.get(i).split(","); //storing the inputs from the line in an array
            stockName.add(stockArray[0]);
            numberOfShare.add(Integer.parseInt(stockArray[1])); //since we have stored in string array we are parsing the value in integer
            sharePrice.add(Integer.parseInt(stockArray[2]));
            stock = new Stock(stockName.get(i), numberOfShare.get(i), sharePrice.get(i));
            stocks.add(stock); //adding each stock details with the help of this loop
        }
    }
    public double valueOf() {
        return value;
    }
    LocalDateTime localDateTime;
    public void buy(int amount, String symbol) throws IOException {
        for(int i = 0; i < stockDetails.size(); i++) {
            if(symbol.equalsIgnoreCase(stocks.get(i).getStockName())) {
                int value = stocks.get(i).getSharePrice() * amount;
                transaction = "Bought "+stocks.get(i).getStockName()+" stocks of "+amount+" worth "+value+" at "+localDateTime.now();
                transactions.add(transaction);
                System.out.println(transaction);
                stocks.get(i).setNumberOfShare(stocks.get(i).getNumberOfShare() - amount);
                save(fileName);
            }
        }
    }
    public void sell(int amount, String symbol) throws IOException {
        for(int i = 0; i < stockDetails.size(); i++) {
            if(symbol.equalsIgnoreCase(stocks.get(i).getStockName())) {
                int value = stocks.get(i).getSharePrice() * amount;
                transaction = "Sold "+stocks.get(i).getStockName()+" stocks of "+amount+" worth "+value+" at "+localDateTime.now();
                transactions.add(transaction);
                System.out.println(transaction);
                stocks.get(i).setNumberOfShare(stocks.get(i).getNumberOfShare() + amount);
                save(fileName);
            }
        }
    }
    static String text;
    public void save(String fileName) throws IOException {
        FileWriter fwriter = new FileWriter(fileName, false);
        for(int i = 0; i < stocks.size(); i++) {
            text = stocks.get(i).getStockName()+","+stocks.get(i).getNumberOfShare()+","+stocks.get(i).getSharePrice()+"\n";
            fwriter.write(text); //overwriting the file with stocks.get
        }
        fwriter.close();
    }
    public void printReport() {
        for(int i = 0; i < stocks.size(); i++) {
            System.out.println(stocks.get(i)); //this will show the current stock availability report
        }
        for(int j = 0; j < transactions.size(); j++) {
            System.out.println(transactions.get(j));  //this will show the user transaction on buy, sell, debit
        }
        System.out.println("Account balance is "+balance); //this will show the balance
    }
}
