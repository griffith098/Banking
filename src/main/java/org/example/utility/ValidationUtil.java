package org.example.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    
    // Validate an email address
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Check if a password meets strength requirements
    public static boolean isStrongPassword(String password) {
        // Minimum 8 characters, at least one letter, one number, and one special character
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Validate if a number is positive
    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }
}