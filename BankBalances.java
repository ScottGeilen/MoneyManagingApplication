import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Hashtable;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class BankBalances {
    public static void main(String[] args) {
        System.out.println("03/06/2020 Paycheck: " + calculatePaycheck(24.00, 18.00));
        System.out.println("03/06/2020 Checking: " + StartChecking(1544.32));
        System.out.println("03/19/2020 Checking: " + EndChecking(endCheckingBalance));
        Spend(400);
    }

    private static String calculatePaycheck(double hours, double wage) {
        DecimalFormat df = new DecimalFormat("#.00");
        double taxes = 0.165;
        double taxedWage = taxes * 18.00;
        double newWage = wage - taxedWage;
        double toSavings = 100.00;
        double pay = hours * newWage - toSavings;
        String payFormatted = df.format(pay);
        return payFormatted;
    }
    private static String StartChecking(double startCheckingBalance) {
        DecimalFormat df = new DecimalFormat("#.00");
        String newStartingBalance = df.format(startCheckingBalance);
        return newStartingBalance;
    }
    // private static String EndChecking(double endCheckingBalance) {
    //     Double EndBalance = StartChecking(1544.32) - Spend(100.00);
    //     DecimalFormat df = new DecimalFormat("#.00");
    //     String newEndBalance = df.format(endCheckingBalance);
    //     return newEndBalance;
    // }
    // public int getCurrCheckBal() {
    //     return StartChecking - Spend;
    // }
    private static String Spend(double spendingAmount) {
        ArrayList<Double> spendAmount = new ArrayList<Double>();
        Scanner scan = new Scanner(System.in);
        System.out.println("How many purchases would you like to add?");
        int NoOfPurchases = scan.nextLine();
        for (int i=0; i<NoOfPurchases; i++) {
            System.out.print("How much was your purchase? ");
            Double currPur = scan.nextLine();
            spendAmount.add(currPur);
        }
        return spendAmount;

        // DecimalFormat df = new DecimalFormat("#.00");
        // String newStartingBalance = df.format(startCheckingBalance);
        // return newSpendAmount;
    }
}