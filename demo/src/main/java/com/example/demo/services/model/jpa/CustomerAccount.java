package com.example.demo.services.model.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
@Table(name= "TB_CUSTOMER_ACCOUNT")
public class CustomerAccount {

    @Id
    private Long Id;

    @Column
    private BigDecimal accNo;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Long identifierNo;

    @Column
    private BigDecimal initialAmount;

    @Column
    private BigDecimal debitAmount;

    @Column
    private Short statusCode;


    /*@Column
    private Date lastTransactionDate;

    @Column
    private Date date;

    @Column
    private String accountType;

    @Column
    private Short customerTypeCode;*/

}
