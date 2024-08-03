package com.example.demo.services.repository.command.imple;

import com.example.demo.services.model.sql.TbCustomerAccount;
import com.example.demo.services.repository.command.CustomerAccountCommandRepository;
import com.querydsl.sql.SQLQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import static com.example.demo.services.model.sql.QTbCustomerAccount.tbCustomerAccount;

@Repository
public class QDSLCustomerAccountCommandRepository implements CustomerAccountCommandRepository {

    @Autowired
    private SQLQueryFactory sqlQueryFactory;

    @Value("${spring.datasource.hikari.schema}")
    private String SCHEMA;

    @Override
    public TbCustomerAccount insert(TbCustomerAccount tbCustomerAccount) {
       return sqlQueryFactory.insert(tbCustomerAccount)
               .set(tbCustomerAccount.id,
                       SQLExpressions.nextval(Long.class, SCHEMA.concat(tbCustomerAccount.getFirstName())))
               .populate(tbCustomerAccount)
               .executeWithKey(tbCustomerAccount.id);
    }

    @Override
    public TbCustomerAccount update(TbCustomerAccount tbCustomerAccount) {
        return sqlQueryFactory.update(tbCustomerAccount)
                .set(tbCustomerAccount.id,
                        SQLExpressions.nextval(Long.class, SCHEMA.concat(tbCustomerAccount.getFirstName())))
                .populate(tbCustomerAccount)
                .execute;
    }

}
