package com.company;


import java.util.Random;

public class Customer  extends  Thread{
    private String name;
    private Account account;
    private final int[] VALUES = {10,20,50,100};
    public Customer(Account account){
        this.account = account;
    }
    @Override
    public void run(){
        while(true){
            execute();
            this.yield(); // ou this.sleep(2000); 2 segundos
        }
    }

    public void execute(){
        //Sorteia um valor entre {0 e 1}
        Random random = new Random();
        if(random.nextBoolean()){
            // Fazer depósito
            int i = random.nextInt(VALUES.length);
            this.account.deposit(VALUES[i]);
        }else{
            //Fazer saque
            int i = random.nextInt(VALUES.length);
            this.account.withdraw(VALUES[i]);
        }
    }
}