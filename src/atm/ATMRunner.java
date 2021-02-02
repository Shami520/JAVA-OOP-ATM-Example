package atm;

import java.util.Scanner;

public class ATMRunner {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int maxUsers = 1000;
        
        User[] users = new User[maxUsers];
        ATM atm = new ATM();
        
        boolean run = true;
        // looping menu:
        
        System.out.println("--------- Welcome to ATM ---------");
        
        while(run){
            System.out.println("\n\nPlease choose from menu:");
            
            System.out.println("1. Use ATM"
                                + "\n2. Cash Deposit at Bank"
                                + "\n3. Create Bank Account"
                                + "\n99. EXIT...");
            
            System.out.print("Enter Choice:");
            
            int option = scan.nextInt();
            
            switch(option){
                
                case 1:
                    useATM(users, atm);
                    break;
                case 2:
                    User user = findUser(users);
                    if(user!=null){
                        System.out.print("Enter balacnce to deposit: ");
                        long balance = scan.nextLong();
                        atm.deposit(user, balance);
                    }
                    break;
                case 3:
                    newUser(users);
                    break;
                case 99:
                    System.out.println("Thanks for using ATM...");
                    run=false;
                    break;
                default:
                    System.out.println("Wrong OPtion...");
                    break;
            }
        }
    }
    
    public static void useATM(User[] users, ATM atm){
        
        Scanner scan = new Scanner(System.in);
        
        User user = findUser(users);
        
        if (user==null)
            return;
        
        
        if(!user.authUser())
            return;
        
        System.out.println("Enter choice: ");
        System.out.println("1. Cash Withdrawl"
                            + "\n2. Check balance"
                            + "\n3. Change PIN");
        System.out.print("Enter choice: ");
        int option = scan.nextInt();
        
        switch(option){
            case 1:
                System.out.print("Enter amount to withdraw: ");
                long balance = scan.nextLong();
                atm.withdraw(user, balance);
                break;
            case 2:
                System.out.println("Your Balance is: Rs." +user.getBalance());
                break;
            case 3:
                atm.changePin(user);
                break;
            default:
                System.out.println("Wrong option!");
                
        }
        
    }
    
    public static User findUser(User[] users){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter account Number: ");
        int accNo = scan.nextInt();
        
        for (int i = 0; i < users.length; i++) {
            if(users[i]!=null && users[i].getAccountNo() == accNo){
                return users[i];
            }
        }
        
        System.out.println("\n\n--------User not found-------");
        
        return null;
    }
    
    
    public static User newUser(User[] users){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please create ATM PIN: ");
        int pin = scan.nextInt();
        
        System.out.print("Confirm PIN: ");
        int cPin = scan.nextInt();
        
        if(pin != cPin){
            System.out.println("PIN doesn't match..");
            return null;
        }
        
        System.out.print("Please Enter Your Name: ");
        String name = scan.next();
        
        System.out.print("Enter Initial balance: ");
        long balance = scan.nextLong();
        
        if(balance<0)
            balance = balance * -1;
        
        User newUser =  new User(name, cPin, balance);
        users[User.totalAccounts] = newUser;
        
        System.out.println("\n\n Thanks for using ATM, Your acount number is: "+newUser.getAccountNo());
        
        return newUser;
    }
    
}
