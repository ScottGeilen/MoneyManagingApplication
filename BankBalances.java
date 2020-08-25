import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

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
                System.out.println("1 - Calculate next paycheck");
                System.out.println("2 - Test purchases from calculated paycheck");
                System.out.println("3 - Test purchases you want to make");
                System.out.println("4 - Exit");
                System.out.println("5 - salary income tax");
                Integer menu = scan.nextInt();

                switch (menu) {
                    case 1:
                        calculatePaycheck();
                        break;
                    case 2:
                        checkPaycheckPurchases();
                        break;
                    case 3:
                        checkPurchase();
                        break;
                    case 4:
                        if (scan != null)
                            scan.close();
                        exit = true;
                        break;
                    case 5:
                        CalculateIncomeTaxSalary();
                }
            } finally {
                System.out.println("");
            }
        }
    }
    private static Double calculatePaycheck() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Are you on salary, or hourly?\n1. Salary\n2. Hourly\n: ");
            int EmployeeType = scan.nextInt();
            switch (EmployeeType) {
                case 1:
                    calculateTaxedSalaryPaycheck();
                    break;
                case 2:
                    calculateTaxedHourlyPaycheck();
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.print("");
        } return (0.00);
    }
    public static Double startAmount() {
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
    private static Double checkPurchase() {
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
    private static double CalculateIncomeTaxSalary() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your filing status?\n1. Single\n2. Married Filing Jointly\n3. Head of Household\n: ");
        int FilingKey = scan.nextInt();
        System.out.println("What is your salary?\n: ");
        double salary = scan.nextDouble();
        double incomeTax = 0.00;
        switch (FilingKey) {
            case 1:
                if (salary < 9700) {
                    incomeTax = .1;
                } if (salary < 39475) {
                    incomeTax = .12;
                } if (salary < 84200) {
                    incomeTax = .22;
                } if (salary < 160725) {
                    incomeTax = .24;
                } if (salary < 204100) {
                    incomeTax = .32;
                } if (salary < 510300) {
                    incomeTax = .35;
                } if (510300 < salary) {
                    incomeTax = .37;
                }
                break;
            case 2:
                if (salary < 19400) {
                    incomeTax = .1;
                } if (salary < 78950) {
                    incomeTax = .12;
                } if (salary < 168400) {
                    incomeTax = .22;
                } if (salary < 321450) {
                    incomeTax = .24;
                } if (salary < 408200) {
                    incomeTax = .32;
                } if (salary < 612350) {
                    incomeTax = .35;
                } if (612350 < salary) {
                    incomeTax = .37;
                }
                break;
            case 3:
                if (salary < 13850) {
                    incomeTax = .1;
                } if (salary < 52850) {
                    incomeTax = .12;
                } if (salary < 84200) {
                    incomeTax = .22;
                } if (salary < 160700) {
                    incomeTax = .24;
                } if (salary < 204100) {
                    incomeTax = .32;
                } if (salary < 510300) {
                    incomeTax = .35;
                } if (510300 < salary) {
                    incomeTax = .37;
                }
                break;
            default:
                System.out.println("You did not select 1, 2, 3, or 4.");
                break;
        }
        System.out.println("Salary income tax: $" + incomeTax + "%");
        return incomeTax;
    }
    private static Double CalculateIncomeTaxHourly() {
        Scanner scan = new Scanner(System.in);
        double totalHours = getHourlyHours();
        System.out.print("What is your filing status?\n1. Single\n2. Married Filing Jointly\n3. Head of Household\n: ");
        int FilingKey = scan.nextInt();
        double salary = totalHours * 12;
        double incomeTax = 0.00;
        switch (FilingKey) {
            case 1:
                if (salary < 9700) {
                    incomeTax = .1;
                } if (salary < 39475) {
                    incomeTax = .12;
                } if (salary < 84200) {
                    incomeTax = .22;
                } if (salary < 160725) {
                    incomeTax = .24;
                } if (salary < 204100) {
                    incomeTax = .32;
                } if (salary < 510300) {
                    incomeTax = .35;
                } if (510300 < salary) {
                    incomeTax = .37;
                }
                break;
            case 2:
                if (salary < 19400) {
                    incomeTax = .1;
                } if (salary < 78950) {
                    incomeTax = .12;
                } if (salary < 168400) {
                    incomeTax = .22;
                } if (salary < 321450) {
                    incomeTax = .24;
                } if (salary < 408200) {
                    incomeTax = .32;
                } if (salary < 612350) {
                    incomeTax = .35;
                } if (612350 < salary) {
                    incomeTax = .37;
                }
                break;
            case 3:
                if (salary < 13850) {
                    incomeTax = .1;
                } if (salary < 52850) {
                    incomeTax = .12;
                } if (salary < 84200) {
                    incomeTax = .22;
                } if (salary < 160700) {
                    incomeTax = .24;
                } if (salary < 204100) {
                    incomeTax = .32;
                } if (salary < 510300) {
                    incomeTax = .35;
                } if (510300 < salary) {
                    incomeTax = .37;
                }
                break;
            default:
                System.out.println("You did not select 1, 2, 3, or 4.");
                break;
        }
        return incomeTax;
    }
    private static Double calculateTaxedSalaryPaycheck() {
        Scanner scan = new Scanner(System.in);
        double incomeTax = CalculateIncomeTaxSalary();
        double calculatedTaxedSalary = incomeTax; // incomeTax * salary
        System.out.println("Your salaried and taxed paycheck is $" + calculatedTaxedSalary + ".");
        return calculatedTaxedSalary;
    }
    private static Double getHourlyHours() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your pay frequency?\n1. Monthly\n2. SemiMonthly\n3. BiWeekly\n4. Weekly\n: ");
        int PayFrequency = scan.nextInt();
        double totalHours = 0.00;
        switch (PayFrequency) {
            case 1:
                System.out.print("Monthly paychecks.\nFirst week hours: ");
                double hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                double hoursSecondWeek = scan.nextDouble();
                System.out.print("Third week hours: ");
                double hoursThirdWeek = scan.nextDouble();
                System.out.print("Fourth week hours: ");
                double hoursFourthWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek + hoursThirdWeek + hoursFourthWeek;
                break;
            case 2:
                System.out.print("SemiMonthly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 3:
                System.out.print("BiWeekly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 4:
                System.out.print("Weekly paychecks.\nTotal week hours: ");
                hoursFirstWeek = scan.nextDouble();
                totalHours = hoursFirstWeek;
                break;
        }
        return totalHours;
    }
    private static Double calculateTaxedHourlyPaycheck() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your hourly wage?\n: ");
        double hourlyWage = scan.nextDouble();
        double incomeTax = CalculateIncomeTaxHourly();
        double calculatedPaycheck = 0.00;
        double totalHours = getHourlyHours();
        calculatedPaycheck = hourlyWage * incomeTax * totalHours;
        System.out.println("Your hourly and taxed paycheck is $" + calculatedPaycheck + ".");
        return calculatedPaycheck;
    }
    private static String checkPaycheckPurchases() {
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