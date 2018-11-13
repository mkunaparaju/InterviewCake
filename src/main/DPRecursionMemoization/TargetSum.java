package main.DPRecursionMemoization;

import javax.swing.*;
import java.util.HashMap;

public class TargetSum {
    static HashMap<String, Integer> memoMap = new HashMap<>();

    public static void main(String[] args) {
        int t = 3;
        int [] nums = {1,1,1,1,1};

        System.out.println(targetSum(t, nums));
    }

    private static int targetSum(int t, int[] nums) {
//        return targetSumBrute(t, nums,0 ,0);
        return targetSumMemo(t, nums, 0 ,0);
    }

    private static int targetSumBrute(int t, int[] nums, int i, int sum) {
        if(i == nums.length) return (sum == t ? 1: 0);

        return targetSumBrute(t,nums, i+1, sum+nums[i]) + targetSumBrute(t,nums, i+1, sum-nums[i]);
    }

    private static int targetSumMemo(int t, int [] nums, int i, int sum){
        if(i == nums.length) return sum==t ? 1 : 0;
        String key = i + " " + sum;
        int toReturn = 0;

        if(memoMap.containsKey(key)) toReturn =  memoMap.get(key);
        else {
            toReturn = targetSumMemo(t, nums, i+1, sum+ nums[i]) + targetSumMemo(t, nums, i+1, sum - nums[i]);
            memoMap.put(key, toReturn);
        }
        return toReturn;
    }
}
