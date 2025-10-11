package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();

        String targ = "ab";
        int i = 0; // counter
        int j = 0; // index

        while (j != -1) {
            j = input.indexOf(targ, j);
            if (j != -1) {
                i++;
                j += targ.length();
            }
        }

        System.out.println(i);
    }
}

//  loop counts how many times the substring appears in the input string.

/*
String str = "helloslkhellodjladfjhello";
String findStr = "hello";

System.out.println(StringUtils.countMatches(str, findStr));
 */