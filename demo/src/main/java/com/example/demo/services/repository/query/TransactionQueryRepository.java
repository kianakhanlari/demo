package com.example.demo.services.repository.query;

import com.example.demo.services.dto.TransactionLogDtoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionQueryRepository  {

    List<TransactionLogDtoResponse> findAllByAccNo(BigDecimal accNo);

}
