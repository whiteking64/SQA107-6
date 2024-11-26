public class BinarySearch {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                return mid;

            // If target greater, ignore left half
            if (arr[mid] < target)
                left = mid + 1;

                // If target is smaller, ignore right half
            else
                right = mid - 1;
        }

        // Target not present
        return -1;
    }
}
