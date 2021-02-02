package atm;

import java.util.Scanner;

public class User {
    
    private String name;
    private int accountNo;
    private int atmPin;
    private long balance;
    
    public static int totalAccounts;
    
    Scanner scan = new Scanner(System.in);

    public User(String name,int atmPin, long balance) {
        this.name = name;
        this.atmPin = atmPin;
        this.balance = balance;
        
        this.accountNo = ++totalAccounts;
        
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAtmPin(int atmPin) {
        this.atmPin = atmPin;
    }

    public int getAtmPin() {
        return atmPin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        if(balance<0)
            balance = balance * -1;
        this.balance = balance;
    } 
    
    public boolean authUser(){
        
        System.out.print("Enter your PIN: ");
        int pin = scan.nextInt();
        
        if(pin==atmPin)
            return true;
        else{
            System.out.println("Sorry Invalid PIN...");
            return false;
        }
        
    }
    
}
