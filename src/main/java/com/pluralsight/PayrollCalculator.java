package com.pluralsight;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the name of the employee file to process: ");
            String employeeFile = scanner.next();
            FileReader fileReader = new FileReader("src/main/resources/" + employeeFile.trim().replaceAll("\\s", ""));
            BufferedReader bufReader = new BufferedReader(fileReader);

            System.out.print("Enter the name of the payroll file to create: ");
            String fileName = scanner.next();
            FileWriter fileWriter = new FileWriter("src/main/resources/" + fileName.trim().replaceAll("\\s", ""), true);

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("id|name|gross pay\n");
            String input;
            bufReader.readLine();


            while ((input = bufReader.readLine()) != null) {
                String[] words = input.split("\\|");
                int employeeId = Integer.parseInt(words[0]);
                String name = words[1];
                double hoursWorked = Double.parseDouble(words[2]);
                double payRate = Double.parseDouble(words[3]);


                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                double grossPay = employee.getGrossPay();


                //saving the file


                bufWriter.write(employee.getEmployeeId() + "|");
                bufWriter.write(employee.getName());
                bufWriter.write("|");
                bufWriter.write(Double.toString(grossPay));
                bufWriter.newLine();


            }
            bufWriter.close();

            bufReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

