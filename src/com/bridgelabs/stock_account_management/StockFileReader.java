package com.bridgelabs.stock_account_management;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class StockFileReader {
    ArrayList<String> stockDetails = new ArrayList<>(); //storing the lines from the input file
    int length;
    ArrayList<String> stockName = new ArrayList<>();
    ArrayList<Integer> numberOfShare = new ArrayList<>(); //number of shares left in that company/stock out of hundred
    ArrayList<Integer> sharePrice = new ArrayList<>(); //share price of the company/stock
    String[] stockArray = new String[3];
    public void read() throws FileNotFoundException
    {
        //this file class will help to take the path of the file
        File file = new File("C:\\Users\\Sourav Prasanna\\IdeaProjects\\Day11-12-OOPS-Programs\\src\\com\\bridgelabs\\stock_account_management\\StockPortfolio");
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
        }
    }
}
