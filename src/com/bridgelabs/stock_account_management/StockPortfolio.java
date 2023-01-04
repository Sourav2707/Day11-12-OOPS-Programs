package com.bridgelabs.stock_account_management;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio extends StockFileReader {
    static Stock stock;
    static ArrayList<Stock> stocks = new ArrayList<>(); //storing each stock's portfolio in this array list
    static String searchByName;
    static int numberOfStocks;
    static int value; //value of the stock based on number of stocks
    public static void uc1_stockReport() throws FileNotFoundException {
        StockPortfolio stockPortfolio = new StockPortfolio();
        Scanner sc = new Scanner(System.in);
        System.out.println("Available stocks are Reliance, Tata, Infosys, Zoho and HCL");
        System.out.println("Enter the name of the stock which you would like to see");
        searchByName = sc.next(); //in order to see the report user need to search the stock name
        System.out.println("Enter the number of stocks");
        numberOfStocks = sc.nextInt(); //in order to check the value user needs to enter number of stocks
        stockPortfolio.read(); //since we have inheritted this will call the read function from stockfileReader class
        for(int i = 0; i < stockPortfolio.stockDetails.size(); i++)
        {
            stock = new Stock(stockPortfolio.stockName.get(i), stockPortfolio.numberOfShare.get(i), stockPortfolio.sharePrice.get(i));
            stocks.add(stock); //adding each stock details with the help of this loop
            if(searchByName.equalsIgnoreCase(stocks.get(i).getStockName())) //if the user entered stock name matches to stockPortfolio
            {
                value = numberOfStocks * stocks.get(i).getSharePrice(); //calculating value of the stock based on number of stocks entered by user
                System.out.println(stocks.get(i)+"\nStock Value of "+numberOfStocks+" stock: "+value); //printing stock report
            }
        }
    }
}
