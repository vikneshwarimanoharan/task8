package task8;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your birthday (YYYY-MM-DD): ");
        String birthdayString = scanner.nextLine();
        scanner.close();

        try {
            LocalDate birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate today = LocalDate.now();

            if (birthday.isAfter(today)) {
                System.out.println("Birthday must be before today's date.");
            } else {
                Period age = Period.between(birthday, today);
                System.out.printf("You are %d years, %d months, and %d days old.%n", 
                                  age.getYears(), age.getMonths(), age.getDays());
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
        }
    }
}

