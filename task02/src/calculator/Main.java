package calculator;

import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        

        Console cons = System.console();

        while (true) {
            String input = cons.readLine("> ");
            if (input.matches("exit")) {
                break;
            }
        
            input = input.trim().toLowerCase();
            String[] inputs = input.split(" ");

            // Input validation
            // Check if a x b format is followed
            if (inputs.length != 3) {
                System.out.println("Format: operand operator operand");
                continue;
            }
            
            // Check if operator is valid
            Set<String> operators = new HashSet<>(Arrays.asList("+", "/", "*", "-"));
            String operator = inputs[1]; 
            if (!(operators.contains(operator))) {
                System.out.println("Incorrect operator: only accepts +, -, /, *");
                continue;
            }

            // Check if operands are floats
            Float operand1, operand2 = 0f;
            try {
                operand1 = Float.parseFloat(inputs[0]);
                operand2 = Float.parseFloat(inputs[2]);
            } catch (NumberFormatException ex) {
                System.out.println("Operands must be floats");
                continue;
            }

            if (Float.isNaN(operand1) || Float.isNaN(operand2)) {
                System.out.println("Operand was not a number");
                continue;
            }

            Float result = 0.0f;
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

            System.out.printf("> Answer: %s\n", result);
        }
    }
}
