package com.company;

public class Main {

    public static void main(String[] args) throws MatrixException {

        double [][]arr = {  {0, 2.1, 2.2},
                            {3, 3.1, 3.2},
                            {4, 4.1, 4.2},
                            };


        Matrix matrix = new Matrix(arr);

        System.out.println(matrix);

    }
}
