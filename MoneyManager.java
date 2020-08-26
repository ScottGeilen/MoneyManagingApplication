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

        while (!exit) {
            int key;
            Compensation employee = new Compensation();
            Paycheck paycheck = new Paycheck();
            try {
                Date today = Calendar.getInstance().getTime();
                System.out.println("\n\nToday is " + today);
                System.out.println("WELCOME TO SCOTTBANK");
                System.out.println("1 - *getTotalHours");
                System.out.println("2 - *Calculate paycheck");
                System.out.println("3 - setSalaryPaycheck");
                System.out.println("4 - checkPaycheckPurchases");
                System.out.println("5 - checkPurchase");
                System.out.println("6 - setSalaryPaycheck");
                System.out.println("7 - setHourlyPaycheck");
                System.out.println("8 - CalculateIncomeTaxHourly");
                System.out.println("9 - Exit");
                int menu = scan.nextInt();
                switch (menu) {
                    case 1:
                        employee.getTotalHours();
                        break;
                    case 2:
                        paycheck.calculatePaycheck();
                        break;
                    case 3:
                        paycheck.setSalaryPaycheck();
                        break;
                    case 4:
                        checkPaycheckPurchases();
                        break;
                    case 5:
                        checkPurchase();
                        break;
                    case 6:
                        paycheck.setSalaryPaycheck();
                        break;
                    case 7:
                        paycheck.setHourlyPaycheck();
                        break;
                    case 8:
                        key = tax.getFilingStatus();
                        tax.CalculateIncomeTaxHourly(key);
                        break;
                        //         case 5:
                        //             checkPurchase();
                        //             break;
                    case 9:
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
    
    protected static Double startAmount() {
        Scanner scan = new Scanner(System.in);
        double startingAmount = 0.00;
        System.out.print("\nEnter starting amount: $");
        startingAmount = scan.nextDouble(); // stores user input to double startChecking
        System.out.println("Your starting amount is $" + currencyFormat(startingAmount));
        try {
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("JSON write successful!");
        }
        return startingAmount;
    }
    protected static Double checkPurchase() {
        Scanner scan = new Scanner(System.in);
        try {
            double sum = 0;
            // startAmount();
            double startingAmount = 0.00;
            System.out.print("\nEnter starting amount: $");
            startingAmount = scan.nextDouble(); // stores user input to double startChecking
            System.out.println("Your starting amount is $" + currencyFormat(startingAmount));
            System.out.println("\n***Tip: Exit by '.000'.");
            // sleep
            try { TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.println("No sleep");}

            ArrayList<Double> spendAmount = new ArrayList<Double>();
            boolean exit = false;
            while (!exit) { // repeats
                System.out.print("How much is your purchase? $");
                Double currPur = scan.nextDouble();
                if (currPur.equals(.000)) {
                    exit = true;
                }
                spendAmount.add(currPur);
            }
            for (Double purchases : spendAmount) {
                sum += purchases;
            }
            // subtract sum from checking
            //double initialAmount = startingAmount.startAmount();
            double subTotal = startingAmount - sum;
            System.out.println("\nYou will spend $" + currencyFormat(sum));
            // sleep
            try { TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.println("No sleep");}

            System.out.println("You will have a remaining balance of $" + currencyFormat(subTotal));
            // sleep
            try { TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e){
                System.out.println("No sleep");}
            return sum;
        }
        finally {
            System.out.print("");
        }
    }
    protected static String checkPaycheckPurchases() {
        Scanner scan = new Scanner(System.in);
        try {
            double sum = 0;
            double startingAmount = 0.00;
            System.out.print("\nEnter starting amount: $");
            startingAmount = scan.nextDouble(); // stores user input to double startChecking
            System.out.println("Your starting amount is $" + currencyFormat(startingAmount));

            String payFormatted = "";
            System.out.print("Weekly (1), or bi-weekly (2)? ");
            int payResponse = scan.nextInt();
            System.out.print("Hourly wage: $");
            double wage = scan.nextDouble();
            System.out.print("How much to put away for savings? ");
            double toSavings = scan.nextDouble();
            System.out.print("First week hours: ");
            double hours = scan.nextDouble();
            double taxes = 0.165;
            double irs = taxes * wage;
            double taxedWage = wage - irs;

            switch (payResponse) {
                case 1:
                    double weeklyPay = hours * taxedWage - toSavings;
                    System.out.println("\nYour weekly paycheck is $" + currencyFormat(weeklyPay));
                    checkPurchase();
                    break;
                case 2:
                    System.out.print("Second week hours: ");
                    double secondHours = scan.nextDouble();
                    double biweeklyhours = hours + secondHours;
                    double biWeeklyPay = biweeklyhours * taxedWage - toSavings;
                    System.out.println("\nYour bi-weekly paycheck is $" + currencyFormat(biWeeklyPay));
                    double newTotal = biWeeklyPay + startingAmount;
                    System.out.println("You started with $" + currencyFormat(startingAmount) + ". When you get your paycheck, \nyou'll have $" + currencyFormat(newTotal) + " in the bank when your paycheck arrives.");
                    
                    System.out.println("\n***Tip: Exit by '.000'.");
                    // sleep
                    try { TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e){
                        System.out.println("No sleep");}

                    ArrayList<Double> spendAmount = new ArrayList<Double>();
                    boolean exit = false;
                    while (!exit) { // repeats
                        System.out.print("How much is your purchase? $");
                        Double currPur = scan.nextDouble();
                        if (currPur.equals(.000)) {
                            exit = true;
                        }
                        spendAmount.add(currPur);
                    }
                    for (Double purchases : spendAmount) {
                        sum += purchases;
                    }
                    // subtract sum from checking
                    //double initialAmount = startingAmount.startAmount();
                    double subTotal = newTotal - sum;
                    System.out.println("\nYou will spend $" + currencyFormat(sum));
                    // sleep
                    try { TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e){
                        System.out.println("No sleep");}

                    System.out.println("You will have a remaining balance of $" + currencyFormat(subTotal));
                    // sleep
                    try { TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e){
                        System.out.println("No sleep");}
                    break;
                default:
                    System.out.println("You did not select 1 or 2.");
                    break;
            }
            return payFormatted;
        } finally {
            System.out.print("");
        }
    }
    protected static String currencyFormat(Double num) {
        DecimalFormat df = new DecimalFormat("#.00");
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