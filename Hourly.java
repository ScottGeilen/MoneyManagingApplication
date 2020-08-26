public class Hourly {
    static Scanner scan = new Scanner(System.in);
    private double wage;
    private int payFrequency;
    private double totalHours;

    private double Wage() {
        System.out.print("Hourly wage: $");
        this.wage = scan.nextDouble();
    }

    private double getWage() {
        return this.wage;
    }

    private int PayFrequency() {
        System.out.print("What is your pay frequency?\n1. Monthly\n2. SemiMonthly\n3. BiWeekly\n4. Weekly\n: ");
        this.payFrequency = scan.nextInt();
    }

    public int getPayFrequency() {
        return this.payFrequency;
    }

    private double calculateHours() {
        PayFrequency frequency = new PayFrequency();
        int payFrequency = frequency.getPayFrequency();

        double totalHours = 0.00;
        switch (payFrequency) {
            case 1:
                System.out.print("Monthly paychecks.\nFirst week hours: ");
                double hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                double hoursSecondWeek = scan.nextDouble();
                System.out.print("Third week hours: ");
                double hoursThirdWeek = scan.nextDouble();
                System.out.print("Fourth week hours: ");
                double hoursFourthWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek + hoursThirdWeek + hoursFourthWeek;
                break;
            case 2:
                System.out.print("SemiMonthly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 3:
                System.out.print("BiWeekly paychecks.\nFirst week hours: ");
                hoursFirstWeek = scan.nextDouble();
                System.out.print("Second week hours: ");
                hoursSecondWeek = scan.nextDouble();
                totalHours = hoursFirstWeek + hoursSecondWeek;
                break;
            case 4:
                System.out.print("Weekly paychecks.\nTotal week hours: ");
                hoursFirstWeek = scan.nextDouble();
                totalHours = hoursFirstWeek;
                break;
        }
        return totalHours;
    }
    public double getHours() {
        return this.totalHours;
    }
}