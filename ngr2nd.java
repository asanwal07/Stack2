// Q.LEETCODE 503  Next Greater Element II

// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Example 1:

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.
// Example 2:

// Input: nums = [1,2,3,4,3]
// Output: [2,3,4,-1,4]

/* SAME QUESTION HAI NG TO RIGHT KI TRH BUS SUPPOSE KI ARRAY K LAST ELEMENT KO TU KAISE COMPARE KREGA->>>>> I=0 SE I=N-1 TK COMPARE KR SKTA TU FIRSE BCZ ARRAY KO HUM CIRCULAR TRATE KRRE HAI 
TOH LIKE WE DID IT IN NG TO RIGHT WE START THE LOOP FROM BACK,, IN THIS WE WILL RUN LOOP 2 TIMES 1.FROM N-2 TO 0 AND THEN FROM N-0 */
/**WHY WE DID SO BECAUSE N-1 VALE ELEMENT K LIE PHLE HI CALCULATE KRLE N-2 SE NGR NIKAL K KI KHI USSE BDA HAI KOI TOH VO STACK MAI HI RH JAEGAY */

import java.io.*;
import java.util.*;

public class Main {
    public static int[] nextGreaterElementII(int[] nums) {

        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        for (int i = nums.length - 2; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
        }
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(read.readLine());
        }

        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for (int e : ans) {
            System.out.println(e);
        }

    }
}