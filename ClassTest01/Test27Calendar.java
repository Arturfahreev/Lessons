import java.util.Scanner;

public class Test27Calendar {
    public static void main(String[] args) {
        /* Scanner sc = new Scanner(System.in);
        System.out.println("Input day: ");
        int day = sc.nextInt();
        System.out.println("Input month: ");
        int month = sc.nextInt();
        System.out.println("Input year: ");
        int year = sc.nextInt(); */
        int day = 0, month = 0, year = 0;


        for (int i = 1; i < 35; i++) {
            day = i;
            month = i;
            year = i;
            if (isDateIsValid(day, month, year)) {
                printNextDay(day, month, year);
            } else System.out.println("Date is not correct");
        }
    }

    public static boolean isDateIsValid (int day, int month, int year) {
        boolean result = false;
        if (day <= 0 || month <= 0 || month > 12 || year <= 0 ) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                result = day <= 29;
            } else {
                result = day <= 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            result = day <= 30;
        } else {
            result = day <= 31;
        }
        return result;
    }

    public static void printNextDay (int day, int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day == 29) {
                    System.out.println(formatDate(1, month + 1, year));
                }
                else {
                    System.out.println(formatDate(day + 1, month, year));
                }
            } else if (day == 28) {
                System.out.println(formatDate(1, month + 1, year));
            } else {
                System.out.println(formatDate(day + 1, month, year));
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day == 30) {
                System.out.println(formatDate(1, month + 1, year));
            } else {
                System.out.println(formatDate(day + 1, month, year));
            }
        } else {
            if (day == 31) {
                if (month == 12) {
                    System.out.println(formatDate(1, 1, year + 1));
                } else {
                    System.out.println(formatDate(1, month + 1, year));
                }
            } else {
                System.out.println(formatDate(day + 1, month, year));
            }
        }

    }

    public static String formatDate (int day, int month, int year) {
        return "Next day: " + day + "." + month + "." + year;
    }

    public static boolean isLeapYear (int year) {
        return (year % 400 == 0) || ((year % 4 == 0) & (year % 100 != 0));
    }
}
