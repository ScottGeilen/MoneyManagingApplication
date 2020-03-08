import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Hashtable;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class BankBalances {
    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();
        System.out.println("Today: " + today);
        menu();
            
    }
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("WELCOME TO SCOTTBANK");
                System.out.println("1 - Add purchase");
                System.out.println("2 - Calculate a paycheck");
                System.out.println("3 - Initialize Checking");
                System.out.println("4 - Exit");
                Integer menu = scan.nextInt();

                switch (menu) {
                    case 1:
                        Spend();
                        break;
                    case 2:
                        calculatePaycheck();
                        break;
                    case 3:
                        InitalizeChecking();
                        break;
                    case 4:
                        exit = true;
                        if (scan != null)
                            scan.close();
                        break;
                }
            }
            finally {
                System.out.println("");
            }
        }
        
    }

    private static String calculatePaycheck() {
        Scanner scan = new Scanner(System.in);
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            String payFormatted = "";
            System.out.println("Hours: ");
            double hours = scan.nextDouble();

            System.out.println("Wage: ");
            double wage = scan.nextDouble();

            double taxes = 0.165;
            double taxedWage = taxes * 18.00;
            double newWage = wage - taxedWage;
            double toSavings = 100.00;
            double pay = hours * newWage - toSavings;
            payFormatted = df.format(pay);
            System.out.println("Paycheck: " + payFormatted);
            return payFormatted;
        }
        
        finally {
            System.out.println("");
        }
        
    }
    private static Double Spend() {
        ArrayList<Double> spendAmount = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        try {
            double sum = 0;
            System.out.println("How many purchases would you like to add?");
            int NoOfPurchases = scan.nextInt();
            for (int i=0; i<NoOfPurchases; i++) {
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
            
        }
        finally {
                System.out.println("");
            }
    }

    public static double InitalizeChecking() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter amount in Checking: ");
            double startChecking = scan.nextInt();
            
            System.out.println("Your starting checking amount is $" + startChecking);
            return startChecking;
        }
        finally {
            System.out.println("");
        }
    }
}