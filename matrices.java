
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class matrices {

    @SuppressWarnings("ConvertToTryWithResources") // to stop vscode from complaing about my scanner
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (args.length == 2) {
            // Process two file names from command line arguments
            processFiles(args[0], args[1]);
        } 
        else if (args.length == 1 && isInteger(args[0])) {
            // Process an integer from command line argument
            int size = Integer.parseInt(args[0]);
            generateAndMultiplyMatrices(size);
        } 
        else{
            System.out.println("Enter two file names or an integer:"); // Get user input
            String input = scan.nextLine();

            if (input.contains(" ")) {
                // Process two file names from user input
                String[] fileNames = input.split(" ");
                processFiles(fileNames[0], fileNames[1]);
            } else if (isInteger(input)) {
                // Process an integer from user input
                int size = Integer.parseInt(input);
                generateAndMultiplyMatrices(size);
            } else {
                System.out.println("Invalid input. Please enter two file names or an integer.");
            }
        }
        scan.close();
    }

    private static void processFiles(String fileName1, String fileName2) {
        int[][] matrix1 = readMatrixFromFile(fileName1);
        int[][] matrix2 = readMatrixFromFile(fileName2);

        if (matrix1[0].length != matrix2.length) {
            System.out.println("Matrix multiplication not possible: Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        int[][] result = multiplyMatrices(matrix1, matrix2);
        writeMatrixToFile("matrix3.txt", result);
    }

    private static void generateAndMultiplyMatrices(int size) {
        int[][] matrix1 = generateRandomMatrix(size);
        int[][] matrix2 = generateRandomMatrix(size);

        writeMatrixToFile("matrix1.txt", matrix1);
        writeMatrixToFile("matrix2.txt", matrix2);

        int[][] result = multiplyMatrices(matrix1, matrix2);
        writeMatrixToFile("matrix3.txt", result);
    }

    private static int[][] readMatrixFromFile(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            int rows = fileScanner.nextInt();
            int cols = fileScanner.nextInt();
            int[][] matrix = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = fileScanner.nextInt();
                }
            }

            return matrix;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return null;
        }
    }

    private static int[][] generateRandomMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 100); // Generate random numbers between 0 and 99
            }
        }
        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    private static void writeMatrixToFile(String fileName, int[][] matrix) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(matrix.length + " " + matrix[0].length + "\n");
            for (int[] matrix1 : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    fileWriter.write(matrix1[j] + " ");
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

