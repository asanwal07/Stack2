// Q2.nextgreatertoleft

/*
 * 1. You are given a number n, representing the size of array a. 2. You are
 * given n numbers, representing elements of array a. 3. You are required to
 * find "next greater element on the left" for all elements of array 4. Input
 * and output is handled for you.
 * 
 * "Next greater element on the left" of an element x is defined as the first
 * element to left of x having value greater than x. Note -> If an element does
 * not have any element on it's left side greater than it, consider -1 as it's
 * "next greater element on left" e.g. for the array [2 5 9 3 1 12 6 8 7] Next
 * greater for 2 is -1 Next greater for 5 is -1 Next greater for 9 is -1 Next
 * greater for 3 is 9 Next greater for 1 is 3 Next greater for 12 is -1 Next
 * greater for 6 is 12 Next greater for 8 is 12 Next greater for 7 is 8
 */

/** same logic hai next greater to right ki just loop left se start krna hai isme**/

import java.io.*;
import java.util.*;

public class nextgreatertoleft {
      public static void display(int[] a) {
            StringBuilder sb = new StringBuilder();

            for (int val : a) {
                  sb.append(val + "\n");
            }
            System.out.println(sb);
      }

      public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                  a[i] = Integer.parseInt(br.readLine());
            }

            int[] ngl = solve(a);
            display(ngl);
      }

      public static int[] solve(int[] arr) {
            int[] ngel = new int[arr.length];

            Stack<Integer> st = new Stack<>();

            st.push(arr[0]);

            ngel[0] = -1;

            for (int i = 1; i < arr.length; i++) {

                  while (st.size() > 0 && st.peek() <= arr[i]) {

                        st.pop();
                  }

                  if (st.size() == 0) {
                        ngel[i] = -1;
                  } else {
                        ngel[i] = st.peek();
                  }

                  st.push(arr[i]);

            }

            return ngel;
      }

}
