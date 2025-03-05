package com.arrays;
import java.util.Scanner;

public class IncomeTaxSlab {
    public static double calculateTax(double salary) {
        double tax = 0.0;

        if (salary <= 1200000) {
            tax = 0;
        } else if (salary > 1200000 && salary < 1600000) {
            tax = salary * 0.15;
        } else if (salary > 1600000 && salary < 2000000) {
            tax = salary * 0.2;
        } else if (salary > 2000000 && salary < 2400000) {
            tax = salary * 0.25;
        } else if (salary > 2400000) {
            tax = salary * 0.3;
        }

        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your salary: ");
        double salary = scanner.nextDouble();
        scanner.close();

        double tax = calculateTax(salary);
        System.out.println("Income Tax Applicable: Rs. " + tax);
    }
}