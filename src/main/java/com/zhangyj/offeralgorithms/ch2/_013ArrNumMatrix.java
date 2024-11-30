package com.zhangyj.offeralgorithms.ch2;

/**
 * 题目：二维子矩阵的和
 * 输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵数字之和？
 * 对同一个二维矩阵，计算子矩阵数字之和的函数可能输入不同的坐标而被反复调用多次。
 * 例如输入图2.1中的二维矩阵，以及左上角坐标为(2, 1)和右下角坐标为(4, 3)，该函数输出8
 *
 * 思路：先求出二维矩阵累加和（左上角均为(0,0)），再通过矩阵累加和计算即可
 */
public class _013ArrNumMatrix {
    public static void main(String[] args) {
        int[][] sums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        _013ArrNumMatrix numMatrix = new _013ArrNumMatrix(sums);
        System.out.println(numMatrix.sumRegion(1,1,2,1));
    }

    private int[][] sums ;

    public _013ArrNumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // 如果输入矩阵的行数和列数分别是m和n，那么辅助数组sums的行数和列数分别为m+1和n+1，这样只是为了简化代码逻辑。
        // 如果用公式sums[r2][c2]+sums[r1-1][c2]-sums[r2][c1-1]+sums[r1-1][c1-1]求解
        // 左上角坐标为（r1，c1）、右下角坐标为（r2，c2）的子矩阵的数字之和，由于坐标值r1或c1有可能等于0，
        // 因此r1-1或c1-1可能是负数，不再是有效的数组下标。
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; ++i) {
            int rowSum = 0;
            for (int j = 0; j < matrix[0].length; ++j) {
                rowSum += matrix[i][j];
                // 将矩阵值看为两部分 一部分是矩阵值[x-1,y]的值，另一部分是行的累加值 牛逼
                sums[i + 1][j + 1] = sums[i][j + 1] + rowSum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 转化为左上角君为为(0,0)的矩阵差值
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1]
                - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
