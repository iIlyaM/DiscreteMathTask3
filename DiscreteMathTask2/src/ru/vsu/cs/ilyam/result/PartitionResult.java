package ru.vsu.cs.ilyam.result;

public class PartitionResult {
    int partitionIndex;
    private int countSwap;
    private int countComparison;

    public PartitionResult(int partitionIndex, int countSwap, int countComparison) {
        this.partitionIndex = partitionIndex;
        this.countSwap = countSwap;
        this.countComparison = countComparison;
    }

    public int getPartitionIndex() {
        return partitionIndex;
    }

    public int getCountSwap() {
        return countSwap;
    }

    public int getCountComparison() {
        return countComparison;
    }
}
