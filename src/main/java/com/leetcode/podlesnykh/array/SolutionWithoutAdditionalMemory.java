package com.leetcode.podlesnykh.array;

public class SolutionWithoutAdditionalMemory implements RotateArray {
    @Override
    public void rotate(int[] nums, int k) {
        final int stepCounter = calculateStepCount(nums.length, k);
        for (int i=0; i< stepCounter; i++) {
            rotate(nums);
        }
    }

    private void rotate(int[] nums) {
        final int firstElement = nums[0];
        final int lastElement = nums[nums.length -1];

        int changedElement = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[0] = lastElement;
            } else if (i >=  nums.length -1){
                nums[i] = changedElement;
            } else {
                int temp = nums[i];
                nums[i] =  changedElement;
                changedElement = temp;
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
}
