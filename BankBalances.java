import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;



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
        try {
            double sum = 0;
            System.out.print("Enter amount in Checking: ");
            double startChecking = scan.nextDouble(); // stores user input to double startChecking
            System.out.println("Your starting checking amount is $" + startChecking);

            ArrayList<Double> spendAmount = new ArrayList<Double>();
            boolean exit = false;
            while (!exit) {
                // check if user input is "done"
                System.out.print("Exit by '.123'. How much is your purchase? ");
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
            double subTotal = startChecking - sum;
            System.out.println("\nYou will spend $" + sum);
            System.out.println("You will have a balance of $" + subTotal);
            return sum;
        }
        finally {
            System.out.print("");
        }
    }

    private static String checkPaycheckPurchases() {
        Scanner scan = new Scanner(System.in);
        try {
            DecimalFormat df = new DecimalFormat("#.00");
            String payFormatted = "";
            System.out.print("Hours: ");
            double hours = scan.nextDouble();

            System.out.print("Wage: ");
            double wage = scan.nextDouble();

            double taxes = 0.165;
            double irs = taxes * wage;
            double taxedWage = wage - irs;
            double toSavings = 100.00;
            double pay = hours * taxedWage - toSavings;
            payFormatted = df.format(pay);
            System.out.println("Paycheck: $" + payFormatted);
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
}