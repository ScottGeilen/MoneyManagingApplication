import java.util.*;

public class Wage {
    Scanner scan = new Scanner(System.in);
    protected double salary = 0.00;
    protected double hourly;
    protected double yearly;
    MoneyManager money = new MoneyManager();
    
    protected double getSalary() {
        System.out.print("\nWhat is your salary wage?\n: $");
        salary = scan.nextDouble();
        salary = setSalary(salary);
        System.out.println("Your salary is $" + money.currencyFormat(salary));
        return salary;
    }
    protected double setSalary(double yearly) {
        return this.salary;
    }
    
    protected double getHourly() {
        System.out.print("\nWhat is your hourly wage?\n: $");
        hourly = scan.nextDouble();
        System.out.print("Your hourly wage is $" + money.currencyFormat(hourly));
        return hourly;
    }
}