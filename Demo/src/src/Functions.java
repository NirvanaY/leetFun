package src;

import java.util.HashMap;

public class Functions {


// no 12 罗马数字转整数
	public int romanToInt(String s) {

		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char cc = s.charAt(i);
			switch (cc) {
			case 'I':
				sum = sum + 1;
				break;
			case 'V':
				sum = sum + 5;
				break;
			case 'X':
				sum = sum + 10;
				break;
			case 'L':
				sum = sum + 50;
				break;
			case 'C':
				sum = sum + 100;
				break;
			case 'D':
				sum = sum + 500;
				break;
			case 'M':
				sum = sum + 1000;
				break;
			}

			if (cc == 'I' && i < (s.length() - 1)
					&& (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
				sum = sum - 2;
			}

			else if (cc == 'X' && i < (s.length() - 1)
					&& (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
				sum = sum - 20;
			}

			else if (cc == 'C' && i < (s.length() - 1)
					&& (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
				sum = sum - 200;
			}

		}

		return sum;

	}

    // No 594
    // 2147 ms	39.9 MB
    public int findLHS1(int[] nums) {
        int max = 0;
        int count = 0;
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                int diff = nums[i]-nums[j];
                if( diff==1){
                    flag =true;
                    count++;
                }else if(diff ==0){
                    count++;
                }
            }
            if(flag  && max<count){
                max = count;
            }
            count = 0;
            flag =false;
        }

        return  max;
    }


    //2420 ms	40.5 MB
    public int findLHS2(int[] nums) {
        int max = 0;
        int count = 0;
        int value =0;
        int valcount=0;
        boolean flag=false;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == value && valcount >0 ){

            } else {
                for (int j = 0; j < nums.length; j++) {
                    int diff = nums[i] - nums[j];
                    if (diff == 1) {
                        flag = true;
                        count++;
                    } else if (diff == 0) {
                        count++;
                    }
                }
                if (flag && max < count) {
                    max = count;

                    if(value != nums[i]){
                        value = nums[i];
                        valcount=1;
                    }{
                        valcount++;
                    }

                }
                count = 0;
                flag = false;

            }
        }
        return  max;
    }

    public int findLHS3(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rs = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                rs = Math.max(rs,map.get(key)+map.get(key+1));
            }
        }


        return rs;
    }
}
