package com.pjatk.s25067Bank;

public class Client {
    private final String name;
    private final String surname;
    private double saldo;
    private final String id;

    public Client(String name, String surname, double saldo, String id) {
        this.name = name;
        this.surname = surname;
        this.saldo = saldo;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", saldo=" + saldo +
                ", id='" + id + '\'' +
                '}';
    }
}
