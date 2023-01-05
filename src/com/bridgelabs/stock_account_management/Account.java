package com.bridgelabs.stock_account_management;

import java.io.IOException;

interface IAccount {
    void uc2_debit(double withdraw); //belongs to uc2
    //uc3 methodws as follows
    double valueOf();
    void buy(int amount, String stockName) throws IOException;
    void sell(int amount, String stockName) throws IOException;
    void save(String filename) throws IOException;
    void printReport();
}
