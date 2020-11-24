/** A class to time the MergeSort, QuickSort, and InsertionSort algorithms at different sizes */
public class Test {

    public static void main(String[] args) {
        // The 8 different n sizes
        int[] sizes = {5,10,15,20,1000,2000,4000,8000};

        // loops through the n sizes and finds the fastest sort time for each n
        for (int size : sizes) {
            System.out.println("n = " + size);
            getFastestSortTime(size);
            System.out.println();
        }
    }


    /** Prints the fastest Sort Time
     * @param n The size of the array */
    public static void getFastestSortTime(int n) {
        Sort sort = new Sort();
        // generates a random array of size n from [-10000,10000]
        int[] array = sort.RandomArray(n, -10000, 10000 );

        // gets the sort times
        long mergeSortTime = getMergeSortTime(array.clone(), sort);
        long quickSortTime = getQuickSortTime(array.clone(), sort);
        long insertionSortTime = getInsertionSortTime(array.clone(), sort);

        // prints the sort times
        System.out.println("MergeSort: " + mergeSortTime + " ns");
        System.out.println("QuickSort: " + quickSortTime + " ns");
        System.out.println("InsertionSort: " + insertionSortTime + " ns");

        // finds the quickest sort time and prints it
        if (mergeSortTime < quickSortTime && mergeSortTime < insertionSortTime) {
            System.out.println("MergeSort is the fastest (" + mergeSortTime + " ns)");
        }
        else if (quickSortTime < mergeSortTime && quickSortTime < insertionSortTime) {
            System.out.println("QuickSort is the fastest (" + quickSortTime + " ns)");
        }
        else {
            System.out.println("InsertionSort is the fastest (" + insertionSortTime + " ns)");
        }
    }

    /** Returns the time it takes to do a Merge Sort in nanoseconds
     * @param array The array to be sorted
     * @param sort A Sort instance */
    public static long getMergeSortTime(int[] array, Sort sort) {
        long startTime = System.nanoTime();
        sort.MergeSort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /** Returns the time it takes to do a Quick Sort in nanoseconds
     * @param array The array to be sorted
     * @param sort A Sort instance */
    public static long getQuickSortTime(int[] array, Sort sort) {
        long startTime = System.nanoTime();
        sort.QuickSort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /** Returns the time it takes to do an Insertion Sort in nanoseconds
     * @param array The array to be sorted
     * @param sort A Sort instance */
    public static long getInsertionSortTime(int[] array, Sort sort) {
        long startTime = System.nanoTime();
        sort.InsertionSort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
