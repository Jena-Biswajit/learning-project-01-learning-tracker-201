package com.arrays;

class RemoveElementOccurance {

    public int removeElement(int[] nums, int element) {

        int len = nums.length;
        int start = 0;
        int end = len - 1;

        while (start < end) {
            if (nums[start] != element) {
                start++;
            }

            else if (nums[end] == element) {
                end--;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != element) {

                count++;
            } else {
                nums[i] = 0;
            }
        }
        return count;
    }
}

public class RemoveElement {

    public static void main(String[] args) {
        int[] array = { 2, 3, 2, 3, 2, 4, 5, 5, 6 };
        int removeElement = 2;

        RemoveElementOccurance ob1 = new RemoveElementOccurance();
        int lenAfterRemoved = ob1.removeElement(array, removeElement);

        System.out.println(lenAfterRemoved);

    }

}
