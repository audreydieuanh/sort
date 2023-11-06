import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Audrey Trinh
 */


public class InsertionSort implements Sorter{
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The one sorter you can access.
     */
    public static Sorter SORTER = new InsertionSort();

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a sorter.
     */
    InsertionSort() {
    } // InsertionSort()

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < values.length; firstUnsortedIndex++) {
            T newElement = values[firstUnsortedIndex];
            int i = firstUnsortedIndex;
            while (i > 0 && order.compare(newElement, values[i - 1]) < 0) {
                values[i] = values[i - 1];
                i--;
            }
            values[i] = newElement;
        }
    }

}
