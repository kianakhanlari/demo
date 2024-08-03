package com.example.demo.services.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionLogDtoResponse {

    private Date date;
    private BigDecimal accNo;
    private BigDecimal debitAmount;
}
