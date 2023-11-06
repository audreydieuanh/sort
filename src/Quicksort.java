import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Audrey Trinh
 */
public class Quicksort implements Sorter {
    /**
     * Run some experiments.
     */

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new Quicksort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    Quicksort() {
    } // Quicksort()

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Sort the values in values using order to compare values.
     */
    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        sort(values, order, 0, values.length);
    } // sort(T[], Comparator<? super T>

    /**
     * Sort the values in indices [lb..ub) of values using order to compare values.
     */
    private static <T> void sort(T[] values, Comparator<? super T> order, int lb, int ub) {
        // Subarrays of one element or fewer are sorted.
        if (lb < ub-1) {
            int mid = partition(values, order, lb, ub);
            sort(values, order, lb, mid);
            sort(values, order, mid+1, ub);
        } // if/else
    } // quicksort(T[], Comparator, int, int)

    /**
     * Select a pivot and partition the subarray from [lb .. ub) into
     * the following form.
     *
     * <pre>
     * ---+-----------------+-+----------------+---
     *    | values <= pivot |p| values > pivot |
     * ---+-----------------+-+----------------+---
     *    |                 |                  |
     *    lb                pivotLoc           ub
     * </pre>
     *
     * @return pivotLoc.
     */
    static <T> int partition(T[] arr, Comparator<? super T> compare, int lb, int ub) {
        T pivot = arr[lb + (ub - lb)/2];
        swap(arr, lb + (ub - lb)/2, lb);
        int small = lb + 1;
        int large = ub;
        while (small < large) {
            if (compare.compare(arr[small], pivot) > 0) {
                swap(arr, small, large - 1);
                large--;
            } else {
                small++;
            }
        }
        swap(arr, lb, small - 1);
        return small - 1;

    } // partition

    static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
