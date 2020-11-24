/** A class containing the MergeSort, QuickSort, and InsertionSort algorithms */
public class Sort {

    /** Sorts an array with Merge Sort
     * @param A The array to be sorted */
    public void MergeSort(int[] A) {
        int length = A.length;
        // returns if the length of the array is less than 2
        if (length < 2) {
            return;
        }
        // the center of the array
        int center  = length / 2;
        // the left half of the array
        int[] leftArray = new int[center];
        // the right half of the array
        int[] rightArray = new int[length - center];
        // populates the left array from A
        System.arraycopy(A, 0, leftArray, 0, center);
        // populates the right array from A
        System.arraycopy(A, center, rightArray, 0, length - center);
        MergeSort(leftArray);
        MergeSort(rightArray);
        merge(A, leftArray, rightArray);
    }

    /** Merges a left array and right array in sorted order into one array
     * @param A The array to be both merged and sorted onto
     * @param leftArray The left array
     * @param rightArray The right array */
    public void merge(int[] A, int[] leftArray, int[] rightArray) {
        // left array length
        int leftArrayLength = leftArray.length;
        // right array length
        int rightArrayLength = rightArray.length;
        int i = 0, j = 0, k = 0;
        // loops while either i is less than the left array length or j is less than the right array length
        while (i < leftArrayLength && j < rightArrayLength) {
            // checks if the index of the left array is less than or equal to the index of the right array
            // sets A to the index
            if (leftArray[i] <= rightArray[j]) {
                A[k] = leftArray[i];
                i++;
            }
            // sets A to the index of the right array
            else {
                A[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // loops while i is less than the left array length
        while (i < leftArrayLength) {
            A[k] = leftArray[i];
            i++;
            k++;
        }
        // loops while j is less than the right array length
        while (j < rightArrayLength) {
            A[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // #################################################################################################################

    /** Sorts an array with Quick Sort
     * @param A The array to be sorted */
    public void QuickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    /** Sorts an array with Quick Sort recursively
     * @param A The array to be sorted
     * @param start The starting index of the array
     * @param end The ending index of the array */
    public void quickSort(int[] A, int start, int end) {
        // checks if the starting index is less than the ending index
        if (start < end) {
            // finds the pivot index
            int pivotIndex = partition(A, start, end);
            // Quick sorts from the start to the pivot index minus one
            quickSort(A, start, pivotIndex - 1);
            // Quick sorts from the pivot index plus one to the end
            quickSort(A, pivotIndex + 1, end);
        }
    }

    /** Returns the partition index
     * @param A The array to on which the partition index will be found
     * @param start The starting index
     * @param end The ending index */
    public int partition(int[] A, int start, int end) {
        // uses last element as pivot
        int pivot  = A[end];
        // sets the partition index to be the start
        int partitionIndex = start;
        // loops while the start is less than the end
        for (int i = start; i < end; i++) {
            // checks if the the current index's value is less than the pivot value
            // swaps the current index and partition index if true
            if (A[i] <= pivot) {
                swap(A, i, partitionIndex);
                partitionIndex++;
            }
        }
        // swaps the partition index and end value
        swap(A, partitionIndex, end);
        return partitionIndex;
    }

    /** Swaps two indexes in an array
     * @param A The array to be swapped from
     * @param a The first index to swap
     * @param b The second index to swap  */
    public void swap(int[] A, int a, int b) {
        // saves the a index value
        int temp = A[a];
        // swaps the a index value with the b index value
        A[a] = A[b];
        // swaps the b index with the temp value
        A[b] = temp;
    }

    // #################################################################################################################

    /** Sorts an Array with Insertion Sort
     * @param A The array to be sorted */
    public void InsertionSort(int[] A) {
        // loops through the length of the array from the 1st index
        for (int i = 1; i < A.length; i++) {
            // the number to be inserted when its proper index is found
            int toBeInserted = A[i];
            // the index to stop at
            int stop = i - 1;
            // loops while the stop index is greater than or equal to 0
            // and the stop index's value is greater than the index to be inserted
            while (stop >= 0 && A[stop] > toBeInserted) {
                A[stop + 1] = A[stop];
                stop -= 1;
            }
            A[stop + 1] = toBeInserted;
        }
    }

    // #################################################################################################################

    /** Returns a randomly generated array of integers in a given range
     * @param n The size of the array
     * @param a The smallest possible value in the array
     * @param b The largest possible value in the array
     * @return A randomly generated array of integers in a given range */
    public int[] RandomArray(int n, int a, int b) {
        // creates an array of size n
        int[] array = new int[n];
        // loops over the size of the array and adds a randomly generated number in the range [a,b] to each index
        for (int i = 0; i < n; i++) {
            array[i]  = (int) ((Math.random() * (b + 1 - a)) + a);
        }
        return array;
    }
}
