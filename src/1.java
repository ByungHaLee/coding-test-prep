import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> mergedList = new ArrayList<Integer>();
        for(int i=0, j=0; ;) {
            if(i >= nums1.length && j >= nums2.length)
                break;
            if(i == nums1.length) {
                mergedList.add(nums2[j]);
                j++;
            } else if(j == nums2.length) {
                mergedList.add(nums1[i]);
                i++;
            } else if(nums1[i] < nums2[j]) {
                mergedList.add(nums1[i]);
                i++;
            } else {
                mergedList.add(nums2[j]);
                j++;

            }
        }

        if ( mergedList.size() % 2 == 1)
            return mergedList.get(mergedList.size()/2);
        else
            return (mergedList.get(mergedList.size()/2 - 1) + mergedList.get(mergedList.size()/2)) / 2.0;
    }

    @Test
    public void tt() {
        assertEquals( findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2);
        assertEquals( findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}), 2.5);
    }
}