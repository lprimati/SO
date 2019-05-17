package com.company;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition accountNotEmpty = lock.newCondition();


    private Integer balance;

    public void deposit(Integer value){
        this.balance += value;

    }
    public void withdraw(Integer value){
        if (value < balance){
            Integer novoBalance = this.balance -value;
            this.balance = novoBalance;
        }
        else{
            System.out.println("não tem dinheiro suficiente para sacar!");

        }

    }
}
