package com.example.demo.services.model.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

@ToString
@Getter
@Setter
@Entity
@Table(name= "TB_TRANSACTION")
public class Transaction {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ACCOUNT_ID")
    private CustomerAccount customerAccount;

    @Column
    private BigDecimal debitAmount;

    @Column
    private BigDecimal accNo;

    @Column
    private Date date;
}
