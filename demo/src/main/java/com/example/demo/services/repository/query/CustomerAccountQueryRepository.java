package com.example.demo.services.repository.query;

import com.example.demo.services.dto.CustomerAccountDtoResponse;
import com.example.demo.services.dto.InformationAccDtoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerAccountQueryRepository {

    BigDecimal findByAccNo(BigDecimal accNo);

    InformationAccDtoResponse finFormByAccNo(BigDecimal accNo);



}
