package com.example.demo.web;

import com.example.demo.services.BankService;
import com.example.demo.services.dto.*;
import com.example.demo.services.model.sql.TbCustomerAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
@RestController("bank")
public class BankController {

    private BankService bankService;

    @PostMapping("/creataccount/bankaccount")
    public TbCustomerAccount creatAccount(@RequestBody CustomerAccountDtoRequest customerAccountRequest) {

        return bankService.creatAccount(customerAccountRequest);
    }

    @PutMapping("/withdraw/deposit")
    public BigDecimal depositOrWithdraw(@RequestBody DepositAndWithDrawDtoRequest request) throws Exception {

        return bankService.depositOrWithdraw(request);
    }

    @PutMapping("/transfer/fund")
    public TransferFundDtoResponse transferFund(@RequestBody TransferFundDtoRequest transferFundDtoRequest) {

        return bankService.transferFund(transferFundDtoRequest);
    }

    @PostMapping("/transaction/log")
    public List<TransactionLogDtoResponse> transactionLog(BigDecimal accNo){

        return bankService.transactionLog(accNo);
    }

}
