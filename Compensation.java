import javax.swing.*;
import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Compensation {
    Scanner scan = new Scanner(System.in);
    protected double totalHours = 0.00;
    protected double hoursFirstWeek;
    protected double hoursSecondWeek;
    protected double hoursThirdWeek;
    protected double hoursFourthWeek;
    protected int PayFrequency;

    protected Double getTotalHours() {
        System.out.print("\nWhat is your pay frequency?\n1. Monthly\n2. SemiMonthly\n3. BiWeekly\n4. Weekly\n: ");
        PayFrequency = scan.nextInt();
        totalHours = setTotalHours(PayFrequency);
        return totalHours;
    }
    protected Double setTotalHours(int PayFrequency) {
        switch (PayFrequency) {
            case 1:
                System.out.print("\nMonthly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                System.out.print("Third week hours: ");
                hoursThirdWeek = scan.nextDouble();
                System.out.print("Fourth week hours: ");
                hoursFourthWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek + hoursThirdWeek + hoursFourthWeek;
                break;
            case 2:
                System.out.print("\nSemiMonthly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 3:
                System.out.print("\nBiWeekly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 4:
                System.out.print("\nWeekly paychecks.\nTotal week hours: ");
                hoursFirstWeek = scan.nextDouble();
                totalHours = hoursFirstWeek;
                break;
        }
        System.out.println("Your total work hours are " + totalHours);
        return totalHours;
    }
}