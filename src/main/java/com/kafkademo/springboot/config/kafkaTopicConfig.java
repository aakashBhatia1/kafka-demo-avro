package com.kafkademo.springboot.config;

import com.kafkademo.avro.schema.StockHistory1;
import com.kafkademo.avro.schema.StockHistorynew;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class kafkaTopicConfig {

    @Bean
    public NewTopic kafkaDemoTopic()
    {
        return TopicBuilder.name("demoTopic2")
                .build();
    }

    @Bean
    public NewTopic kafkaJsonDemoTopic()
    {
        return TopicBuilder.name("JsonDemoTopic")
                .build();
    }

    @Bean
    public ConsumerFactory<String, StockHistory1> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StockHistory1>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, StockHistory1> factory = new ConcurrentKafkaListenerContainerFactory<String, StockHistory1>();
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }

    @Bean
    public ConsumerFactory<String, StockHistorynew> consumerFactory2(KafkaProperties kafkaProperties2) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties2.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, StockHistorynew>> kafkaListenerContainerFactory2(KafkaProperties kafkaProperties2) {
        ConcurrentKafkaListenerContainerFactory<String, StockHistorynew> factory2 = new ConcurrentKafkaListenerContainerFactory<String, StockHistorynew>();
        factory2.setConsumerFactory(consumerFactory2(kafkaProperties2));
        return factory2;
    }
}
