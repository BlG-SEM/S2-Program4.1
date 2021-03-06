package ru.vsu.cs;

import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        Integer[] data = {7, 10, 3, 8, 7, 2, 1, 9, 5, 7};
        boolean[] fixed = {true, false, true, true, false, false, true, true, false, true};

        Integer[] expected = {1, 10, 3, 7, 7, 2, 7, 8, 5, 9};

        System.out.println("Array before sort:");
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(fixed));

        System.out.println();

        sort(data, fixed);

        System.out.println("Array after sort:");
        System.out.print("Changed array: ");
        System.out.println(Arrays.toString(data));
        System.out.print("Expected array: ");
        System.out.println(Arrays.toString(expected));

    }

    public static void sort(Integer[] data, boolean[] fixed) {
        for (int i = 0; i < data.length; i++) {

            if (!fixed[i]) {
                continue;
            }

            for (int j = 0; j < data.length; j++) {

                if (!fixed[j]) {
                    continue;
                }

                if (nextIndexExists(j, fixed)) {
                    int nextIndex = getNextIndex(j, fixed);

                    if (data[j] > data[nextIndex]) {
                        int temp = data[j];
                        data[j] = data[nextIndex];
                        data[nextIndex] = temp;
                    }
                }
            }
        }
    }

    private static boolean nextIndexExists(int pos, boolean[] fixed) {
        for (int i = pos + 1; i < fixed.length; i++) {
            if (fixed[i]) return true;
        }
        return false;
    }

    private static int getNextIndex(int pos, boolean[] fixed) {
        for (int i = pos + 1; i < fixed.length; i++) {
            if (fixed[i]) return i;
        }
        return -1;
    }
}
