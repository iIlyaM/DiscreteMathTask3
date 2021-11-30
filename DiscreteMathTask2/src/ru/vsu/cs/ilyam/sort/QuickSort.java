package ru.vsu.cs.ilyam.sort;

import ru.vsu.cs.ilyam.result.PartitionResult;
import ru.vsu.cs.ilyam.result.SwapAndCompareCountResult;

public class QuickSort {

    public SwapAndCompareCountResult sort(int[] arr, int begin, int end) {
        int swapCount = 0;
        int comparisonCount = 0;
        PartitionResult partitionResult = null;
        if (begin < end) {
            partitionResult = partition(arr, begin, end);
            int partitionIndex = partitionResult.getPartitionIndex();
            swapCount += partitionResult.getCountSwap();
            comparisonCount += partitionResult.getCountComparison();

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
        return new SwapAndCompareCountResult(arr, swapCount, comparisonCount);
    }

    private PartitionResult partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        int swapCount = 0;
        int comparisonCount = 0;

        for (int j = begin; j < end; j++) {
            comparisonCount++;
            if (arr[j] <= pivot) {
                i++;

                swapCount++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        swapCount++;
        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return new PartitionResult(i + 1, swapCount, comparisonCount);
    }
}
