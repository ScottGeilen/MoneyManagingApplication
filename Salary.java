import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Salary {
    private double Salary() {
        /* Asks user for salary. Saves input. */
        System.out.println("What is your salary?\n: ");
        double salary = scan.nextDouble();
    }
    public double getSalary() {
        return this.salary;
    }

    private double calculateYearlyForHourly() {
        /* Calculates salary pay based on hours per week and hourly wage */
        Wage wage = new Wage();
        double hourlyWage = wage.getWage();

        Hours hours = new Hours();
        double totalhours = hours.getHours();

        double hoursPerYear = totalHours * 12;
        double hourlySalary = hoursPerYear * wage;
        return hourlySalary;
    }
    public double getHourlySalary() {
        return this.hourlySalary;
    }
}