import org.junit.jupiter.api.Test;

/**
 * Tests of InsertionSort.
 *
 * @author Audrey Trinh
 */
public class InsertionSortTester extends SortTester {

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  public InsertionSortTester() {
    super();
    this.sorter = InsertionSort.SORTER;
  } // InsertionSortTester()

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
    super.equalStrLenTest();
  }

  @Test
  public void reverseOrderTest() {
    super.reverseOrderTest();
  }
} // class InsertionSortTester
