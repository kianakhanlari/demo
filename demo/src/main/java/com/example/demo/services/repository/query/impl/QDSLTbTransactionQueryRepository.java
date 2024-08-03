package com.example.demo.services.repository.query.impl;

import com.example.demo.services.dto.TransactionLogDtoResponse;
import com.example.demo.services.repository.query.TransactionQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.example.demo.services.model.jpa.Transaction.transaction;
import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QDSLTbTransactionQueryRepository implements TransactionQueryRepository {

    private final JPAQueryFactory queryFactory;

    public List<TransactionLogDtoResponse> findAllByAccNo(BigDecimal accNo) {

        return queryFactory.selectFrom(transaction)
                .where(transaction.accNo.eq(accNo))
                .orderBy(transaction.id.desc())
                .fetch();
    }
}
