package com.example.demo.services.repository.command.imple;

import com.example.demo.services.model.sql.TbTransaction;
import com.example.demo.services.repository.command.TransactionCommandRepository;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import static com.example.demo.services.model.sql.QTbTransaction.tbCustomerAccount;

@Repository
public class QDSLTbTransactionCommandRepository implements TransactionCommandRepository {

    @Autowired
    private SQLQueryFactory sqlQueryFactory;

    @Value("${spring.datasource.hikari.schema}")
    private String SCHEMA;


    @Override
    public TbTransaction insert(TbTransaction tbTransaction) {
        return sqlQueryFactory.insert(tbTransaction)
                .set(tbTransaction.id,
                        SQLExpressions.nextval(Long.class, SCHEMA.concat(tbTransaction.getFirstName())))
                .populate(tbTransaction)
                .executeWithKey(tbTransaction.id);
    }





}
