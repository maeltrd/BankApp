package com.bankapp;

public class Account {

    private int id;
    private String account_name;
    private float amount;
    private String iban;
    private String currency;

    //GETTERS --------------------------------------------------------------------------------------
    public int getId() { return id; }
    public String getName() { return account_name; }
    public float getAmount() { return amount; }
    public String getIban() { return iban; }
    public String getCurrency() { return currency; }

    //SETTERS --------------------------------------------------------------------------------------
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.account_name = name; }
    public void setAmount(float amount) { this.amount = amount; }
    public void setIban(String iban) { this.iban = iban; }
    public void setCurrency(String currency) { this.currency = currency; }

    //CONSTRUCTOR ----------------------------------------------------------------------------------
    public Account(int id, String account_name, float amount, String iban, String currency) {
        this.id = id;
        this.account_name = account_name;
        this.amount = amount;
        this.iban = iban;
        this.currency = currency;
    }
}
