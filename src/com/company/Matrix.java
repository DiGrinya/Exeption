package com.company;

import java.text.DecimalFormat;

public class Matrix {


    private double[][] arr;

    public Matrix(int row, int column) {

        this.arr = new double [column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = 0.0;
            }
        }
    }

    public Matrix(double[][] twoDimensionalArray) throws MatrixException {

        this.arr = twoDimensionalArray;
        if(rows()==0) throw new MatrixException("Array passed with zero number of rows");
        if(arr[0].length==0) throw new MatrixException("Array passed with zero number of columns");


    }

    public final int rows() {
        return arr.length;
    }

    public final int columns() {

        return arr[0].length;
    }

    public double[][] twoDimensionalArrayOutOfMatrix() {

        return this.arr;

    }


    public double getValue(int row, int column) throws MatrixException {
            if (arr == null) {
            throw new IllegalArgumentException();
            }
            if (row >= arr.length || column >= arr[0].length) {
                throw new MatrixException("Incompatible matrix sizes");
            }
            return arr[row][column];
        }


    public void setValue(int row, int column, double newValue) throws MatrixException {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        if (row >= arr.length || column >= arr[0].length) {
            throw new MatrixException("Incompatible matrix sizes");
        }
        arr[row][column]=newValue;
        }

        public Matrix addition(Matrix matrix) throws MatrixException {

            if (matrix.columns() != arr[0].length || matrix.rows() != arr.length) {
                throw new MatrixException("Incompatible matrix sizes");
            }
            Matrix tmp = new Matrix(arr);

            for (int i = 0; i < arr.length ; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] += matrix.getValue(i,j);
                }
            }
        return tmp;
    }


    public Matrix subtraction(final Matrix matrix) throws MatrixException {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }
        if (matrix.columns() != arr[0].length || matrix.rows() != arr.length) {
            throw new MatrixException("Incompatible matrix sizes");
        }
        Matrix tmp = new Matrix(arr);

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] -= matrix.getValue(i,j);
            }
        }
        return tmp;
    }

    public Matrix multiplication(final Matrix matrix) throws MatrixException {
        if(arr[0].length != matrix.rows()){
            throw new MatrixException("Incompatible matrix sizes");
        }
        double[][] temp = new double[matrix.rows()][matrix.columns()];
        for (int i = 0; i < matrix.rows(); ++i) {
            for (int j = 0; j < matrix.columns(); ++j) {
                for (int k = 0; k < matrix.rows(); ++k)
                    temp[i][j] += this.arr[i][k] * matrix.getValue(k,j);
            }
        }
        return new Matrix(temp);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.columns(); j++) {
                try {
                    if (j != this.columns() - 1) {
                        builder.append(decimalFormat.format(getValue(i, j)) + " ");
                    } else {
                        builder.append(decimalFormat.format(getValue(i, j)));
                    }
                } catch (MatrixException e) {
                    e.getMessage();
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
