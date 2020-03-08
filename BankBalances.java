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
        System.out.println("WELCOME TO SCOTTBANK");
        System.out.println("1 - Add purchase");
        System.out.println("2 - Calculate a paycheck");
        
        Scanner scan = new Scanner(System.in);
        Integer menu = scan.nextInt();
        switch (menu) {
            case 1:
                Spend();
            case 2:
                calculatePaycheck();
        }
    }

    private static String calculatePaycheck() {
        DecimalFormat df = new DecimalFormat("#.00");
        String payFormatted = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to calculate a paycheck? y/n");
        String response = scan.nextLine();
        switch (response) {
            case "y":
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
                break;
            case "n":
                System.out.println("Okay.");
                break;
        }
        return payFormatted;
    }
    // private static String StartChecking(double startCheckingBalance) {
    //     DecimalFormat df = new DecimalFormat("#.00");
    //     String newStartingBalance = df.format(startCheckingBalance);
    //     return newStartingBalance;
    // }




    // private static String EndChecking(double endCheckingBalance) {
    //     Double EndBalance = StartChecking(1544.32) - Spend(100.00);
    //     DecimalFormat df = new DecimalFormat("#.00");
    //     String newEndBalance = df.format(endCheckingBalance);
    //     return newEndBalance;
    // }
    // public int getCurrCheckBal() {
    //     return StartChecking - Spend;
    // }
    private static Double Spend() {
        ArrayList<Double> spendAmount = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        System.out.println("Would you like to add purchases? y/n ");
        String response = scan.nextLine();
        switch (response) {
            case "y":
                System.out.println("How many purchases would you like to add?");
                int NoOfPurchases = scan.nextInt();
                for (int i=0; i<NoOfPurchases; i++) {
                    System.out.print("How much was your purchase? ");
                    Double currPur = scan.nextDouble();
                    spendAmount.add(currPur);
                }
                break;
            case "n":
                System.out.println("Okay.");
                break;
        }
        for (Double purchases : spendAmount) {
                sum += purchases;
        }
        System.out.println(sum);
        return sum;

        // DecimalFormat df = new DecimalFormat("#.00");
        // String newStartingBalance = df.format(startCheckingBalance);
        // return newSpendAmount;
    }
    // public double addPurchases() {
    //     double sum = 0;
    //     for (int i=0; i<NoOfPurchases; i++) {
    //         System.out.print("How much was your purchase? ");
    //         Double currPur = scan.nextDouble();
    //         spendAmount.add(currPur);
    //     }
    //     return sum;
    // }
}