package com.abiraj.secondassignment.ui.Plaindrome;

public class PlaindromeClass {

    public int reverse = 0, rem;

    public int reverse(int n) {

        while (n != 0) {
            rem = n % 10;
            reverse = reverse * 10 + rem;
            n = n / 10;
        }

        return (reverse);
    }
}

