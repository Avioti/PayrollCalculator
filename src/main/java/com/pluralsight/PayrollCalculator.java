package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PayrollCalculator {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;
            bufReader.readLine();


            while ((input = bufReader.readLine()) != null) {
                String[] words = input.split("\\|");


                int employeeId = Integer.parseInt(words[0]);
                String name = words[1];
                double hoursWorked = Double.parseDouble(words[2]);
                double payRate = Double.parseDouble(words[3]);


                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);


                System.out.printf("Employee ID: %d, Name: %s, GrossPay: $%.2f%n", employee.getEmployeeId(), employee.getName(), employee.getGrossPay(payRate, hoursWorked));


            }

            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

