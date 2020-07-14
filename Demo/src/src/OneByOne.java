package src;

import java.util.HashMap;
import java.util.Map;

public class OneByOne {

    //no1 liang-shu-zhi-he-by-leetcode-2
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);

        }
        throw new IllegalArgumentException("no answer");
    }


}
