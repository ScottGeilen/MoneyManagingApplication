import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class BankBalances {
    public static void main(String[] args) {
        menu();        
    }
    public static void menu() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            try {
                Date today = Calendar.getInstance().getTime();
                System.out.println("\n\nToday is " + today);
                System.out.println("WELCOME TO SCOTTBANK");
                System.out.println("1 - Test purchases you want to make");
                System.out.println("2 - Test purchases from calculated paycheck");
                System.out.println("3 - Exit");
                Integer menu = scan.nextInt();

                switch (menu) {
                    case 1:
                        checkPurchase();
                        break;
                    case 2:
                        checkPaycheckPurchases();
                        break;
                    case 3:
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
    private static Double checkPurchase() {
        Scanner scan = new Scanner(System.in);
        double startAmount = 0.00;
        try {
            double sum = 0;
            System.out.print("\nHow much is in your checking account? $");
            startAmount = scan.nextDouble(); // stores user input to double startChecking
            System.out.println("Your starting amount is $" + currencyFormat(startAmount));
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
            double subTotal = startAmount - sum;
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
    private static String checkPaycheckPurchases() {
        Scanner scan = new Scanner(System.in);
        try {
            String payFormatted = "";
            System.out.print("Weekly (1), or bi-weekly (2)? ");
            int payResponse = scan.nextInt();

            System.out.print("\nHow much is in your checking account? $");
            startAmount = scan.nextDouble(); // stores user input to double startChecking
                        System.out.println("Your starting amount is $" + currencyFormat(startAmount));

            System.out.print("Hourly wage: $");
            double wage = scan.nextDouble();

            System.out.print("First week hours: ");
            double hours = scan.nextDouble();
            
            double taxes = 0.165;
            double irs = taxes * wage;
            double taxedWage = wage - irs;
            double toSavings = 100.00;

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
                    double startAmount = 0.00;
                    try {
                        double sum = 0;
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
                        double subTotal = startAmount - sum;
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
    private static String currencyFormat(Double num) {
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