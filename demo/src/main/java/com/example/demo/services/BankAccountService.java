package com.example.demo.services;

import com.example.demo.services.dto.InformationAccDtoResponse;
import com.example.demo.services.repository.query.CustomerAccountQueryRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankAccountService {

    private CustomerAccountQueryRepository customerAccountQueryRepository;


    public InformationAccDtoResponse informationAcc(BigDecimal accNo ) {

        InformationAccDtoResponse informationAccDtoResponse
                = customerAccountQueryRepository.finFormByAccNo(accNo);
        return informationAccDtoResponse;
    }




}
