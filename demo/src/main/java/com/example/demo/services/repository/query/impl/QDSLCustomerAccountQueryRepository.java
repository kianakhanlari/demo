package com.example.demo.services.repository.query.impl;

import com.example.demo.services.dto.InformationAccDtoResponse;
import com.example.demo.services.repository.query.CustomerAccountQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.example.demo.services.model.jpa.CustomerAccount.customerAccount;
import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class QDSLCustomerAccountQueryRepository implements CustomerAccountQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public BigDecimal findByAccNo(BigDecimal accNo) {

        return queryFactory.selectFrom(customerAccount)
                .where(customerAccount.accNo.eq(accNo))
                .orderBy(customerAccount.id.desc())
                .fetch();
    }

    @Override
    public InformationAccDtoResponse finFormByAccNo(BigDecimal accNo) {
        return queryFactory.selectFrom(customerAccount)
                .where(customerAccount.accNo.eq(accNo))
                .orderBy(customerAccount.id.desc())
                .fetch();
    }

}