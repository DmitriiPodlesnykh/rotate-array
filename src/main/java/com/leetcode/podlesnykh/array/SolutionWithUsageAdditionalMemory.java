package com.leetcode.podlesnykh.array;

public class SolutionWithUsageAdditionalMemory implements RotateArray {

    @Override
    public void rotate(int[] nums, int k) {
        final int stepCounter = calculateStepCount(nums.length, k);

        int [] firstPart = prepareFirstPartArray(nums, stepCounter);
        int [] secondPart = prepareSecondPartArray(nums, stepCounter);


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
        System.out.println("; stepCounter = " + stepCounter);
        for (int i = 0; i < stepCounter; i++) {
            System.out.println("i = " + i + "; stepCounter = " + stepCounter + "; nums[i + 1+ stepCounter = "  + nums[i + stepCounter] + " ");
            firstPart[i] = nums[i + stepCounter];
        }
        for (int q = 0; q<firstPart.length; q++) {
            System.out.print(firstPart[q] + " - " );
        }
        System.out.println(" ");
        return firstPart;
    }

    private int[] prepareSecondPartArray(int[] nums, int stepCounter) {
        int [] secondPart = new int [nums.length - stepCounter];
        for (int i = 0; i < nums.length - stepCounter; i++) {
            secondPart[i] = nums[i];
        }
        return secondPart;
    }
}
