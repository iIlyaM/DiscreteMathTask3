package ru.vsu.cs.ilyam.result;

public class MergeResult {
    private int countSwap;
    private int countComparison;

    public MergeResult(int countSwap, int countComparison) {
        this.countSwap = countSwap;
        this.countComparison = countComparison;
    }

    public int getCountSwap() {
        return countSwap;
    }

    public int getCountComparison() {
        return countComparison;
    }
}
