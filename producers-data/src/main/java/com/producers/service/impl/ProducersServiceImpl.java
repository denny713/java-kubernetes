package com.producers.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.producers.dto.ObjectDataDto;
import com.producers.dto.ResultDto;
import com.producers.service.ProducersService;
import com.producers.util.KafkaUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducersServiceImpl implements ProducersService {

    private final KafkaUtil kafkaUtil;

    @Override
    public ResultDto produceData() {
        try {
            List<ObjectDataDto> listData = generateListData();
            listData.forEach(
                    x -> kafkaUtil.sendMessage("topic-test", UUID.randomUUID().toString(), new Gson().toJson(x)));

            return new ResultDto(200, "Success Send Data", listData);
        } catch (Exception e) {
            return new ResultDto(500, "Error", e.getMessage());
        }
    }

    private List<ObjectDataDto> generateListData() {
        List<ObjectDataDto> listData = new ArrayList<>();
        for (int x = 11; x <= 20; x++) {
            listData.add(new ObjectDataDto(x, String.format("Product %s", x), new BigDecimal(1000)));
        }

        return listData;
    }
}
