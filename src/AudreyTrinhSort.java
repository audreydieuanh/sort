import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Audrey Trinh
 * @reference: 3-way pivot quicksort
 */
public class AudreyTrinhSort implements Sorter {
    /**
     * Run some experiments.
     */

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new AudreyTrinhSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    AudreyTrinhSort() {
    }

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+


    /**
     * Sort the values in values using order to compare values.
     */

    public <T> void sort(T[] values, Comparator<? super T> order) {
        sort(values, 0, values.length, order);
    } // sort(T[], Comparator<? super T>


    private static <T> void sort(T[] arr, int lb, int ub, Comparator<? super T> order) {
        if (ub - lb <= 1) {
            return;
        }

        int[] segmentIndex = partition(arr, lb, ub, order);
        sort(arr, lb, segmentIndex[0], order);
        sort(arr, segmentIndex[1], ub, order);
    }

    static <T> int[] partition(T[] arr, int lb, int ub, Comparator<? super T> order) {
        T pivot = arr[ub - 1];
        int i = lb;
        int j = ub - 1;
        int ptr1 = lb;
        int ptr2 = ub - 1;

        while (i <= j) {
            while (i <= j && order.compare(arr[i], pivot) <= 0) {
                if (order.compare(arr[i], pivot) == 0) {
                    swap(arr, i, ptr1++);
                }
                i++;
            }

            while (i <= j && order.compare(arr[j], pivot) >= 0) {
                if (order.compare(arr[j], pivot) == 0) {
                    swap(arr, j, ptr2--);
                }
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        int k = lb;
        while (ptr1 > lb) {
            swap(arr, --i, --ptr1);
        }

        k = ub - 1;
        while (ptr2 < ub - 1) {
            swap(arr, ++j, ++ptr2);
        }

        return new int[]{i, j + 1};
    }

    static <T> void swap(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
