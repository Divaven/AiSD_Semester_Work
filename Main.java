package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {

        try {
            File file = new File("data.txt");

            Scanner in = new Scanner(file);
            ArrayList<int[]> arrays = new ArrayList<>();

            while (in.hasNextLine()) {
                String size = in.nextLine();
                String line = in.nextLine();
                String[] elements = line.split(" ");
                int[] array = new int[elements.length];

                for (int i = 0; i < elements.length; i++) {
                    array[i] = Integer.parseInt(elements[i]);
                }

                arrays.add(array);
            }

            in.close();

            for (int[] array : arrays) {
                long startTime = System.currentTimeMillis();
                count = 0;
                stooge_sort(array, 0, array.length - 1);
                long endTime = System.currentTimeMillis();
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                System.out.println(count);
                System.out.println(endTime - startTime);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    static int[] stooge_sort(int[] a, int l, int r) {
        count++;

        if (a[l] > a[r]) {
            int x = a[l];
            a[l] = a[r];
            a[r] = x;
        }

        if (r - l > 1) {
            int t = (r - l + 1) / 3;
            stooge_sort(a, l, r - t);
            stooge_sort(a, l + t, r);
            stooge_sort(a, l, r - t);
        }

        return a;
    }
}
