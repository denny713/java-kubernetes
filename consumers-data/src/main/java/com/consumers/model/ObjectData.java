package com.consumers.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="object_data")
public class ObjectData {

    @Id
    @Column(name="sequence")
    private int sequence;

    @Column(name="message_desc")
    private String messageDesc;

    @Column(name="price")
    private BigDecimal price;
}
