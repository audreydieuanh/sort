import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests of Sorter objects.
 *
 * @author Audrey Trinh
 */
public class SortTester {
  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void bigIntArrTest() {
    Integer[] intArr = generateRandomArray(100);
    sorter.sort(intArr, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 - num2;
      }
    });

    for (int i = 0; i < intArr.length - 1; i++) {
      assertTrue(intArr[i] <= intArr[i + 1]);
    }
  }

  @Test
  public void intTest() {
    Integer[] intArr = { -1, 30, 44, 2, -100, 32 };
    sorter.sort(intArr, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 - num2;
      }
    });

    assertEquals("[-100, -1, 2, 30, 32, 44]", Arrays.toString(intArr));
  }

  @Test
  public void strTest() {
    String[] strArr = { "Hello", "Hi", "Morning", "New York Times", "   ", "J" };
    sorter.sort(strArr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    });
    assertEquals("[J, Hi,    , Hello, Morning, New York Times]", Arrays.toString(strArr));
  }

  @Test
  public void edgeCaseLengthTest() {
    Integer[] intArr = { 100 };
    sorter.sort(intArr, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 - num2;
      }
    });
    assertEquals("[100]", Arrays.toString(intArr));

    Double[] zeroLength = {};
    sorter.sort(zeroLength, new Comparator<Double>() {
      public int compare(Double num1, Double num2) {
        return num1.compareTo(num2);
      }
    });
    assertEquals("[]", Arrays.toString(zeroLength));
  }

  @Test
  public void alreadySortedTest() {
    Double[] doubleArr = { -100.0, 1.1, 20.2, 302.5, 10200.5 };
    sorter.sort(doubleArr, new Comparator<Double>() {
      public int compare(Double num1, Double num2) {
        return num1.compareTo(num2);
      }
    });
    assertEquals("[-100.0, 1.1, 20.2, 302.5, 10200.5]", Arrays.toString(doubleArr));
  }

  @Test
  public void equalNumTest() {
    Integer[] equalInt = { 1, 1, 1, 1, 1, 1, 1, 1 };
    sorter.sort(equalInt, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 - num2;
      }
    });
    assertEquals("[1, 1, 1, 1, 1, 1, 1, 1]", Arrays.toString(equalInt));
  }

  @Test
  public void equalStrLenTest() {
    String[] equalLenStrs = { "Hello", "Apple", "Thick", "Books", "Flour" };
    sorter.sort(equalLenStrs, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.length() - o2.length();
      }
    });
    // sorter is a stable sorting algorithm
    assertEquals("[Hello, Apple, Thick, Books, Flour]", Arrays.toString(equalLenStrs));
  }

  @Test
  public void reverseOrderTest() {
    Integer[] intArr = { 100, 10, 9, 8, 7, -10, -100 };
    sorter.sort(intArr, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 - num2;
      }
    });

    assertEquals("[-100, -10, 7, 8, 9, 10, 100]", Arrays.toString(intArr));
  }

  private static Integer[] generateRandomArray(int size) {
    Random random = new Random();
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(10);
    }
    return array;
  }

}
