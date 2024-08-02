/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
*About the App
* This app has 2 classes. The main class, "ConsoleBankingApp" and the "Bank Account class"
* The main class is where the programme is excecuted, it has one method, the main method
* The second class has 4 methods and 1 parameterised constructor
* Deposit method, withdraw method, getPreviousTransaction method and showMenu method
* The consepts practiced in this app is: classes, object of class, constructors, if statements and the maths methods
* exception handling will be added as more updates are added to the App
*/
package console.banking.app;
import java.util.*;

/**
 *
 * @author Mbavhalelo
 */
public class ConsoleBankingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner input = new Scanner(System.in);
        //String name = input.toString();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println();
        System.out.println("Enter your account number"); // Do exception handling because if a person input insert soomething
        //that is not an integer it will throw an exception
        String accountNumber = input.nextLine();
        
        /* This is the update I made to ensure that I can input the name into the
        * object of my class, instead passing it before running the programme. So 
        * I created the object of the scanner class and allow the user to input 
        * a string and assign it to name and pass that name to the object of the 
        * class [This basically mean i'm passing this name to the BankAccount constructor]
        * The same explanation goes for the account number as well.
        */
        
        BankAccount account = new BankAccount(name,accountNumber);
        account.showMenu();
    }
}

class BankAccount{
    int bankBalance;
    int previousTransaction;
    String name;
    String accountNumber;
    
    BankAccount(String name, String accountNumber){
    this.name = name;
    this.accountNumber = accountNumber;
    }
    
    void deposit(int depositAmount){
        Scanner input = new Scanner(System.in);
        
        //You must include exception handling here, A person must only input numbers, else throw an exception
        
        if(depositAmount != 0){
            if(depositAmount > 50){
                bankBalance = bankBalance + depositAmount;
                previousTransaction = depositAmount;
            } else {
                System.out.println("Deposit amount must be more that R50");
            }
        }
    }
    
    void withdraw(int withdrawAmount){
        if(withdrawAmount<bankBalance){
            bankBalance = bankBalance - withdrawAmount;
            previousTransaction = -withdrawAmount;
        } else{
            System.out.println("Insufficient funds");
        }
        
    }
    
    void getPreviousTransaction(){
        if(previousTransaction>0){
            System.out.println("Deposited Amount: " + previousTransaction);
        } else if(previousTransaction<0){
            System.out.println("Withdrawed Amount: " + Math.abs(previousTransaction));
        } else{
            System.out.println("There was no transaction ");
        }
    }
    
    void showMenu(){
        char options = '\0';
        Scanner menuOption = new Scanner(System.in);
        System.out.println("Welcome " + name + ". Account Number: "+ accountNumber);
        System.out.println();
        System.out.println("A: Check balance");
        System.out.println("B: Deposit Money");
        System.out.println("C: Withdraw Money");
        System.out.println("D: Get previous transaction");
        System.out.println("E: Exit");
        System.out.println();
        
        do{
            System.out.println("Enter the option: ");
            options = menuOption.next().charAt(0); // you are inputing te character at index 0
            
            //A person cannot input anything other than numbers, else throw an exception
            
            switch (options){
                case 'A':
                    System.out.println("=================");
                    System.out.println("Balance " + bankBalance);
                    System.out.println("=====================================");
                    break;
                    
                case 'B':
                    System.out.println("================");
                    System.out.println("Enter the amount you want to deposit");
                    System.out.println("================");
                    int enterDepositAmount = menuOption.nextInt();
                    deposit(enterDepositAmount);
                    System.out.println();
                    System.out.println("=====================================");
                    break;
                    
                case 'C':
                    System.out.println("==============");
                    System.out.println("Enter the amout you want to withdraw");
                    System.out.println("==============");
                    int enterWithdrawAmount = menuOption.nextInt();
                    withdraw(enterWithdrawAmount);
                    System.out.println();
                    System.out.println("=====================================");
                    break;
                    
                case 'D':
                    System.out.println("=============");
                    System.out.println("Previous transactions");
                    System.out.println("=============");
                    getPreviousTransaction();
                    System.out.println();
                    System.out.println("=====================================");
                    break;
                
                case 'E':
                    System.out.println("=====================================");
                    break;
                    
                default: 
                    System.out.println("Invalid Option");   
            }
            
        } while(options != 'E');
    }
           
}
