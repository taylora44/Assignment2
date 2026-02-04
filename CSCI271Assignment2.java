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

    private long gcf (long a, long b) {
        if (a < 0) = -a;
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }
        if (a == 0) a = 1;
        return a;
    }
