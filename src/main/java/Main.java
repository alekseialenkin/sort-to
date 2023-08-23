import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        if (Arrays.asList(args).contains("-a") || Arrays.asList(args).contains("-d")) {
            MergeSort.sorting(1, Arrays.asList(args).contains("-a"), args);
        } else {
            MergeSort.sorting(0, true, args);
        }
    }
}
