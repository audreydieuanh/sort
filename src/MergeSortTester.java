import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests of MergeSort.
 */
public class MergeSortTester extends SortTester {

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    public MergeSortTester() {
        super();
        this.sorter = MergeSort.SORTER;
    } // MergeSortTester()

    @Test
    @Override
    public void intTest() {
        super.intTest();
    }

    @Test
    @Override
    public void strTest() {
        super.strTest();
    }

    @Test
    @Override
    public void edgeCaseLengthTest() {
        super.edgeCaseLengthTest();
    }

    @Test
    @Override
    public void alreadySortedTest() {
        super.alreadySortedTest();
    }

    @Test
    @Override
    public void equalNumTest() {
        super.equalNumTest();
    }

    @Test
    @Override
    public void equalStrLenTest() {
        String[] equalLenStrs = {"Hello", "Apple", "Thick", "Books", "Flour"};
        sorter.sort(equalLenStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        // since mergeSort is an unstable sorting algorithm
        assertEquals("[Flour, Books, Thick, Apple, Hello]", Arrays.toString(equalLenStrs));
    }

} // class MergeSortTester