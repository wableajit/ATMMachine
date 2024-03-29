package com.ajit;

import java.util.Scanner;

//BankAccount class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     balance = initialBalance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true;
     } else {
         return false;
     }
 }

 public double checkBalance() {
     return balance;
 }
}

//ATM class to represent the ATM machine
public class ATM {
 private BankAccount bankAccount;

 public ATM(BankAccount account) {
     bankAccount = account;
 }

 // Method to withdraw money from the account
 public void withdraw(double amount) {
     if (bankAccount.withdraw(amount)) {
         System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.checkBalance());
     } else {
         System.out.println("Insufficient funds. Withdrawal failed.");
     }
 }

 // Method to deposit money into the account
 public void deposit(double amount) {
     bankAccount.deposit(amount);
     System.out.println("Deposit successful. New balance: " + bankAccount.checkBalance());
 }

 // Method to check the balance of the account
 public void checkBalance() {
     System.out.println("Your current balance is: " + bankAccount.checkBalance());
 }

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     BankAccount userAccount = new BankAccount(1000); // Example initial balance of 1000
     ATM atm = new ATM(userAccount);

     while (true) {
         System.out.println("\nATM Menu:");
         System.out.println("1. Withdraw");
         System.out.println("2. Deposit");
         System.out.println("3. Check Balance");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 atm.withdraw(withdrawAmount);
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 atm.deposit(depositAmount);
                 break;
             case 3:
                 atm.checkBalance();
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 System.exit(0);
             default:
                 System.out.println("Invalid option. Please choose a valid option.");
         }
     }
 }
}

