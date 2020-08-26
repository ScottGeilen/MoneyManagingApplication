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
    protected double salary;
    protected double hourly;
    protected double yearly;
    
    protected double getSalary() {
        System.out.println("What is your salary wage?\n: ");
        salary = scan.nextDouble();
        return salary;
    }
    protected double setSalary(double yearly) {
        return this.yearly;
    }
    
    protected double getHourly() {
        System.out.print("What is your hourly wage?\n: ");
        hourly = scan.nextDouble();
        return hourly;
    }
}