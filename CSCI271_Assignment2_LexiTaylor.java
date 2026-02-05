/*************************************************************************
* Assignment 2 for CSCI 271-001 Spring 2026
*
* Author: Lexi Taylor
* OS: Windows 11
* Compiler: javac 25.0.1
* Date: February 06, 2026
*
* Purpose
* A program that computes exact arithmic calculations.
*
*************************************************************************/
import java.util.Scanner;

public class CSCI271_Assignment2_LexiTaylor {
    private long numerator;
    private long denominator;

    public long getNumerator() {
        return numerator;
    }
    public long getDenominator() {
        return denominator;
    }

    private long gcd (long a, long b) {
        if (a < 0) a = -a;
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        if (a == 0) a = 1;
        return a;
    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        long num1 = input.nextLong();
        System.out.print("Enter second number: ");
        long num2 = input.nextLong();

        CSCI271_Assignment2_LexiTaylor GCDCalc = new CSCI271_Assignment2_LexiTaylor();
        long result = GCDCalc.gcd(num1, num2);

        System.out.println("GCD(" + num1 + "," + num2 + ") = " + result);
        input.close();
    }

    public CSCI271_Assignment2_LexiTaylor(long n, long d) {
        numerator = n;
        denominator = d;

        if (denominator == 0) {
            numerator = n;
            denominator = 0;
            return;
        }
        if (denominator < 0) {
            n = -n;
            d = -d;
        }
        long g = gcd(Math.abs(n), d);
        numerator /= g;
        denominator /= g;
    }
    public CSCI271_Assignment2_LexiTaylor(long wholenumber) {
        this(wholenumber, 1L);
    }
    public string toString() {
        if (denominator == 0) {
            if (numerator > 0) {
                return "Infinity";
            }
            if (numerator < 0) {
                return "Negative Infinity";
            }
            return "Not a Number";
        }
        if (denominator == 1) {
            return " " + numerator;
        }
        return numerator + "/" + denominator;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number 1: ");
        long number1 = input.nextLong();
        System.out.print("Number 2: ");
        long number2 = input.nextLong();
        CSCI271_Assignment2_LexiTaylor gcdTest = new CSCI271_Assignment2_LexiTaylor();
        System.out.println("GCD(" + number1 + "," + number2 + ") = " + gcdTest.gcd(number1, number2));

        System.out.print("Fraction number: ");
        long fn = input.nextLong();
        System.out.print("Fraction denominator: ");
        long fd = input.nextLong();
        CSCI_Assignment2_LexiTaylor fracTest = new CSCI_Assignment2_LexiTaylor(fn, fd);
        System.out.println("Fraction: " + fractTest.toString());
        input.close();
    }
}
