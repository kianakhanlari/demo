package com.example.demo.services.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerAccountDtoResponse {

    private Long Id;
    private BigDecimal accNo;
    private String firstName;
    private String lastName;
    private Long identifierNo;
    private BigDecimal initialAmount;
    private BigDecimal debitAmount;

}
