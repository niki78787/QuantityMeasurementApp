package org.example;

import java.util.Scanner;

class QuantityLength {

    // Method to take input, convert, and compare
    boolean compareLength() {

        Scanner sc = new Scanner(System.in); //create scanner to read user  i/p

        // 1. User inputs values and units
        System.out.print("Enter first value: ");
        double value1 = sc.nextDouble();

        System.out.print("Enter first unit (feet/inch): ");
        String unit1 = sc.next();

        System.out.print("Enter second value: ");
        double value2 = sc.nextDouble();

        System.out.print("Enter second unit (feet/inch): ");
        String unit2 = sc.next();

        // 2 & 3. Validate unit
        if (!isValidUnit(unit1) || !isValidUnit(unit2)) { //check if unit is valid
            System.out.println("Invalid unit entered");
            return false;
        }

        // 4. Convert to feet
        double valueInFeet1 = convertToFeet(value1, unit1); //convert value1 into feet
        double valueInFeet2 = convertToFeet(value2, unit2);

        // 5. Compare
        return valueInFeet1 == valueInFeet2; //compare both n return value based on condition like true or false
    }

    // Validate supported units
    boolean isValidUnit(String unit) {
        return unit.equalsIgnoreCase("feet") || unit.equalsIgnoreCase("inch");
    }

    // Convert to base unit (feet)
    double convertToFeet(double value, String unit) {
        if (unit.equalsIgnoreCase("inch")) {
            return value / 12;
        }
        return value; // already feet
    }
}


public class QuantityMeasurementAppUC3 {

    public static void main(String[] args) {

        QuantityLength length = new QuantityLength();

        // Call method
        boolean result = length.compareLength();

        // 6. Show result
        if (result) {
            System.out.println("Both lengths are EQUAL");
        } else {
            System.out.println("Both lengths are NOT equal");
        }
    }
}

//import scanner class, we can take i/p from the user using keyboard
//method return boolen(true for eqauls or false for not equals)
//