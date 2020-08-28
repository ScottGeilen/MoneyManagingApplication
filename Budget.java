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

    protected String collectBudgetPercentages() {
        try {
            calculatedPaycheck = paycheck.calculatePaycheck();
            System.out.println("\n***Tip: Exit by '.000'.");
            while (percentageLeft != 0) {
                if (paycheckLeft == 0) {
                    System.out.println("You have "+percentageLeft+"% or $" + money.currencyFormat(calculatedPaycheck) + " left to budget.");
                } else {
                    System.out.println("You have "+percentageLeft+"% or $" + money.currencyFormat(paycheckLeft) + " left.");
                }

                System.out.print("Budget category: ");
                budgetCategory = scan.nextLine();
                if (budgetList.containsKey(budgetCategory) == false) {
                    System.out.print("Budget percentage: ");
                    while (true) {
                        try {
                            budgetPercentage = scan.nextDouble();
                            break;
                        } catch (NumberFormatException ignore) {
                            System.out.print("Please input budget percentage.");
                        }
                    }
                    budgetList.put(budgetCategory, budgetPercentage);
                    percentageLeft -= budgetPercentage;
                    realPercent = budgetPercentage / 100;
                    budgetOfPaycheck = realPercent * calculatedPaycheck;
                    paycheckLeft = calculatedPaycheck - budgetOfPaycheck;
                    System.out.println("You will allocate "+budgetPercentage+"% or $"+money.currencyFormat(budgetOfPaycheck)+" for "+ budgetCategory);
                    scan.nextLine();
                    if (percentageLeft == 0) {
                        exit = true;
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
        System.out.println("Your budget consists of:");
        for (Map.Entry<String, Double> e : budgetList.entrySet()) {
            System.out.println("Category:" + e.getKey() + "%");
            System.out.println("Percentage:" + e.getValue() + "%");
        }
        return budgetCategory;
    }
}