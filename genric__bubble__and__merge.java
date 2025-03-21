import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;


public class genric__bubble__and__merge {
   
        public static void main(String[] args) {
            // Generate random arrays for testing
            Integer[] intArr = generateRandomArray(10000, Integer.class);
            Double[] doubleArr = generateRandomArray(10000, Double.class);
    
            // Create copies of the arrays for both sorting methods
            Integer[] mergeSortIntArr = Arrays.copyOf(intArr, intArr.length);
            Integer[] bubbleSortIntArr = Arrays.copyOf(intArr, intArr.length);
    
            Double[] mergeSortDoubleArr = Arrays.copyOf(doubleArr, doubleArr.length);
            Double[] bubbleSortDoubleArr = Arrays.copyOf(doubleArr, doubleArr.length);
    
            // Integer Sorting
            long startTime = System.nanoTime();
            mergeSort(mergeSortIntArr, 0, mergeSortIntArr.length - 1);
            long endTime = System.nanoTime();
            long mergeSortTime = endTime - startTime; // total time for merge sort
    
            startTime = System.nanoTime();
            bubbleSort(bubbleSortIntArr);
            endTime = System.nanoTime();
            long bubbleSortTime = endTime - startTime; // total time for bubble sort
    
            // Print results for Integer
            System.out.println("Integer Merge Sort Time: " + mergeSortTime + " nanoseconds");
            System.out.println("Integer Bubble Sort Time: " + bubbleSortTime + " nanoseconds");
    
            // Double Sorting
            startTime = System.nanoTime();
            mergeSort(mergeSortDoubleArr, 0, mergeSortDoubleArr.length - 1);
            endTime = System.nanoTime();
            mergeSortTime = endTime - startTime; // total time for merge sort
    
            startTime = System.nanoTime();
            bubbleSort(bubbleSortDoubleArr);
            endTime = System.nanoTime();
            bubbleSortTime = endTime - startTime; // total time for bubble sort
    
            // Print results for Double
            System.out.println("Double Merge Sort Time: " + mergeSortTime + " nanoseconds");
            System.out.println("Double Bubble Sort Time: " + bubbleSortTime + " nanoseconds");
    
        }
    
        // Generic Merge Sort implementation
        public static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);
                merge(arr, left, mid, right);
            }
        }
    
        // Generic code for the merge sort
        @SuppressWarnings("unchecked")
        public static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;
    
            T[] L = (T[]) new Comparable[n1];
            T[] R = (T[]) new Comparable[n2];
    
            for (int i = 0; i < n1; i++) {
                L[i] = arr[left + i];
            }
            for (int j = 0; j < n2; j++) {
                R[j] = arr[mid + 1 + j];
            }
    
            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (L[i].compareTo(R[j]) <= 0) {
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
    
        // Generic Bubble Sort implementation
        public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        // Swap elements
                        T temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    
        // Helper function to generate a random array of any type
        @SuppressWarnings({"unchecked", "UnnecessaryBoxing"})
        public static <T> T[] generateRandomArray(int size, Class<T> type) {
            Random random = new Random();
            T[] arr = (T[]) Array.newInstance(type, size);
            if (type == Integer.class) {
                for (int i = 0; i < size; i++) {
                    arr[i] = (T) Integer.valueOf(random.nextInt(10000));
                }
            } else if (type == Double.class) {
                for (int i = 0; i < size; i++) {
                    arr[i] = (T) Double.valueOf(random.nextDouble() * 10000);
                }
            }
            return arr;
        }
    
        // Function to ensure the array has no issues for this test
        public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    return false;
                }
            }
            return true;
        }
    }
