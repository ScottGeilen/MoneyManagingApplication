import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class MoneyManager {
    public static void main(String[] args) {
        menu();
    }
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        Tax tax = new Tax();
        Wage wage = new Wage();
        Compensation employee = new Compensation();
        Paycheck paycheck = new Paycheck();
        Budget budget = new Budget();
        double hourlyWage;
        double salary;

        while (!exit) {
            int key;
            try {
                Date today = Calendar.getInstance().getTime();
                System.out.println("\n\nToday is " + today);
                System.out.println("WELCOME TO SCOTTBANK");
                System.out.println("1 - Calculate paycheck");
                System.out.println("2 - Input spending from calculated paycheck");
                System.out.println("3 - Input spending from start amount");
                System.out.println("4 - Collect budget percentages");
                System.out.println("10 - Exit");
                int menu = scan.nextInt();
                switch (menu) {
                    case 1:
                        paycheck.calculatePaycheck();
                        break;
                    case 2:
                        paycheck.calculatePaycheckPurchases();
                        break;
                    case 3:
                        paycheck.addSpending();
                        break;
                    case 4:
                        budget.collectBudget();
                        break;
                    case 10:
                        if (scan != null)
                            scan.close();
                        exit = true;
                        break;
                }
            } finally {
                System.out.println("");
            }
        }
    }   
    protected String currencyFormat(Double num) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        String newestFormatted = df.format(num);
        return newestFormatted;
    }
    
    /*
    
    TO-DO LIST
    1. 
        Your bi-weekly paycheck is $230.76.

        Enter amount in your checking account: $939

        You will have $1169.76 in your checking account when your paycheck arrives

        ***Tip: Exit by '.123'.
        How much is your purchase? $200

        You will spend $200.00.
        You will have a remaining balance of $969.76.
    */
}