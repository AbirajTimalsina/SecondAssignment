package com.abiraj.secondassignment.ui.AutoMorphic;

public class AutoMorphicClass {

    public int auto(int n){
        int square = n*n;

        while(n>0) {

            if ((n % 10) == (square % 10)) {

                n = n / 10;
                square = square / 10;
            }

            else {

                break;
            }
        }
        return n;
    }
}
