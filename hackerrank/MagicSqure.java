package hackerrank;

import java.util.Arrays;
import java.util.OptionalInt;

public class MagicSqure {
    public static void main(String[] args) {
        /*int[][] matrix = {{5,3,4},
                          {1,5,8},
                          {6,4,2}};*/
        int[][] matrix = {
                {5,8},
            {4,2}};
        makeMagicMatrix(matrix);
        printMatrix(matrix);
    }

    private static void makeMagicMatrix(int[][] matrix) {
        int n = matrix.length;

        // Calculate the target sum for each row and column without modifying the matrix
        int[] targetRowDiff = new int[n];
        int[] targetColDiff = new int[n];
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        rowSum[0] = 14;
        rowSum[1]=9;
        colSum[0] =12;
        colSum[1] =11;
        // Calculate the cost and update the matrix
        int cost = 0;
        for (int i = 0; i < n; i++) {
            int rowCost = Math.abs(rowSum[i] - Arrays.stream(matrix[i]).sum());
            targetRowDiff[i] = rowCost;
            System.out.println("rowCost after iteration " + (i + 1) + ": " + rowCost);

            /*for (int j = 0; j < n; j++) {
                matrix[i][j] += rowCost; // Update the row to meet the target sum
            }*/
        }

        for (int j = 0; j < n; j++) {
            final int colIndex = j; // Declare a final variable for use in the lambda expression
            int colCost = Math.abs(colSum[j] - Arrays.stream(matrix).mapToInt(row -> row[colIndex]).sum());
            targetColDiff[j] = colCost;
            System.out.println("colCost after iteration " + (j + 1) + ": " + colCost);
        }

        System.out.println("Minimum cost to make a magic matrix: " + cost);
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
