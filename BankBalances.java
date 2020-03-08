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
        //restart = false;
        menu();
    }
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("WELCOME TO SCOTTBANK");
            System.out.println("1 - Add purchase");
            System.out.println("2 - Calculate a paycheck");
            System.out.println("3 - Exit");
            
            
            Integer menu = scan.nextInt();
            switch (menu) {
                case 1:
                    Spend();
                    break;
                case 2:
                    calculatePaycheck();
                    break;
                case 3:
                    break;
            }
        }
        finally {
            if (scan != null)
                scan.close();
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

            scan.close();
            return payFormatted;
        }
        finally {
            if (scan != null)
                scan.close();
        }
        
    }
    private static Double Spend() {
        ArrayList<Double> spendAmount = new ArrayList<Double>();
        //Scanner scan = new Scanner(System.in);
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



            System.out.println(sum);
            return sum;
        }
        finally {
            if (scan != null)
                scan.close();
        }
    }
}