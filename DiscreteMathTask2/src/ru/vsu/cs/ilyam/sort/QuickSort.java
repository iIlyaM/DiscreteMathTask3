package ru.vsu.cs.ilyam.sort;

import ru.vsu.cs.ilyam.result.SortResult;

public class QuickSort {

    public SortResult sort(int[] arr, int low, int high) {

        int counter = 0;
        if (low < high) {
            int pivot = arr[high];
            int i = (low - 1);

            for (int j = low; j <= high - 1; j++) {
                counter++;
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            int pi = (i + 1);

            counter += sort(arr, low, pi - 1).getCount();
            counter += sort(arr, pi + 1, high).getCount();
        }
        return new SortResult(arr, counter);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
