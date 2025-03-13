import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class bubble_sort {

// Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength){
        int[] randomArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = (int) (Math.random() * 101); // Generate random numbers between 0 and 100
        }
        return randomArray;

    }

 
// Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename){
        try (FileWriter fileWriter = new FileWriter(filename)) {
            for (int number : array) {
                fileWriter.write(number + "\n"); // writes each number on a new line
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

 

// This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename){
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            int count = 0;
            while (fileScanner.hasNextInt()) {
                count++;
                fileScanner.nextInt(); // Count the number of integers in the file
            }

            int[] array = new int[count];

            for (int i = 0; i < count; i++) {
                array[i] = fileScanner.nextInt(); // Read each integer from the file
            }
            return array;
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            return null; // Return null if there's an error
        }
    }


// Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
    public static void bubbleSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args){
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Choose an option:");
            System.out.println("1. Generate a random array and store it in a file");
            System.out.println("2. Read an existing file, sort it, and store the sorted array");
            System.out.println("3. Exit");
            
            int choice = scan.nextInt();
            
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the desired length of the array: ");
                    int arrayLength = scan.nextInt();
                    int[] randomArray = createRandomArray(arrayLength);
                    System.out.print("Enter the filename to store the array: ");
                    String filename = scan.next();
                    writeArrayToFile(randomArray, filename);
                    System.out.println("Random array generated and stored in " + filename);
                }
                case 2 -> {
                    System.out.print("Enter the filename to read from: ");
                    String inputFilename = scan.next();
                    int[] inputArray = readFileToArray(inputFilename);
                    if (inputArray != null) {
                        bubbleSort(inputArray);
                        System.out.print("Enter the filename to store the sorted array: ");
                        String outputFilename = scan.next();
                        writeArrayToFile(inputArray, outputFilename);
                        System.out.println("Array read from " + inputFilename + ", sorted, and stored in " + outputFilename);
                    }
                }
                case 3 -> System.out.println("Exiting the program.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
 
}
