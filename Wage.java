import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Wage {
    Scanner scan = new Scanner(System.in);
    protected double salary = 0.00;
    protected double hourly;
    protected double yearly;
    MoneyManager money = new MoneyManager();
    
    protected double getSalary() {
        System.out.println("What is your salary wage?\n: ");
        salary = scan.nextDouble();
        salary = setSalary(salary);
        System.out.println("Your salary is $" + money.currencyFormat(salary));
        return salary;
    }
    protected double setSalary(double yearly) {
        return this.salary;
    }
    
    protected double getHourly() {
        System.out.print("What is your hourly wage?\n: ");
        hourly = scan.nextDouble();
        return hourly;
    }
}