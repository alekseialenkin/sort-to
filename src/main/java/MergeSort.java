
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    private static <T extends Comparable<T>> T[] mergeSort(T[] array, boolean sortMode) {
        T[] currentSrc = Arrays.copyOf(array, array.length);
        T[] currentDest = Arrays.copyOf(array, array.length);

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size, sortMode);
            }

            T[] tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
        }
        return currentSrc;
    }

    private static <T extends Comparable<T>> void merge(T[] src1, int src1Start, T[] src2, int src2Start, T[] dest,
                                                        int destStart, int size, boolean sortMode) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            if (src1End - src1Start >= 0) {
                System.arraycopy(src1, src1Start, dest, src1Start, src1End - src1Start);
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || (sortMode ? src1[index1].compareTo(src2[index2]) < 0 : src1[index1].compareTo(src2[index2]) > 0))) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public static void sorting(int number, boolean mode, String[] args) {
        try (FileWriter fileW = new FileWriter(args[number + 1])) {
            List<List<String>> listWithNumbersLists = new ArrayList<>();
            for (int i = number + 2; i < args.length; i++) {
                listWithNumbersLists.add(getListFromFile(args[i]));
            }
            if (Arrays.asList(args).contains("-i")) {
                List<Integer> resultList = new ArrayList<>();
                for (List<String> strings : listWithNumbersLists) {
                    for (String string : strings) {
                        resultList.add(Integer.parseInt(string));
                    }
                }
                Integer[] arr = new Integer[resultList.size()];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = resultList.get(i);
                }
                Integer[] resultOfSorting = mergeSort(arr, mode);
                for (int i : resultOfSorting) {
                    fileW.write(i + "\n");
                }
            } else {
                List<String> resultList = new ArrayList<>();
                for (List<String> strings : listWithNumbersLists) {
                    resultList.addAll(strings);
                }
                String[] str = new String[resultList.size()];
                for (int i = 0; i < str.length; i++) {
                    str[i] = resultList.get(i);
                }
                String[] resultOfSorting = mergeSort(str, mode);
                for (String s : resultOfSorting) {
                    fileW.write(s + "\n");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Wrong parameters");
        }
    }

    public static List<String> getListFromFile(String fileName) {
        List<String> list1 = new ArrayList<>();
        try (FileReader fileR = new FileReader(fileName); Scanner scanner = new Scanner(fileR)) {
            while (scanner.hasNextLine()) {
                list1.add(scanner.nextLine());
            }
        } catch (Exception e) {
            throw new RuntimeException("Wrong parameters");
        }
        return list1;
    }
}