import org.junit.jupiter.api.Test;

/**
 * Tests of AudreyTrinhSort.
 */
public class AudreyTrinhSortTester extends SortTester {


    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    public AudreyTrinhSortTester() {
        super();
        this.sorter = AudreyTrinhSort.SORTER;
    } // QuicksortTester()

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

} // class QuicksortTester

