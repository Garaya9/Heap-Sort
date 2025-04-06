/* 
 CCMSC204
 Heap Sort
 Name: Gebrella Araya
 Date: April 6, 2025
 Platform: Eclipse
 
 Description: This Java program implements Heap Sort algorithm to sort an array in ascending order. 
 The program builds a max heap and then sorts it by repeatedly extracting the maximum element and 
 placing it at the end of the array.
*/
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] arr = {5, 22, 9, 76, 63, 81, 48, 92, 54, 28};

        System.out.println("Original Array:");
        printArray(arr);

        // Build Max-Heap
        buildMaxHeap(arr);
        System.out.println("\nArray as Max-Heap:");
        printArray(arr);

        // Sort the heap
        heapSort(arr);
        System.out.println("\nSorted Array (ascending):");
        printArray(arr);
    }

    // Step 1: Build Max Heap
    public static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Step 2: Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted with node i (size n)
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // left child
        int right = 2 * i + 2; // right child

        // If left child is larger
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Swap 
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Print 
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] = %d\n", i, arr[i]);
        }
    }
}
