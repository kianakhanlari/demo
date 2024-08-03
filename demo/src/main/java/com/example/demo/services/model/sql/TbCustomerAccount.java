package com.example.demo.services.model.sql;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TbCustomerAccount {

    private Long id;
    private BigDecimal accNo;
    private String firstName;
    private String lastName;
    private Long identifierNo;
    private BigDecimal initialAmount;
    private BigDecimal debitAmount;
    private Short statusCode;

}
