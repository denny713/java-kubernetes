package com.consumers.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectDataDto {
    
    private int sequence;
    private String messageDesc;
    private BigDecimal price;
}
