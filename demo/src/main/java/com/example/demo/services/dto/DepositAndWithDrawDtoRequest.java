package com.example.demo.services.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DepositAndWithDrawDtoRequest {

    private BigDecimal accNo;
    private BigDecimal Amount;
    private Date date;
    private Byte code;

}
