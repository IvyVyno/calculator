package com.alevel;

import com.alevel.calculator.PostfixCalculator;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the expression: ");
        String calculatingString = s.nextLine();
        System.out.println("Result is: ");
        System.out.println(new PostfixCalculator(calculatingString).calculate());
    }
}
