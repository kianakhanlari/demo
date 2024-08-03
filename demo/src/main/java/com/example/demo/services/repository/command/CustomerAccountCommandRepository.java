package com.example.demo.services.repository.command;

import com.example.demo.services.model.sql.TbCustomerAccount;

public interface CustomerAccountCommandRepository {

    TbCustomerAccount insert(TbCustomerAccount tbCustomerAccount);

    TbCustomerAccount update(TbCustomerAccount tbCustomerAccount);

}
