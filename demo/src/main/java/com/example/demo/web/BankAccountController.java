package com.example.demo.web;

import com.example.demo.services.BankAccountService;
import com.example.demo.services.dto.InformationAccDtoResponse;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;

@Controller
@RequestMapping("account")
public class BankAccountController {

    private BankAccountService bankAccountService;


    @GetMapping("/information/bank")
    public InformationAccDtoResponse bankAccount(@RequestParam BigDecimal accNo) throws ParseException {

        return bankAccountService.informationAcc(accNo);
    }
}