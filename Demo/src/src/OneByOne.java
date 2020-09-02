package src;

import java.util.*;

public class OneByOne {

    //no1 liang-shu-zhi-he-by-leetcode-2
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("no answer");
    }


    //#2 add-two-numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = new ListNode(0);
        ListNode rs = first;
        ListNode r1 = l1;
        ListNode r2 = l2;
        int carry = 0;

        while (r1 != null || r2 != null) {
            int x = (r1 != null) ? r1.val : 0;
            int y = (r2 != null) ? r2.val : 0;
            int sum = carry + x + y;
            rs.next = new ListNode(sum % 10);
            rs = rs.next;
            carry = sum / 10;
            if (r1 != null) r1 = r1.next;
            if (r2 != null) r2 = r2.next;
        }

        if (carry > 0) {
            rs.next = new ListNode(carry);
        }

        return first.next;
    }


    //#3 longest-substring-without-repeating-characters
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        int point = -1;
        int longestLength = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i));
            }
            while (point < n && !set.contains(s.charAt(point))) {
                set.add(s.charAt(i));
                point++;
            }
            longestLength = Math.max(longestLength, point - i + 1);

        }

        return longestLength;
    }

    //#4 median-of-two-sorted-arrays/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length%2!=0){
        //奇数
        
        }else {
        //偶数

        }

        return 1.1;
    }



    //#6  z change
    public String convert(String s, int numRows) {

        //如果1行就是本体
        if(numRows == 1)
            return s;

        List<StringBuffer> rows = new ArrayList<StringBuffer>();

        //初始化row
        for(int i =0;i<Math.min(s.length(),numRows);i++){
            rows.add(new StringBuffer());
        }

        int curRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow==0|| curRow== numRows-1){
                goingDown = !goingDown;
            }
            curRow += goingDown?1:-1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<rows.size();i++){
            sb.append(rows.get(i));
        }

        return sb.toString();

    }



    //#7 reverse-integer 1534236469
    public int reverse(int x) {

        int rs = 0;
        try{
        while(x!=0){
            int pop = x%10;
            x=x/10;
            if(rs>Integer.MAX_VALUE/10 || (rs==Integer.MAX_VALUE/10 && pop>7)){
                return 0;
            }
            if(rs<Integer.MIN_VALUE/10 || (rs==Integer.MIN_VALUE/10 && pop<-8)){
                return 0;
            }
            rs=rs*10+pop;
        }
        return rs;
        }catch (Exception e){
            return 0;
        }

    }



}


