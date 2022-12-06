package com.kafkademo.springboot.kafka;

import com.kafkademo.avro.schema.StockHistory1;
import com.kafkademo.avro.schema.StockHistorynew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class AvroKafkaProducer {

    @Value("${avro.topic.name}")
    String topicname;

    @Autowired
    private KafkaTemplate<String, StockHistory1> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, StockHistorynew> kafkaTemplate2;

//    public void send(Customer customer){
//        ListenableFuture<SendResult<String,Customer>> future=  kafkaTemplate.send(topicname,String.valueOf(customer.getId()),customer);
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("Message failed to produce");
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Customer> result) {
//                System.out.println("Avro message successfully produced");
//            }
//        });
//
//    }


     public void send(StockHistory1 stockHistory){
         ListenableFuture<SendResult<String,StockHistory1>> future=  kafkaTemplate.send(topicname,String.valueOf(stockHistory.getTradeId()),stockHistory);
         future.addCallback(new ListenableFutureCallback<SendResult<String, StockHistory1>>() {
             @Override
             public void onFailure(Throwable ex) {
                 System.out.println("Message failed to produce");
             }

             @Override
             public void onSuccess(SendResult<String, StockHistory1> result) {
                 System.out.println("Avro message successfully produced");
             }
         });

     }

    public void send(StockHistorynew stockHistory){
        ListenableFuture<SendResult<String,StockHistorynew>> future=  kafkaTemplate2.send(topicname,String.valueOf(stockHistory.getTradeId()),stockHistory);
        future.addCallback(new ListenableFutureCallback<SendResult<String, StockHistorynew>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Message failed to produce");
            }

            @Override
            public void onSuccess(SendResult<String, StockHistorynew> result) {
                System.out.println("Avro message successfully produced");
            }
        });

    }
}
