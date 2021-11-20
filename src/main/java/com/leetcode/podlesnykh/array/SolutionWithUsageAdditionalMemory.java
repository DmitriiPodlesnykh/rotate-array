package com.leetcode.podlesnykh.array;

public class SolutionWithUsageAdditionalMemory implements RotateArray {
    @Override
    public void rotate(int[] nums, int k) {
        final int stepCounter = calculateStepCount(nums.length, k);
        final int [] firstPart = prepareFirstPartArray(nums, stepCounter);
        final int [] secondPart = prepareSecondPartArray(nums, stepCounter);
        int j =0;
        for (int i = 0; i< nums.length; i++) {
            if (i < firstPart.length) {
                nums[i] = firstPart[i];
            } else {
                nums[i] = secondPart[j];
                j++;
            }
        }
    }

    private int calculateStepCount(int length, int k) {
        if (length == k || (k>length && k%length == 0)) {
            return 0;
        } else if (k < length) {
            return k;
        } else {
            int loopCount = k/length;
            int result = k-loopCount*length;
            return result;
        }
    }

    private int[] prepareFirstPartArray(int[] nums, int stepCounter) {
        int [] firstPart = new int [stepCounter];
        int [] firstPart1 = new int [stepCounter];
        int i = 0;
        while (stepCounter>i) {
            firstPart[i] = nums[nums.length - 1 - i];
            i++;
        }
        for (int j = 0; j<firstPart.length; j++) {
            firstPart1[j] = firstPart[firstPart.length -1 -j];
        }
        return firstPart1;
    }

    private int[] prepareSecondPartArray(int[] nums, int stepCounter) {
        int [] secondPart = new int [nums.length - stepCounter];
        for (int i = 0; i < nums.length - stepCounter; i++) {
            secondPart[i] = nums[i];
        }
        return secondPart;
    }
}
