import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Budget {
    Scanner scan = new Scanner(System.in);
    Tax tax = new Tax();
    Compensation hours = new Compensation();
    Wage wage = new Wage();
    Paycheck paycheck = new Paycheck();
    MoneyManager money = new MoneyManager();
    HashMap<String, Double> budgetList = new HashMap<>();
    protected double calculatedPaycheck;
    protected boolean exit;
    protected String budgetCategory;
    protected double budgetPercentage;
    protected double percentageLeft = 100;
    protected double realPercent;
    protected double budgetOfPaycheck;
    protected double paycheckLeft;
    protected double budgetMoney;

    protected String collectBudget() {
        try {
            calculatedPaycheck = paycheck.calculatePaycheck();
            paycheckLeft = calculatedPaycheck;
            System.out.println("\n***Tip: Exit by '.000'.");
            while (paycheckLeft > 0.0) {
                if (paycheckLeft == 0.0) {
                    System.out.println("You have $"+money.currencyFormat(calculatedPaycheck)+" left to budget.");
                } else {
                    if (paycheckLeft == 0) {
                        exit = true;
                    }
                    System.out.println("You have $"+money.currencyFormat(paycheckLeft)+" left.");
                    System.out.print("Budget category: ");
                    budgetCategory = scan.nextLine();
                    if (budgetList.containsKey(budgetCategory) == false) {
                        System.out.print("Budget amount: $");
                        while (true) {
                            try {
                                budgetMoney = scan.nextDouble();
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.print("Please input budget percentage.");
                            }
                        }
                        budgetList.put(budgetCategory, budgetMoney);
                        paycheckLeft -= budgetMoney;
                        //percentageLeft -= budgetPercentage;
                        //realPercent = budgetPercentage / 100;
                        //budgetOfPaycheck = realPercent * calculatedPaycheck;
                        //paycheckLeft = calculatedPaycheck - budgetOfPaycheck;//"+budgetPercentage+"% or
                        System.out.println("You will allocate $"+money.currencyFormat(budgetMoney)+" for "+ budgetCategory);
                        scan.nextLine();
                        if (paycheckLeft == 0) {
                            exit = true;
                        }
                    }
                }
                }
            // for (Map.Entry<String, Double> budgetList : budgetList.entrySet()) {
            //     System.out.println("\n" + budgetList.getKey() + " " + budgetList.getValue());
            // }
        }
        finally {
            System.out.print("");
        }
        System.out.println("\nWith a total paycheck of $" + money.currencyFormat(calculatedPaycheck)+",");
        System.out.println("your budget consists of:");
        for (Map.Entry<String, Double> e : budgetList.entrySet()) {
            System.out.println("Category: " + e.getKey());
            System.out.println("Amount: $" + e.getValue());
        }
        return budgetCategory;
    }
}