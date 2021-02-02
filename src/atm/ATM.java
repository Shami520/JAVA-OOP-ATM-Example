
package atm;

import java.util.Scanner;

public class ATM {
    
Scanner scan = new Scanner(System.in);
    
public void deposit(User user, long balance){
    user.setBalance(user.getBalance()+balance);
}

public void withdraw(User user, long balance){
    if (user.getBalance()>=balance){
        user.setBalance(user.getBalance() - balance);
    }
    else{
        System.out.println("Sorry account balance is not sufficient...!");
    }
}

public long checkBalance(User user){
    return user.getBalance();
}

public void changePin(User user){
    
    System.out.print("Enter Current PIN:");
    int oldPin = scan.nextInt();
    
    if(oldPin != user.getAtmPin()){
        System.out.println("Wrong PIN..."); 
        return;
    }
    
    System.out.print("Enter New PIN:");
    int newPin = scan.nextInt();
    
    System.out.print("Confirm New PIN:");
    int cPin = scan.nextInt();
    
    if(newPin!=cPin){
        System.out.println("New PIN Not Match...");
        return;
    }
    
    user.setAtmPin(newPin);
    
}

}


