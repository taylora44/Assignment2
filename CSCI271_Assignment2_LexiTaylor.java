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

    public CSCI271_Assignment2_LexiTaylor(long n, long d) {

        if (n == 0 && d == 0) { //this if statement is for if both the numerator and denominator are 0
            numerator = 0;
            denominator = 0;
            return;
        }

        if (d < 0) { //this if statement is for if the denominator is negative
            n = -n;
            d = -d;
        }

        if (d == 0) { //this entire if statement is for if the denominator is 0
            if (n > 0) { //if n is greater than 0 it will be negative infinity
                numerator = 1;
            } else { //if n is less than 0 it will be negative infinity
                numerator = -1;
            }
            denominator = 0;
            return;
        }

        long g = gcd(n, d); //g is for greatest common denominator
        n /= g; //this divides the numerator with the greatest common factor
        d /= g; //this divides the denominator with the greatest common factor
        if (n == 0) d = 1; //this is for if the numerator is 0 it will automatically make the denominator 1
        numerator = n;
        denominator = d;
    }

    public CSCI271_Assignment2_LexiTaylor(long wholenumber) {
        this (wholenumber, 1L); //this makes it so the constructor is in the same class
    }

    public String toString() {
        if (numerator == 0 && denominator == 0) { //if statement is for if the number is "not a number"
            return "NaN";
        }

        if (denominator == 0) {
            if (numerator > 0) { //if the denominator is 0 and numerator is above 0 it is postitive infinity
                return "Infinity";
            }
            if (numerator < 0) { //if the denominator is 0 and numerator is below 0 it is negative infinity
                return "-Infinity";
            }
        }

        if (denominator == 1) { //if the denominator is 1 it will return the numerator as a string
             return Long.toString(numerator);
        }
        return numerator + "/" + denominator; //returns a fraction
    }

    public CSCI271_Assignment2_LexiTaylor add(CSCI271_Assignment2_LexiTaylor f) { //adding fractions
        long a = this.numerator;
        long b = this.denominator;
        long c = f.numerator;
        long d = f.denominator;
        long newNumerator = a * d + b * c; //multiply the numerators by opposite denominator then add together to get the new numerator
        long newDenominator = b * d; //multiply denominators together for the new denominator
        return new CSCI271_Assignment2_LexiTaylor(newNumerator, newDenominator);
        }

    public CSCI271_Assignment2_LexiTaylor subtract(CSCI271_Assignment2_LexiTaylor f) { //subtracting fractions
        return this.add(f.negate()); //subtracting fractions
    }

    public CSCI271_Assignment2_LexiTaylor multiply(CSCI271_Assignment2_LexiTaylor f) { //multiplying fractions
        long a = this.numerator;
        long b = this.denominator;
        long c = f.numerator;
        long d = f.denominator;
        long newNumerator = a * c; //multiplying numerators
        long newDenominator = b * d; //multiplying denominators
        return new CSCI271_Assignment2_LexiTaylor(newNumerator, newDenominator);
    }

    public CSCI271_Assignment2_LexiTaylor divide(CSCI271_Assignment2_LexiTaylor f) { //dividing fractions
        long a = this.numerator;
        long b = this.denominator;
        long c = f.numerator;
        long d = f.denominator;
        long newNumerator = a * d; //multiplying numerator with opposite denominator
        long newDenominator = b * c; //multiplying denominator with opposite numerator
        return new CSCI271_Assignment2_LexiTaylor(newNumerator, newDenominator);
    }

    public CSCI271_Assignment2_LexiTaylor negate() { //makes the fraction negative
        return new CSCI271_Assignment2_LexiTaylor(-numerator, denominator);
    }

    public CSCI271_Assignment2_LexiTaylor pow(int n) { //raises fraction to a power
        if (n == 0) { //if a fraction is being raised to the 0 power that equals 1
            return new CSCI271_Assignment2_LexiTaylor(1, 1);
        }
        if (n < 0) { //if it is a negative exponent it flips the fraction
            CSCI271_Assignment2_LexiTaylor reciprocal = new CSCI271_Assignment2_LexiTaylor(denominator, numerator);
            return reciprocal.pow(-n);
        }
        long newNumerator = 1;
        long newDenominator = 1;
        long baseNumerator = numerator;
        long baseDenominator = denominator;
        int exp = n;
        while (exp > 0) {
            if ((exp & 1) == 1) { //if exponent is odd...
                newNumerator *= baseNumerator; //multiply result by current
                newDenominator *= baseDenominator;
            }
            baseNumerator *= baseNumerator; //base = base * base
            baseDenominator *= baseDenominator;
            exp >>= 1; //exponent = exponent/2
        }
        return new CSCI271_Assignment2_LexiTaylor(newNumerator, newDenominator);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numerator: "); //asking user for a fraction
        long n = input.nextLong();
        System.out.print("Enter denominator: ");
        long d = input.nextLong();
        CSCI271_Assignment2_LexiTaylor f = new CSCI271_Assignment2_LexiTaylor(n, d);

        System.out.println("Fraction: " + f);
        CSCI271_Assignment2_LexiTaylor f1 = new CSCI271_Assignment2_LexiTaylor(n, d); //creates fraction
        CSCI271_Assignment2_LexiTaylor f2 = new CSCI271_Assignment2_LexiTaylor(n, d);

        System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
        System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
        System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
        System.out.println("negate(" + f1 + ") = " + f1.negate());
        System.out.println("(" + f1 + ")^2 = " + f1.pow(2));
        input.close();
    }
}
