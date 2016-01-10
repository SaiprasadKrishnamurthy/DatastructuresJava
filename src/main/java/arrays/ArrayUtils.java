package arrays;

import java.util.*;

/**
 * Created by saikris on 10/01/2016.
 */
public class ArrayUtils {

    private static int maxDecimalRownum(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] row = input[i];
            for (int j = 0; j < row.length; j++) {
                System.out.println("arr[i,j] ==> " + input[i][j]);
            }
        }
        return 0;
    }

    private static void elementsWhoseSumIs(int[] arr, int sum) {
        // Sort.
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        boolean found = false;

        while (start < end && !found) {
            int res = arr[start] + arr[end];
            if (res < sum) start++;
            else if (res > sum) end--;
            else if (res == sum) {
                System.out.println("Found pairs: " + arr[start] + "," + arr[end]);
                found = true;
            }
        }
    }

    private static int search(int[] arr, int element) {
        return _binarySearch(arr, 0, arr.length, element);
    }

    private static int _binarySearch(int[] arr, int start, int end, int element) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (element == arr[mid]) return mid;
            else if (element < arr[mid]) return _binarySearch(arr, start, mid, element);
            else if (element > arr[mid]) return _binarySearch(arr, mid + 1, end, element);
        }
        return -1;
    }

    private static void _elementsWhoseSumIs(Integer[] arr, int sum) {
        Set<Integer> elements = new HashSet<>(Arrays.asList(arr));
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            if (elements.contains(sum - arr[i])) {
                System.out.println("Found pairs: " + arr[i] + "," + (sum - arr[i]));
                found = true;
            }
        }
    }

    private static int lastIndexOf(int[] arr, int element) {
        int foundIndex = search(arr, element);
        if (foundIndex > 0) {
            while (foundIndex < arr.length && arr[foundIndex] == element) {
                foundIndex++;
            }
            return foundIndex - 1;
        } else {
            return foundIndex;
        }
    }

    private static int majorityElement(int[] arr) {
        Map<Integer, Integer> elementsToCountsMapping = new HashMap<>();
        int halfTheSize = arr.length / 2;

        for (int e : arr) {
            elementsToCountsMapping.compute(e, (k, v) -> (v == null) ? 1 : v + 1);
            if (elementsToCountsMapping.containsValue(halfTheSize)) {
                return e;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[][] = {{0, 1, 0,}, {1, 1, 0}, {1, 0, 1}};
        maxDecimalRownum(array);

        int[] arr = {1, 2, 3, 2, 3, 1, 3};

        System.out.println(1 ^ 2 ^ 3);

        elementsWhoseSumIs(new int[]{1, 4, 45, 6, 10, -8}, 16);
        _elementsWhoseSumIs(new Integer[]{1, 4, 45, 6, 10, -8}, 16);

        int[] sortedArray = {13, 24, 34, 46, 52, 63, 89, 89, 89, 89, 89, 89, 89, 89, 91, 100};
        int[] unsortedArray = {120, 89, 34, 46, 52, 63, 89, 89, 89, 89, 89, 89, 89, 89, 91, 100, 13, 89, 20, 1, -1, 89, 10, 89};
        int foundIndex = search(sortedArray, 89);
        System.out.println("Element found at index: " + foundIndex);
        System.out.println("Element last index of found at index: " + lastIndexOf(sortedArray, 100));
        System.out.println("Majority element (sorted array): " + majorityElement(sortedArray));
        System.out.println("Majority element (unsorted array): " + majorityElement(unsortedArray));
    }
}
