
import java.io.*;
import java.util.*;

public class trappingrainwater {
      public static int trap(int[] height) {
            int count = 0;
            int n = height.length;
            int left = 0, right = n - 1;
            int maxleft = 0, maxright = 0;

            while (left <= right) {
                  if (height[left] <= height[right]) {
                        if (height[left] >= maxleft)
                              maxleft = height[left];
                        else
                              count += maxleft - height[left];
                        left++;
                  } else {
                        if (height[right] >= maxright)
                              maxright = height[right];
                        else
                              count += maxright - height[right];
                        right--;
                  }
            }
            return count;
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(read.readLine());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                  arr[i] = Integer.parseInt(read.readLine());
            int result = trap(arr);
            System.out.println(result);

      }
}

/*
 * Brutforce Approch O(n^2) time complexity and O(1) Space Complexity In this
 * Solution, We simply find units of water trapped that means finding the amount
 * of individual water stored. We can think like we always choose minimum height
 * of maximum of left most building and maximum of rightmost building for that
 * given element. i.e min(left[i], right[i]) - arr[i] Time Complexity = O(n^2)
 * Space Complexity = O(1)
 * 
 * class Solution { public int trap(int[] height) { int count = 0; int n =
 * height.length(); for(int i=1;i<n-1;i++) { int left = height[i]; for(int
 * j=0;j<i;j++) { left = max(left,height[j]); }
 * 
 * int right = height[i]; for(int j=i+1;j<n;j++) { right =
 * Math.max(right,height[j]); } count += Math.min(left,right) - height[i]; }
 * return count; } } Better Solution Same as above logic but instead of going
 * for loops we store the maximum height of buildings in two arrays such as pre
 * and suf. In pre we store the maximum height from the leftmost part and for
 * suf array we store the maximum height from the rightmost part. For e.g Input
 * : height = [0,1,0,2,1,0,1,3,2,1,2,1] pre array for this input would be [
 * 0,1,1,2,2,2,2,3,3,3,3,3 ] suf array for this input would be [
 * 3,3,3,3,3,3,3,3,2,2,2,1 ] Time Complexity = O(n) Space Complexity = O(2n)
 * 
 * class Solution { public int trap(int[] height) { int count = 0; int n =
 * height.length; int[] pre = new int[n]; int[] suf = new int[n]; pre[0] =
 * height[0]; suf[n-1] = height[n-1]; for(int i=1;i<n;i++) { pre[i] =
 * Math.max(pre[i-1],height[i]); } for(int i = n - 2;i>=0;i--) { suf[i] =
 * Math.max(suf[i+1],height[i]); } for(int i=0;i<n;i++) { count +=
 * Math.min(pre[i],suf[i]) - height[i]; } return count;
 * 
 * } } Optimal Solution with two pointer Approch
 * 
 * Time Complexity = O(n) Space Complexity = O(1)
 * 
 * class Solution { public int trap(int[] height) { int count = 0; int n =
 * height.length(); int left = 0,right = n-1; int maxleft = 0, maxright = 0;
 * 
 * while(left <= right) { if(height[left] <= height[right]) { if(height[left] >=
 * maxleft) maxleft = height[left]; else count += maxleft - height[left];
 * left++; } else { if(height[right] >= maxright) maxright = height[right]; else
 * count += maxright - height[right]; right--; } } return count; } }
 */
// ->>>AISE YAAD RAKH KI LEFTMAX AND RIGHTMAX NIKALTE CHLTE RHTE HAILEFT VALI
// BULIDING CHOTI HUYI LEFTMAX SE TOH PANI TRAP HOGA AND SOON