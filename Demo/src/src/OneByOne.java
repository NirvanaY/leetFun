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



//#2 add-two-numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = new ListNode(0);
        ListNode rs = first;
        ListNode r1= l1;
        ListNode r2 =l2;
        int carry =0;

        while (r1!=null || r2!=null) {
            int x = (r1!=null)?r1.val:0;
            int y = (r2!=null)?r2.val:0;
            int sum = carry + x + y;
            rs.next = new ListNode(sum%10);
            rs = rs.next;
            carry = sum/10;
            if(r1!=null) r1= r1.next;
            if(r2!=null) r2= r2.next;
        }

        if(carry>0){
            rs.next = new ListNode(carry);
        }

        return first.next;
    }
}


