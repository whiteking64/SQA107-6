import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Sorting and Searching Application!\n");
            // Get array size
            System.out.print("Enter the number of integers you want to sort: ");
            int size = scanner.nextInt();

            // Input validation
            if (size <= 0) {
                System.out.println("Please enter a positive number.");
                return;
            }

            // Create and populate array
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.print("Enter integer " + (i + 1) + ": ");
                numbers[i] = scanner.nextInt();
            }

            // Choose sorting algorithm
            System.out.println("\nChoose a sorting algorithm:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Sort the array
            int[] sortedArray = switch (choice) {
                case 1 -> BubbleSort.sort(numbers.clone());
                case 2 -> SelectionSort.sort(numbers.clone());
                default -> {
                    System.out.println("Invalid choice. Using Bubble Sort by default.");
                    yield BubbleSort.sort(numbers.clone());
                }
            };

            // Display sorted array
            System.out.print("\nSorted List: ");
            displayArray(sortedArray);

            // Binary search
            System.out.print("\nEnter the number to search for in the sorted list: ");
            int target = scanner.nextInt();

            int position = BinarySearch.search(sortedArray, target);
            if (position != -1) {
                System.out.println("Number found at position " + (position + 1) + ".");
            } else {
                System.out.println("Number not found in the list.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Please enter valid integer numbers.");
        } finally {
            System.out.println("\nThank you for using the application!");
        }
    }

    private static void displayArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
