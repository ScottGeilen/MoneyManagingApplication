import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Tax {
    Scanner scan = new Scanner(System.in);
    protected double incomeTax;
    protected double salary;
    protected int filingKey;
    protected double totalHours;
    protected double hourlyWage;
    protected double showTax;

    Compensation hours = new Compensation();
    Wage wage = new Wage();

    protected int getFilingStatus() {
        System.out.print("What is your filing status?\n1. Single\n2. Married Filing Jointly\n3. Head of Household\n: ");
        filingKey = scan.nextInt();
        return filingKey;
    }

    protected double CalculateIncomeTaxHourly(int filingKey, double hourlyWage) {
        salary = hourlyWage * 40 * 52;
        switch (filingKey) {
            case 1:
                if (salary > 1 && salary < 9700) {
                    incomeTax = .1;
                } if (salary > 9700 && salary <= 39475) {
                    incomeTax = .12;
                } if (salary > 39475 && salary <= 84200) {
                    incomeTax = .22;
                } if (salary > 84200 && salary <= 160725) {
                    incomeTax = .24;
                } if (salary > 160725 && salary <= 204100) {
                    incomeTax = .32;
                } if (salary > 204100 && salary <= 510300) {
                    incomeTax = .35;
                } if (salary > 510300) {
                    incomeTax = .37;
                }
                break;
            case 2:
                if (salary > 1 && salary < 19400) {
                    incomeTax = .1;
                } if (salary > 19400 && salary <= 78950) {
                    incomeTax = .12;
                } if (salary > 78950 && salary <= 168400) {
                    incomeTax = .22;
                } if (salary > 168400 && salary <= 321450) {
                    incomeTax = .24;
                } if (salary > 321450 && salary <= 408200) {
                    incomeTax = .32;
                } if (salary > 408200 && salary < 612350) {
                    incomeTax = .35;
                } if (salary > 612350) {
                    incomeTax = .37;
                }
                break;
            case 3:
                if (salary > 1 && salary < 13850) {
                    incomeTax = .1;
                } if (salary > 13850 && salary <= 52850) {
                    incomeTax = .12;
                } if (salary > 52850 && salary <= 84200) {
                    incomeTax = .22;
                } if (salary > 84200 && salary <= 160700) {
                    incomeTax = .24;
                } if (salary > 160700 && salary <= 204100) {
                    incomeTax = .32;
                } if (salary > 204100 && salary <= 510300) {
                    incomeTax = .35;
                } if (salary > 510300) {
                    incomeTax = .37;
                }
                break;
            default:
                System.out.println("You did not select 1, 2, 3, or 4.");
                break;
        }
        showTax = incomeTax * 100;
        System.out.println("Hourly income tax: " + showTax + "%");
        return incomeTax;
    }
    protected double CalculateIncomeTaxSalary(int filingKey, double salary) {
        switch (filingKey) {
            case 1:
                if (salary > 1 && salary < 9700) {
                    incomeTax = .1;
                } if (salary > 9700 && salary <= 39475) {
                    incomeTax = .12;
                } if (salary > 39475 && salary <= 84200) {
                    incomeTax = .22;
                } if (salary > 84200 && salary <= 160725) {
                    incomeTax = .24;
                } if (salary > 160725 && salary <= 204100) {
                    incomeTax = .32;
                } if (salary > 204100 && salary <= 510300) {
                    incomeTax = .35;
                } if (salary > 510300) {
                    incomeTax = .37;
                }
                break;
            case 2:
                if (salary > 1 && salary < 19400) {
                    incomeTax = .1;
                } if (salary > 19400 && salary <= 78950) {
                    incomeTax = .12;
                } if (salary > 78950 && salary <= 168400) {
                    incomeTax = .22;
                } if (salary > 168400 && salary <= 321450) {
                    incomeTax = .24;
                } if (salary > 321450 && salary <= 408200) {
                    incomeTax = .32;
                } if (salary > 408200 && salary <= 612350) {
                    incomeTax = .35;
                } if (salary > 612350) {
                    incomeTax = .37;
                }
                break;
            case 3:
                if (salary > 1 && salary < 13850) {
                    incomeTax = .1;
                } if (salary > 13850 && salary <= 52850) {
                    incomeTax = .12;
                } if (salary > 52850 && salary <= 84200) {
                    incomeTax = .22;
                } if (salary > 84200 && salary <= 160700) {
                    incomeTax = .24;
                } if (salary > 160700 && salary <= 204100) {
                    incomeTax = .32;
                } if (salary > 204100 && salary <= 510300) {
                    incomeTax = .35;
                } if (salary > 510300) {
                    incomeTax = .37;
                }
                break;
            default:
                System.out.println("You did not select 1, 2, 3, or 4.");
                break;
        }
        showTax = incomeTax * 100;
        System.out.println("Salary income tax: " + showTax + "%");
        return incomeTax;
    }
    
}