package com.kafkademo.springboot.kafka;


import com.kafkademo.avro.schema.StockHistory1;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AvroKafkaConsumer {

//    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
//    public void read(ConsumerRecord<String, StockHistory1> record){
//        String key=record.key();
//        StockHistory1 history=record.value();
//        System.out.println("Avro message received for key : "+key+ " value : "+history.toString());
//    }

}
