package com.pjatk.s25067Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BankIntegrationTest {
    @Autowired
    private Bank bank;

    @MockBean
    private ClientStorage clientStorage;

    @Test
    public void successCashTransfer() {
        //given
        when(clientStorage.findClientById(any())).thenReturn(Optional.of(new Client("Jan","Kowalski", 20000, "1")));

        //when
        TransactionInfo testTransfer = bank.cashTransferOrder(
                "1", 200
        );
        //then
        assertThat(testTransfer).hasToString("TransactionInfo{transactionStatus=ACCEPTED, newSaldo=20200.0})");

    }

    @Test
    public void clientDoesntExist() {
        //given
        when(clientStorage.findClientById(any())).thenReturn(Optional.of(new Client("Jan","Kowalski", 20000, "1")));

        //when
        TransactionInfo testTransfer = bank.cashTransferOrder(
                "8", 200
        );
        //then
        assertThat(testTransfer).isNull();
    }

    @Test
    void tooLessMoneyOnBankAccount() {
        //given
        when(clientStorage.findClientById(any())).thenReturn(Optional.of(new Client("Jan","Kowalski", 20000, "1")));

        //when
        TransactionInfo testTransfer = bank.cashTransferOrder(
                "1", 30000
        );
        //then
        assertThat(testTransfer).isNull();
    }

    @Test
    void successMoneyPayment() {
        //given
        when(clientStorage.findClientById(any())).thenReturn(Optional.of(new Client("Jan","Kowalski", 20000, "1")));

        //when
        TransactionInfo testTransfer = bank.moneyPayment(
                "1", 200
        );
        //then
        assertThat(testTransfer).hasToString("TransactionInfo{transactionStatus=ACCEPTED, newSaldo=20200.0})");

    }

}