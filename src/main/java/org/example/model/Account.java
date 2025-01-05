package org.example.model;

public class Account {
    private int id;
    private int userId;
    private double balance;

    // Constructors
    public Account() {}

    public Account(int id, int userId, double balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}