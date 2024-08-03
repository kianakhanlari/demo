package com.example.demo.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerAccountDtoRequest {

    private String firstName;
    private String lastName;
    private Long identifierNo;
    private BigDecimal initialAmount;

}
