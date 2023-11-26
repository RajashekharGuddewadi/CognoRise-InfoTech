package Task3_CalculatorApp;

import java.util.Scanner;

public class arithemetic_Opreation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Enter the operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                   
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operator. Please enter +, -, *, or /.");
            }
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
          
            scanner.close();
        }

	}

}
