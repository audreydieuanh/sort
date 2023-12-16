import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Audrey Trinh
 */


public class MergeSort implements Sorter {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    sort(values, 0, values.length, order);
  }

  static <T> void sort(T[] values, int lo, int hi, Comparator<? super T> order) {
    if (hi - lo > 1) {
      int mid = lo + (hi - lo) / 2;
      sort(values, lo, mid, order);
      sort(values, mid, hi, order);

      merge(values, lo, mid, hi, order);
    }
  }

  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   * <p>
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] temp = Arrays.copyOfRange(vals, lo, hi);
    int i = 0;
    int i1 = 0; // start from 0 for temp array
    int i2 = mid - lo; // start from mid - lo for temp array
    while (i1 < mid - lo && i2 < hi - lo) {
      if (comparator.compare(temp[i1], temp[i2]) < 0) {
        vals[i + lo] = temp[i1];
        i++;
        i1++;
      } else {
        vals[i + lo] = temp[i2];
        i++;
        i2++;
      }
    }

    while (i1 < mid - lo) {
      vals[i + lo] = temp[i1];
      i++;
      i1++;
    }

    while (i2 < hi - lo) {
      vals[i + lo] = temp[i2];
      i++;
      i2++;
    }
  } // merge
}

