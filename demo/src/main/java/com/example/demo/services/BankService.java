package com.example.demo.services;


import com.example.demo.services.dto.*;
import com.example.demo.services.model.sql.TbCustomerAccount;
import com.example.demo.services.model.sql.TbTransaction;
import com.example.demo.services.repository.command.CustomerAccountCommandRepository;
import com.example.demo.services.repository.command.TransactionCommandRepository;
import com.example.demo.services.repository.query.CustomerAccountQueryRepository;
import com.example.demo.services.repository.query.TransactionQueryRepository;
import com.example.demo.validations.Constants;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankService {


    private CustomerAccountQueryRepository customerAccountQueryRepository;
    private CustomerAccountCommandRepository customerAccountCommandRepository;
    private TransactionCommandRepository transactionCommandRepository;
    private TransactionQueryRepository transactionQueryRepository;
    

    //افتتاح حساب
    @Transactional
    public TbCustomerAccount creatAccount(CustomerAccountDtoRequest customerAccountRequest){

        TbCustomerAccount tbCustomerAccount = new TbCustomerAccount();
        tbCustomerAccount.setAccNo(null);
        tbCustomerAccount.setFirstName(customerAccountRequest.getFirstName());
        tbCustomerAccount.setLastName(customerAccountRequest.getLastName());
        tbCustomerAccount.setIdentifierNo(customerAccountRequest.getIdentifierNo());
        tbCustomerAccount.setInitialAmount(BigDecimal.valueOf(100000));
        tbCustomerAccount.setDebitAmount(BigDecimal.valueOf(100000));
        customerAccountCommandRepository.insert(tbCustomerAccount);
        
      return tbCustomerAccount;
    }

    //برداشت و واریز
    @Transactional
    public BigDecimal depositOrWithdraw(DepositAndWithDrawDtoRequest request) throws Exception {
        BigDecimal debitAmount;
        if (request.getCode().equals(Constants.Status.deposit.getCode())) {
            debitAmount = deposit(request);
        } else if (request.getCode().equals(Constants.Status.withdraw.getCode())) {
            debitAmount = withDraw(request);
        } else {
            throw new Exception();
        }
        return debitAmount;
    }

    //واریز
    @Transactional
    public BigDecimal deposit(DepositAndWithDrawDtoRequest depositDtoRequest){

        BigDecimal debitAmount;
        debitAmount =customerAccountQueryRepository.findByAccNo(depositDtoRequest.getAccNo());
        debitAmount.add(depositDtoRequest.getAmount());

        TbCustomerAccount tbCustomerAccount = new TbCustomerAccount();
        tbCustomerAccount.setAccNo(depositDtoRequest.getAccNo());
        tbCustomerAccount.setDebitAmount(debitAmount);
        customerAccountCommandRepository.update(tbCustomerAccount);

        TbTransaction tbTransaction =new TbTransaction();
        tbTransaction.setAccNo(depositDtoRequest.getAccNo());
        tbTransaction.setDebitAmount(debitAmount);
        tbTransaction.setDate(depositDtoRequest.getDate());
        transactionCommandRepository.insert(tbTransaction);

         return debitAmount;
    }
    
    //برداشت
    @Transactional
    public BigDecimal withDraw(DepositAndWithDrawDtoRequest depositAndWithDrawDtoRequest){

        BigDecimal debitAmount;
        debitAmount =customerAccountQueryRepository.findByAccNo(depositAndWithDrawDtoRequest.getAccNo());
        debitAmount.subtract(depositAndWithDrawDtoRequest.getAmount());
        TbCustomerAccount tbCustomerAccount = new TbCustomerAccount();
        tbCustomerAccount.setDebitAmount(debitAmount);
        customerAccountCommandRepository.update(tbCustomerAccount);

        TbTransaction tbTransaction =new TbTransaction();
        tbTransaction.setAccNo(depositAndWithDrawDtoRequest.getAccNo());
        tbTransaction.setDebitAmount(debitAmount);
        tbTransaction.setDate(depositAndWithDrawDtoRequest.getDate());
        transactionCommandRepository.insert(tbTransaction);

        return debitAmount;
    }
    //انتقال بین حساب
    @Transactional
    public TransferFundDtoResponse transferFund(TransferFundDtoRequest transferFundDtoRequest) {

        BigDecimal debitAmount;
        BigDecimal debitDepartureAmount;
        TransferFundDtoResponse transferFundDtoResponse=new TransferFundDtoResponse();

        debitAmount =customerAccountQueryRepository.findByAccNo(transferFundDtoRequest.getAccNo());
        debitAmount.subtract(transferFundDtoRequest.getAmount());

        TbCustomerAccount tbCustomerAccount = new TbCustomerAccount();
        tbCustomerAccount.setDebitAmount(debitAmount);
        customerAccountCommandRepository.update(tbCustomerAccount);

        TbTransaction tbTransaction =new TbTransaction();
        tbTransaction.setAccNo(transferFundDtoRequest.getAccNo());
        tbTransaction.setDebitAmount(debitAmount);
        tbTransaction.setDate(transferFundDtoRequest.getDate());
        transactionCommandRepository.insert(tbTransaction);

        debitDepartureAmount =customerAccountQueryRepository.findByAccNo(transferFundDtoRequest.getDepartureAccNO());
        debitDepartureAmount.add(transferFundDtoRequest.getAmount());

        TbCustomerAccount tbDepartureCustomerAccount = new TbCustomerAccount();
        tbDepartureCustomerAccount.setDebitAmount(debitDepartureAmount);
        customerAccountCommandRepository.update(tbDepartureCustomerAccount);

        transferFundDtoResponse.setAccNo(transferFundDtoRequest.getAccNo());
        transferFundDtoResponse.setDepartureAccNO(transferFundDtoRequest.getDepartureAccNO());
        transferFundDtoResponse.setAmount(transferFundDtoRequest.getAmount());
        transferFundDtoResponse.setDate(transferFundDtoRequest.getDate());
        transferFundDtoResponse.setDebitAmount(debitAmount);

        return transferFundDtoResponse;
    }

    //log transaction
    public List<TransactionLogDtoResponse> transactionLog(BigDecimal accNo) {

        List<TransactionLogDtoResponse> transactionLogDtoResponse;
        transactionLogDtoResponse = transactionQueryRepository.findAllByAccNo(accNo);

        return transactionLogDtoResponse;
    }

}
