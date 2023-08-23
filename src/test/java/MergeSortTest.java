import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class MergeSortTest {
    Logger log = LoggerFactory.getLogger(MergeSortTest.class);

    @Test
    public void sortingIntegerRising() {
        String[] args = new String[]{"-i", "-a", "outIntegerRising.txt", "in1Integer.txt", "in2Integer.txt", "in3Integer.txt"};
        String[] expected = new String[]{"1", "1", "1", "2", "3", "4", "8", "9", "27"};
        log.info("Sorting Integer Rising {}",Arrays.toString(expected));
        MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        List<String> actual = MergeSort.getListFromFile(args[2]);
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void sortingIntegerReversed() {
        String[] args = new String[]{"-i", "-d", "outIntegerReversed.txt", "in1Integer.txt", "in2Integer.txt", "in3Integer.txt"};
        String[] expected = new String[]{"27", "9", "8", "4", "3", "2", "1", "1", "1"};
        log.info("Sorting Integer Reversed {}",Arrays.toString(expected));
        MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        List<String> actual = MergeSort.getListFromFile(args[2]);
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void sortingStringsRising() {
        String[] args = new String[]{"-s", "-a", "outStringRising.txt", "in1String.txt", "in2String.txt", "in3String.txt"};
        String[] expected = new String[]{"Aleksander", "Aleksei", "Andrei", "Elena", "Fedor", "Irina", "Ivan", "Mariya", "Olga",
                "Sonya", "Svetlana", "Tatyana"};
        log.info("Sorting String Rising {}",Arrays.toString(expected));
        MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        List<String> actual = MergeSort.getListFromFile(args[2]);
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void sortingStringsReversed() {
        String[] args = new String[]{"-s", "-d", "outStringReversed.txt", "in1String.txt", "in2String.txt", "in3String.txt"};
        String[] expected = new String[]{"Tatyana", "Svetlana", "Sonya", "Olga", "Mariya", "Ivan", "Irina", "Fedor", "Elena",
                "Andrei", "Aleksei", "Aleksander"};
        log.info("Sorting String Reversed {}",Arrays.toString(expected));
        MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        List<String> actual = MergeSort.getListFromFile(args[2]);
        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test
    public void failedTest() {
        log.info("Failed Test");
        String[] args = new String[]{"-s", "outStringReversed.txt", "inInteger.txt", "in2Integer.txt", "in3Integer.txt"};
        Assert.assertThrows(Exception.class, () -> MergeSort.sorting(0, true, args));
    }
}