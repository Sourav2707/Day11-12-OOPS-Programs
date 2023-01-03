package com.bridgelabs.stock_account_management;

public class Stock {
    private String stockName;
    private int numberOfShare;
    private int sharePrice;

    public Stock(String stockName, int numberOfShare, int sharePrice) {
        this.stockName = stockName;
        this.numberOfShare = numberOfShare;
        this.sharePrice = sharePrice;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getNumberOfShare() {
        return numberOfShare;
    }

    public void setNumberOfShare(int numberOfShare) {
        this.numberOfShare = numberOfShare;
    }

    public int getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(int sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String toString() {
        return "\nStock name: "+stockName+"\nNumber of shares available: "+numberOfShare
                +"\nShare price: "+sharePrice;
    }
}
