import javax.swing.*;

//import org.graalvm.compiler.replacements.arraycopy.PluginFactory_CheckcastArrayCopyCallNode;

import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.io.File;
import java.math.*;

public class Budget {
    Scanner scan = new Scanner(System.in);
    Tax tax = new Tax();
    Compensation hours = new Compensation();
    Wage wage = new Wage();
    Paycheck paycheck = new Paycheck();
    MoneyManager money = new MoneyManager();
    HashMap<String, Double> budgetList = new HashMap<>();
    protected double paycheckLeft;
    BigDecimal paycheckLeft1 = new BigDecimal(paycheckLeft);
    protected double calculatedPaycheck;
    protected boolean exit;
    protected String budgetCategory;
    protected double budgetPercentage;
    protected double percentageLeft = 100;
    protected double realPercent;
    protected double budgetOfPaycheck;
    protected double budgetMoney;
    BigDecimal budgetMoney1 = new BigDecimal(budgetMoney);
    MathContext mc = new MathContext(2);
    BigDecimal paycheckLeft2;

    protected String collectBudget() {
        try {
            calculatedPaycheck = paycheck.calculatePaycheck();
            paycheckLeft = calculatedPaycheck;
            System.out.println("\n***Tip: Exit by '.000'.");
            while (paycheckLeft > 0) {
                //System.out.println("\n\npaycheck left: " + paycheckLeft);
                if (paycheckLeft == 0 || paycheckLeft < 0) {
                    //System.out.println("\n\npaycheck left: " + paycheckLeft);
                    System.out.println("Paycheck is successfully allocated.");
                    exit = true;
                } else {
                    //System.out.println("\n\npaycheck left: " + paycheckLeft);
                    System.out.println("You have $"+money.currencyFormat(paycheckLeft)+" left to budget.");
                    System.out.print("Budget category: ");
                    budgetCategory = scan.nextLine();
                    if (budgetList.containsKey(budgetCategory) == false) {
                        System.out.print("Budget amount: $");
                        while (true) {
                            try {
                                budgetMoney = scan.nextDouble();
                                if (budgetMoney == paycheckLeft) {
                                    System.out.println("Paycheck is successfully allocated");
                                    break;
                                }
                                if (budgetMoney > paycheckLeft) {
                                    System.out.println("Please input a budget amount smaller than paycheck amount.");
                                    System.out.print("Budget amount: $");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.print("Please input budget amount.");
                            }
                        }
                        budgetList.put(budgetCategory, budgetMoney);
                        //paycheckLeft2 = paycheckLeft1.subtract(budgetMoney1, mc);
                        paycheckLeft -= budgetMoney;
                        //percentageLeft -= budgetPercentage;
                        //realPercent = budgetPercentage / 100;
                        //budgetOfPaycheck = realPercent * calculatedPaycheck;
                        //paycheckLeft = calculatedPaycheck - budgetOfPaycheck;//"+budgetPercentage+"% or
                        //System.out.println("\npaycheck2 left after subtracting: " + paycheckLeft2);
                        System.out.println("You will allocate $"+money.currencyFormat(budgetMoney)+" for "+ budgetCategory);
                        scan.nextLine();
                        //System.out.println("\n\npaycheck2 left after allocating: " + paycheckLeft2);
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
        System.out.println("\nWith a total paycheck of $" + money.currencyFormat(calculatedPaycheck)+", your budget consists of:");
        for (Map.Entry<String, Double> e : budgetList.entrySet()) {
            System.out.println("Category: " + e.getKey());
            System.out.println("Amount: $" + e.getValue());
        }
        return budgetCategory;
    }
}