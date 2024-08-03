package com.example.demo.services.model.sql;

import com.example.demo.services.model.jpa.CustomerAccount;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TbTransaction {

    private Long id;
    private CustomerAccount customerAccountId;
    private BigDecimal debitAmount;
    private BigDecimal accNo;
    private Date date;

}
