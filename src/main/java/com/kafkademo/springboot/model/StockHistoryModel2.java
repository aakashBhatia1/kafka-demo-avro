package com.kafkademo.springboot.model;

public class StockHistoryModel2 {

    private int tradeQuantity;
    private String tradeMarket;
    private String stockName;
    private String tradeType;
    private float price;
    private float amountNew;

    public int getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(int tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }

    public String getTradeMarket() {
        return tradeMarket;
    }

    public void setTradeMarket(String tradeMarket) {
        this.tradeMarket = tradeMarket;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmountNew() {
        return amountNew;
    }

    public void setAmountNew(float amountNew) {
        this.amountNew = amountNew;
    }
}
