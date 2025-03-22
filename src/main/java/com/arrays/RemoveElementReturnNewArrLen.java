package com.arrays;

class ReturnNewArrLenLeetCodeProblem {
    int removeDuplicatesRetNewLen(int[] nums) {

        int len = nums.length;
        int index = 0;

        for (int i = 0; i < len; i++) {
            boolean duplicate = false;

            for (int j = 0; j < index; j++) {
                if (nums[i] == nums[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                nums[index++] = nums[i];
            }
        }

        int count = index;

        while (index < len) {
            nums[index++] = 0;
        }

        return count;
    }
}

public class RemoveElementReturnNewArrLen {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 12, 3, 4, 0, 3, 4};
        ReturnNewArrLenLeetCodeProblem ob1 = new ReturnNewArrLenLeetCodeProblem();
        int resultNewLen = ob1.removeDuplicatesRetNewLen(arr);
        System.out.println(resultNewLen);

    }
}