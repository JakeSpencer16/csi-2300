import java.util.Arrays;
import java.util.Random;

public class bubble_vs_merge {
     public static void main(String[] args) {
        // Generate random array for testing
        int[] arr = generateRandomArray(10000);

        // Create copies of the array for both sorting methods
        int[] mergeSortArr = Arrays.copyOf(arr, arr.length);
        int[] bubbleSortArr = Arrays.copyOf(arr, arr.length);

        
        long startTime = System.nanoTime();
        mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        long endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime; // tottal time for merge sort

        startTime = System.nanoTime();
        bubbleSort(bubbleSortArr);
        endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime; // tottal time for bubble sort

        // Print results
        System.out.println("Merge Sort Time: " + mergeSortTime + " nanoseconds");
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " nanoseconds");

    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    // code for the merge sort
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Helper function to generate a random array
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000); // Generate random numbers between 0 and 9999
        }
        return arr;
    }

    // Function to ensure the array has no issues for this test
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
