package com.kata.bank.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "OPERATION")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OPERATION")
    private Long id;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "CODE_OPERATION")
    @Enumerated(EnumType.STRING)
    private CodeOperationEnum codeOperation;
    @Column(name = "DATE_OPERATION")
    private Date dateOperation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CodeOperationEnum getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(CodeOperationEnum codeOperation) {
        this.codeOperation = codeOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    @JsonIgnore
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
