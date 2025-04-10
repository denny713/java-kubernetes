package com.consumers.listener;

import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

import com.consumers.dto.ObjectDataDto;
import com.consumers.dto.ResultDto;
import com.consumers.service.ObjectDataService;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataListener {

    private final ObjectDataService objectDataService;

    @KafkaListener(topicPartitions = {@TopicPartition(topic = "topic-test", partitions = {"0"})}, groupId = "my-consumer-group")
    public void listenData(@Payload String message, Acknowledgment acknowledgment) {
        try {
            ObjectDataDto dto = new Gson().fromJson(message, ObjectDataDto.class);
            ResultDto result = objectDataService.saveObjectData(dto);

            if (result.getCode() != 201) {
                log.error("Failed to save data");
            } else {
                acknowledgment.acknowledge();
            }
        } catch (Exception w) {
            log.error("Failed : {}", w.getMessage());
        }
    }
}
