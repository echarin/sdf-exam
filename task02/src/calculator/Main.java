package calculator;

import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Console cons = System.console();
        String input = "";
        float result = 0.0f;

        System.out.println("Welcome.");
        while (true) {
            input = cons.readLine("> ");

            if (input.matches("exit")) {
                System.out.print("Bye bye");
                System.exit(0);
            }
        
            input = input.trim().toLowerCase();
            String[] inputs = input.split(" ");

            if (inputs.length != 3) {
                System.out.println("Format: operand operator operand");
                continue;
            }
            
            Set<String> operators = new HashSet<>(Arrays.asList(Constants.OPERATORS));
            String operator = inputs[1]; 
            if (!(operators.contains(operator))) {
                System.out.println("Incorrect operator: only accepts +, -, /, *");
                continue;
            }

            float operand1, operand2;
            String operandStr1 = inputs[0], operandStr2 = inputs[2];
            if (operandStr1.equalsIgnoreCase(Constants.LAST)) {
                operand1 = result;
            } else {
                try {
                    operand1 = Float.parseFloat(inputs[0]);
                } catch (NumberFormatException ex) {
                    System.out.println("Operands must be floats");
                    continue;
                }
            }

            if (operandStr2.equalsIgnoreCase(Constants.LAST)) {
                operand2 = result;
            } else {
                try {
                    operand2 = Float.parseFloat(inputs[2]);
                } catch (NumberFormatException ex) {
                    System.out.println("Operands must be floats");
                    continue;
                }
            }

            if (Float.isNaN(operand1) || Float.isNaN(operand2)) {
                System.out.println("Operand was not a number");
                continue;
            }
            
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
            }

            if (result % 1 == 0) {
                System.out.printf("%s\n", (int) result);
            } else {
                System.out.printf("%s\n", result);
            }
        }
    }
}
