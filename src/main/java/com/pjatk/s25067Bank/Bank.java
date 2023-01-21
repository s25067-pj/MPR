package com.pjatk.s25067Bank;

import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.pjatk.s25067Bank.TransactionStatus.ACCEPTED;
import static com.pjatk.s25067Bank.TransactionStatus.DECLINED;

@Component
public class Bank {
    private final ClientStorage clientStorage;

    public Bank(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }

    public void addNewClient(Client client) {
        clientStorage.getClientsList().add(client);
        System.out.println("New client is added: " + client);
    }

    public TransactionInfo cashTransferOrder (String id, double money) {
        double newSaldo =0;

        Optional <Client> client = clientStorage.findClientById(id);
        double currentSaldo = client.get().getSaldo();
        if(client.isEmpty()) {
            System.out.println("No client with such ID");
            return null;
        }

        if(client.isPresent()) {
            newSaldo = currentSaldo + money;

            if (newSaldo >= 0) {
                client.get().setSaldo(newSaldo);
                return new TransactionInfo(TransactionStatus.ACCEPTED, newSaldo);
            } else return null;
        }

        return null;
    }

    public TransactionInfo moneyPayment (String id, double money) {
        double newSaldo =0;
        Optional <Client> client = clientStorage.findClientById(id);
        double currentSaldo = client.get().getSaldo();
        if(client.isEmpty()) {
            System.out.println("No client with such ID");
            return null;
        }
        if(client.isPresent()) {
            newSaldo = currentSaldo + money;
            client.get().setSaldo(newSaldo);
            return new TransactionInfo(TransactionStatus.ACCEPTED, newSaldo);
        } return null;
    }
}
