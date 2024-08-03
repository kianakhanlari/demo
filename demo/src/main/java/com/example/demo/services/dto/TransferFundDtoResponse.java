package com.example.demo.services.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class TransferFundDtoResponse {

    private BigDecimal accNo;
    private BigDecimal departureAccNO;
    private BigDecimal amount;
    private BigDecimal debitAmount;
    private Date date;
}
