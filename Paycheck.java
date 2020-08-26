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

    protected double incomeTax;
    protected double hourlyWage;
    protected double calculatedPaycheck;
    protected double totalHours;
    protected double salary;
    protected int EmployeeType;
    protected int key;

    protected Double setSalaryPaycheck() {
        // hours
        totalHours = hours.getTotalHours();
        // salary
        salary = wage.getSalary();
        // filing status for tax
        key = tax.getFilingStatus();
        incomeTax = tax.CalculateIncomeTaxSalary(key);
        
        calculatedPaycheck = incomeTax * salary / totalHours;
        System.out.println("\nAs a salary employee, your paycheck will be $" + calculatedPaycheck + ".");
        return calculatedPaycheck;
    }

    protected Double setHourlyPaycheck() {
        hourlyWage = wage.getHourly();
        key = tax.getFilingStatus();
        incomeTax = tax.CalculateIncomeTaxHourly(key, hourlyWage);
        totalHours = hours.getTotalHours();
        calculatedPaycheck = hourlyWage * incomeTax * totalHours;
        System.out.println("\nAs a hourly employee, your paycheck will be $" + calculatedPaycheck + ".");
        return calculatedPaycheck;
    }
    protected Double calculatePaycheck() {
        try {
            System.out.print("\nAre you on salary, or hourly?\n1. Salary\n2. Hourly\n: ");
            EmployeeType = scan.nextInt();
            switch (EmployeeType) {
                case 1:   
                    setSalaryPaycheck();
                    break;
                case 2: 
                    setHourlyPaycheck();
            }
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            System.out.print("");
        } return (0.00);
    }
}