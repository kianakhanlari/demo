package com.example.demo.services.repository.command;

import com.example.demo.services.model.sql.TbCustomerAccount;
import com.example.demo.services.model.sql.TbTransaction;

public interface TransactionCommandRepository  {

    TbTransaction insert(TbTransaction tbTransaction);
}
