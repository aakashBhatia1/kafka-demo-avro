package com.kafkademo.springboot.Controller;

import com.kafkademo.avro.schema.StockHistory1;
import com.kafkademo.avro.schema.StockHistorynew;
import com.kafkademo.springboot.kafka.AvroKafkaProducer;
import com.kafkademo.springboot.model.StockHistoryModel;
import com.kafkademo.springboot.model.StockHistoryModel2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SpringAvroRestController {

    @Autowired
    private AvroKafkaProducer springAvroProducer;


    /*
    curl --location --request POST 'http://localhost:9081/avropublish1' \
--header 'Content-Type: application/json' \
--data-raw '{
    "tradeQuantity":12,
    "tradeMarket":"NSE",
    "stockName":"Tata steel",
    "tradeType":"SEL",
    "price":126.4,
    "amount":22
}'
     */

    @PostMapping(value = "/avropublish1")
    public void sendStockHistory(@RequestBody StockHistoryModel model){
        StockHistory1 stockHistory= StockHistory1.newBuilder().build();
        stockHistory.setStockName(model.getStockName());
        stockHistory.setTradeType(model.getTradeType());
        stockHistory.setPrice(model.getPrice());
        stockHistory.setAmount(model.getAmount());
        stockHistory.setTradeId(new Random(1000).nextInt());
        stockHistory.setTradeMarket(model.getTradeMarket());
        stockHistory.setTradeQuantity(model.getTradeQuantity());
        springAvroProducer.send(stockHistory);
    }


    /*
    curl --location --request POST 'http://localhost:9081/avropublishnew' \
--header 'Content-Type: application/json' \
--data-raw '{
    "tradeQuantity":12,
    "tradeMarket":"NSE",
    "stockName":"Tata steel",
    "tradeType":"SEL",
    "price":126.4,
    "amountNew":22
}'
     */

    //sending 2nd one, where amount is now amountNew
    @PostMapping(value = "/avropublishnew")
    public void sendStockHistorywithamountnew(@RequestBody StockHistoryModel2 model){
        StockHistorynew stockHistory= StockHistorynew.newBuilder().build();
        stockHistory.setStockName(model.getStockName());
        stockHistory.setTradeType(model.getTradeType());
        stockHistory.setPrice(model.getPrice());
        stockHistory.setAmountNew(model.getAmountNew());
        stockHistory.setTradeId(new Random(1000).nextInt());
        stockHistory.setTradeMarket(model.getTradeMarket());
        stockHistory.setTradeQuantity(model.getTradeQuantity());
        springAvroProducer.send(stockHistory);
    }
}
