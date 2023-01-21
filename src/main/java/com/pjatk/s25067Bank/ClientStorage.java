package com.pjatk.s25067Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {

    private final List<Client> clientsList = new ArrayList<>();

    public ClientStorage() {
        clientsList.add(new Client("Jan","Kowalski",20000, "1"));
        clientsList.add(new Client("Artur","Nowak",1000, "2"));
        clientsList.add(new Client("Anna","Jankowska",50000, "3"));
    }

    public Optional<Client> findClientById(String id) {
        return getClientsList().stream()
                .filter(storage -> storage.getId().equals(id))
                .findFirst();
    }


    public List<Client> getClientsList() {
        return clientsList;
    }
}
