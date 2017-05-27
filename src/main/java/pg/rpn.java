/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author Plamen
 */
public class rpn {
    
 private static final Stack<Integer> stack = new Stack();

    public static void calculator(String input) {
        String[] inputArray = input.split(" ");

        for (String op : inputArray) {
            try {
                Integer number = Integer.parseInt(op);
                stack.push(number);
            } catch (NumberFormatException ex) {
                Integer lastpos = stack.pop();
                Integer newpos = stack.peek();
                
                switch (op) {
                    case "+":
                        stack.set(stack.size() - 1, lastpos + newpos);
                        break;
                    case "-":
                        stack.set(stack.size() - 1, lastpos - newpos);
                        break;
                    case "*":
                        stack.set(stack.size() - 1, lastpos * newpos);
                        break;
                    case "/":
                        stack.set(stack.size() - 1, lastpos / newpos);
                        break;
                }
            }
        }

        stack.stream().forEach((op) -> {
            System.out.println(">" + op);
     });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!input.equalsIgnoreCase("exit")) {
            calculator(input);
            input = sc.nextLine();
        }
    }

}
