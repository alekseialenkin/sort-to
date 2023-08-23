import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortTest {
    @Test
    public void sorting() {
        String[] args = new String[]{"-i", "-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        String[] expected = new String[]{"1","1","1","2","3","4","8","9","27"};
    }
}