package com.pjatk.s25067Bank;

import java.time.LocalDate;

public class TransactionInfo {

    private final TransactionStatus transactionStatus;
    private final double newSaldo;

    public TransactionInfo(TransactionStatus transactionStatus, double newSaldo) {
        this.transactionStatus = transactionStatus;
        this.newSaldo = newSaldo;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "transactionStatus=" + transactionStatus +
                ", newSaldo=" + newSaldo +
                '}';
    }
}
