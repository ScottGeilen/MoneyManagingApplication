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
                System.out.println("\n\nToday: " + today);
                try { TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e){
                    System.out.println("No sleep");}
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
                        exit = true;
                        if (scan != null)
                            scan.close();
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
            System.out.print("\nEnter starting amount: $");
            startAmount = scan.nextDouble(); // stores user input to double startChecking
            System.out.println("Your starting amount is $" + currencyFormat(startAmount));
            System.out.println("\n***Tip: Exit by '.123'.");
            // sleep
            try { TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e){
                System.out.println("No sleep");}

            ArrayList<Double> spendAmount = new ArrayList<Double>();
            boolean exit = false;
            while (!exit) { // repeats
                System.out.print("How much is your purchase? $");
                Double currPur = scan.nextDouble();
                if (currPur.equals(.123)) {
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
            System.out.println("You will have a balance of $" + currencyFormat(subTotal));
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

            System.out.print("Hours: ");
            double hours = scan.nextDouble();
            System.out.print("Wage: $");
            double wage = scan.nextDouble();
            
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
                    double biWeeklyPay = hours * 2 * taxedWage - toSavings;
                    System.out.println("\nYour bi-weekly paycheck is $" + currencyFormat(biWeeklyPay));
                    checkPurchase();
                    break;
            }
            return payFormatted;
        } finally {
            System.out.print("");
        }
    }
    // public static void paycheckWeek() {
    //     getPrevFriday();
    //     getNextFriday();
    //     System.out.println("");
    // }

    // public static void getPrevFriday() {
    //     LocalDate dt = LocalDate.now();    
    //     System.out.print("\nPrevious Friday: "+ vdt.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)));
    // }
    // public static void getNextFriday() {
    //     LocalDate dt = LocalDate.now();
    //     System.out.print("\nNext Friday: "+ vdt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    // }
    private static String currencyFormat(Double num) {
        DecimalFormat df = new DecimalFormat("#.00");
        //Double newCurrencyFormat = Double.parseDouble(num);
        String newestFormatted = df.format(num);
        return newestFormatted;
    }
    
}