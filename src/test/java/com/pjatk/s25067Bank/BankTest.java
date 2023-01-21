package com.pjatk.s25067Bank;

import com.pjatk.s25067Bank.ClientStorage;
import com.pjatk.s25067Bank.TransactionInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setup() {
        ClientStorage clientStorage = new ClientStorage();
        Bank Bank = new Bank(clientStorage);
    }

     @Test
    void successCashTransfer() {
         //when
         TransactionInfo testTransfer = bank.cashTransferOrder(
                 "1", 200
         );
         //then
         assertThat(testTransfer).hasToString("TransactionInfo{transactionStatus=ACCEPTED, newSaldo=20200.0})");
     }

     @Test
    void clientDoesntExist() {
        //when
         TransactionInfo testTransfer = bank.cashTransferOrder(
                 "8", 200
         );
         //then
         assertThat(testTransfer).isNull();
     }

     @Test
    void tooLessMoneyOnBankAccount() {
        //when
         TransactionInfo testTransfer = bank.cashTransferOrder(
                 "1", 30000
         );
         //then
         assertThat(testTransfer).isNull();
     }

     @Test
     void successMoneyPayment() {
         //when
         TransactionInfo testTransfer = bank.moneyPayment(
                 "1", 200
         );
         //then
         assertThat(testTransfer).hasToString("TransactionInfo{transactionStatus=ACCEPTED, newSaldo=20200.0})");

     }

    @Test
    void wrongClientId() {
        //when
        TransactionInfo testTransfer = bank.moneyPayment(
                "1", 200
        );
        //then
        assertThat(testTransfer).isNull();
    }
}
