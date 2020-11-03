import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Paycheck {
    Scanner scan = new Scanner(System.in);
    Tax tax = new Tax();
    Compensation hours = new Compensation();
    Wage wage = new Wage();
    MoneyManager money = new MoneyManager();
    ArrayList<Double> spendAmount = new ArrayList<Double>();
    List<List<String>> rows = Arrays.asList(
        Arrays.asList("Employee Type"),
        Arrays.asList("Wage"),
        Arrays.asList("Hours"),
        Arrays.asList("Paycheck")
        );

    //FileWriter csvWriter = new FileWriter("budget.csv");
    protected double incomeTax;
    protected double hourlyWage;
    protected double totalHours;
    protected double salary;
    protected int EmployeeType;
    protected int key;
    protected double subTotal;
    protected double paycheck;
    protected double sum;
    protected double spending;
    protected double startingAmount;
    protected double subtotalPaycheck;
    protected double calculatedPaycheck;
    protected double calculatedPaycheckTax;
    protected double toSavings;
    protected String payFrequency;
    protected Double currPur;
    protected boolean exit = false;
    protected String payFormatted = "";

    protected Double calculateSalaryPaycheck() {
        salary = wage.getSalary();
        //csvWriter.append(salary);
        totalHours = hours.getTotalHours();

        key = tax.getFilingStatus();
        incomeTax = tax.calculateIncomeTax(key, salary);
        switch (hours.PayFrequency) {
            case 1:
                payFrequency = "Monthly";
                subtotalPaycheck = salary / 12;
                break;
            case 2:
                payFrequency = "SemiMonthly";
                subtotalPaycheck = salary / 24;
                break;
            case 3:
                payFrequency = "BiWeekly";
                subtotalPaycheck = salary / 26;
                break;
            case 4:
                payFrequency = "Weekly";
                subtotalPaycheck = salary / 52;
                break;
            default:
                System.out.println("Error");
                break;
        }
        calculatedPaycheckTax = subtotalPaycheck * incomeTax;
        calculatedPaycheck = subtotalPaycheck - calculatedPaycheckTax;
        try {
            FileWriter writer = new FileWriter("C:\\Users\\scott\\code\\projectslaptop02252020\\MoneyManagingApp\\docs\\paycheck.txt");
            
            writer.write(payFrequency);
            writer.write("\nPaycheck frequency: " + payFrequency);
            writer.write("\nPaycheck before tax: " + money.currencyFormat(subtotalPaycheck));
            writer.write("\nIncome tax: " + incomeTax);
            writer.write("\nPaycheck tax: " + money.currencyFormat(calculatedPaycheckTax));
            writer.write("\nPaycheck after tax: " + money.currencyFormat(calculatedPaycheck));
            writer.close();
        } catch (IOException e) {
            System.out.println("An Error occurred");
            e.printStackTrace();
        }
        System.out.println("\nAs a salaried employee:");
        System.out.println("- Your " + payFrequency + " paycheck before tax will be $" + money.currencyFormat(subtotalPaycheck));
        System.out.println("- Your " + payFrequency + " paycheck tax is $" + money.currencyFormat(calculatedPaycheckTax));
        System.out.println("- Your " + payFrequency + " paycheck after tax will be $" + money.currencyFormat(calculatedPaycheck));
        return calculatedPaycheck;
    }

    protected Double calculateHourlyPaycheck() {
        hourlyWage = wage.getHourly();
        totalHours = hours.getTotalHours();
        
        key = tax.getFilingStatus();
        salary = tax.calculateSalary(hourlyWage, totalHours);
        incomeTax = tax.calculateIncomeTax(key, salary);
        
        subtotalPaycheck = hourlyWage * totalHours;
        calculatedPaycheckTax = subtotalPaycheck * incomeTax;
        calculatedPaycheck = subtotalPaycheck - calculatedPaycheckTax;

        System.out.println("\nAs an hourly employee:");
        System.out.println("- Your paycheck before tax will be $" + money.currencyFormat(subtotalPaycheck));
        System.out.println("- Your paycheck tax is $" + money.currencyFormat(calculatedPaycheckTax));
        System.out.println("- Your paycheck after tax will be $" + money.currencyFormat(calculatedPaycheck));
        return calculatedPaycheck;
    }
    protected Double calculatePaycheck() {
        try {
            System.out.print("\nCALCULATE NEXT PAYCHECK.\nWhich employee type are you?\n1. Salary\n2. Hourly\n: ");
            EmployeeType = scan.nextInt();
            switch (EmployeeType) {
                case 1:   
                    calculateSalaryPaycheck();
                    break;
                case 2: 
                    calculateHourlyPaycheck();
                    break;
            }
            return calculatedPaycheck;
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.print("");
        } return (0.00);
    }

    protected String calculatePaycheckPurchases() {
        try {
            //System.out.print("How much to put away for savings?\n: ");
            //toSavings = scan.nextDouble();
            paycheck = calculatePaycheck();
            addSpending();
            return payFormatted;
        } finally {
            System.out.print("");
        }
    }
    protected Double addSpending() {
        try {
            startingAmount = startAmount();
            System.out.println("\n***Tip: Exit by '.000'.");
            while (!exit) {
                System.out.print("How much is your purchase? $");
                currPur = scan.nextDouble();
                if (currPur.equals(.000)) {
                    exit = true;
                }
                spendAmount.add(currPur);
            }
            for (Double purchases : spendAmount) {
                sum += purchases;
            }
            subTotal = startingAmount - sum;
            System.out.println("\nYou will spend $" + money.currencyFormat(sum));
            System.out.println("You will have a remaining balance of $" + money.currencyFormat(subTotal));
            return sum;
        }
        finally {
            System.out.print("");
        }
    }
    protected Double startAmount() {
        try {
            System.out.print("\nWhat is your starting amount?\n: $");
            startingAmount = scan.nextDouble();
            System.out.println("Your starting amount is $" + money.currencyFormat(startingAmount));
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.println("");
        }
        return startingAmount;
    }
}