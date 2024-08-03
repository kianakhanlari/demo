package com.example.demo.services.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
@Data
public class TransferFundDtoRequest {
        private BigDecimal accNo;
        private BigDecimal departureAccNO;
        private BigDecimal amount;
        private Date date;
}
