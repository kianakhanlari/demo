package com.example.demo.services.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class InformationAccDtoResponse {

    private String firstName;

    private String lastName;

    private Long identifierNo;

    private BigDecimal initialAmount;

    private BigDecimal debitAmount;

    }
