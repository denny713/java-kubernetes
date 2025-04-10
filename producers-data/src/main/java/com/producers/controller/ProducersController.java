package com.producers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producers.dto.ResultDto;
import com.producers.service.ProducersService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/produce")
@AllArgsConstructor
public class ProducersController {

    private final ProducersService producersService;

    @PostMapping
    public ResponseEntity<ResultDto> produceData() {
        return ResponseEntity.ok(producersService.produceData());
    }
}
