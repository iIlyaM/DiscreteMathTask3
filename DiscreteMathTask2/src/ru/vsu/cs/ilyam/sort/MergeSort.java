package ru.vsu.cs.ilyam.sort;

import ru.vsu.cs.ilyam.result.MergeResult;
import ru.vsu.cs.ilyam.result.SwapAndCompareCountResult;

public class MergeSort {

    public SwapAndCompareCountResult sort(int[] a, int arrSize) {
        int countSwap = 0;
        int countComparison = 0;

            if (arrSize < 2) {
                return null;
            }
            int mid = arrSize / 2;
            int[] l = new int[mid];
            int[] r = new int[arrSize - mid];

            for (int i = 0; i < mid; i++) {
                l[i] = a[i];
            }
            for (int i = mid; i < arrSize; i++) {
                r[i - mid] = a[i];
            }

            sort(l, mid);

            sort(r, arrSize - mid);


            MergeResult res = merge(a, l, r, mid, arrSize - mid);
            countComparison = res.getCountComparison();
            //countSwap = res.getCountSwap();
        return new SwapAndCompareCountResult(a, countSwap, countComparison);
    }

    public MergeResult merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int countSwap = 0;
        int countComparison = 0;

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            countComparison++;
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        return new MergeResult(countSwap, countComparison);
    }


}
