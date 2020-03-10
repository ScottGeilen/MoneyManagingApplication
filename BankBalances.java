import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Hashtable;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.time.*;
import java.time.temporal.TemporalAdjusters;

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
                System.out.println("Today: " + today);
                System.out.println("WELCOME TO SCOTTBANK");
                System.out.println("1 - Initialize Checking");
                System.out.println("2 - Add purchase");
                System.out.println("3 - Calculate a paycheck");
                System.out.println("4 - Exit");
                Integer menu = scan.nextInt();

                switch (menu) {
                    case 1:
                        InitalizeChecking();
                        break;
                    case 2:
                        addPurchase();
                        break;
                    case 3:
                        calculatePaycheck();
                        break;
                    case 4:
                        exit = true;
                        if (scan != null)
                            scan.close();
                        break;
                    case 5:
                        getPrevFriday();
                        break;
                    case 6:
                        getNextFriday();
                        break;
                    case 7:
                        paycheckWeek();
                        break;
                }
            } finally {
                System.out.println("");
            }
        }
    }

    public static double InitalizeChecking() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Enter amount in Checking: ");
            double startChecking = scan.nextInt(); // stores user input to double startChecking

            System.out.println("Your starting checking amount is $" + startChecking);
            return startChecking;
        } finally {
            System.out.print("");
        }
    }

    private static Double addPurchase() {
        ArrayList<Double> spendAmount = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        try {
            double sum = 0;
            System.out.print("How many purchases would you like to add? ");
            int NoOfPurchases = scan.nextInt();
            /*
             * done = false; while (done == false){
             * System.out.print("How much was your purchase? "); Double currPur =
             * scan.nextDouble(); if (currPur == done) done = true; }
             */
            for (int i = 0; i < NoOfPurchases; i++) {
                System.out.print("How much was your purchase? ");
                Double currPur = scan.nextDouble();
                spendAmount.add(currPur);
            }
            for (Double purchases : spendAmount) {
                sum += purchases;
            }

            // subtract sum from checking
            double currBal = InitalizeChecking() - sum;
            System.out.println("You just spent $" + sum);
            System.out.println("Current Checking balance is $" + currBal);
            return sum;

        } finally {
            System.out.print("");
        }
    }

    private static String calculatePaycheck() {
        Scanner scan = new Scanner(System.in);
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            String payFormatted = "";
            System.out.print("Hours: ");
            double hours = scan.nextDouble();

            System.out.print("Wage: ");
            double wage = scan.nextDouble();

            double taxes = 0.165;
            double taxedWage = taxes * 18.00;
            double newWage = wage - taxedWage;
            double toSavings = 100.00;
            double pay = hours * newWage - toSavings;
            payFormatted = df.format(pay);
            System.out.println("Paycheck: $" + payFormatted);
            return payFormatted;
        } finally {
            System.out.print("");
        }
    }
    public static void paycheckWeek() {
        getPrevFriday();
        getNextFriday();
        System.out.println("");
    }

    public static void getPrevFriday() {
        LocalDate dt = LocalDate.now();    
        System.out.print("\nPrevious Friday: "+dt.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
    }
    public static void getNextFriday() {
        LocalDate dt = LocalDate.now();    
        System.out.print("\nNext Friday: "+dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    }
}