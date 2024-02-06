package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExtractor {

  /*  private static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";

    public List<String> extractEmails(String inputText) {
        List<String> emails = new ArrayList<>();

        if (inputText != null && !inputText.isEmpty()) {
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(inputText);

            while (matcher.find()) {
                emails.add(matcher.group());
            }
        }

        return emails;
    }*/

    public static List<String> extractEmails(String inputText, String customRegex) {
        List<String> emails = new ArrayList<>();

        if (inputText != null && !inputText.isEmpty() && customRegex != null && !customRegex.isEmpty()) {
            Pattern pattern = Pattern.compile(customRegex);
            Matcher matcher = pattern.matcher(inputText);

            while (matcher.find()) {
                emails.add(matcher.group());
            }
        }

        return emails;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String inputText = scanner.nextLine().trim();

        List<String> extractedEmails;

        // Check if a custom regex is provided in the input text
        String customRegexPrefix = "regex=";
        if (inputText.startsWith(customRegexPrefix)) {
            String customRegex = inputText.substring(customRegexPrefix.length()).trim();
            extractedEmails = extractEmails(inputText, customRegex);
        } else {
            // Default regex for emails
            String defaultRegex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
            extractedEmails = extractEmails(inputText, defaultRegex);
        }

        System.out.println("Extracted emails:");
        for (String email : extractedEmails) {
            System.out.println(email);
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

}
