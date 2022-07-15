/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class inputValidation {
    private static final Scanner sc = new Scanner(System.in);

    public static int Int() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return Int();
        }
    }

    public static String string() {
        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return string();
        }
    }
}
