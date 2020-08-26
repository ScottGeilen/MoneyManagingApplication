import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class IncomeTax {
    static Scanner scan = new Scanner(System.in);
    private int FilingStatus() {
        System.out.print("What is your filing status?\n1. Single\n2. Married Filing Jointly\n3. Head of Household\n: ");
        this.FilingStatus = scan.nextInt();
        return FilingStatus;
    }
    public int getFilingStatus() {
        return this.FilingStatus;
    }
    private static Double getHourlyIncomeTax() {
        double totalHours = Salary.getHours();

        double salary = totalHours * 12;
        double incomeTax = 0.00;

        FilingStatus status = new FilingStatus();
        int filingStatus = status.getFilingStatus();

        switch (filingStatus) {
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
    private static double calculateIncomeTax() {
        Scanner scan = new Scanner(System.in);
        // salary
        askSalary yearly = new askSalary();
        double salary = yearly.getSalary();
        double incomeTax = 0.00;
        switch (IncomeTax.FilingKey) {
            case 1:
                if (salary < 9700) {
                    incomeTax = .10;
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
                    incomeTax = .10;
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
        System.out.println("Your income tax is " + incomeTax + "%");
        return incomeTax;
    }
}