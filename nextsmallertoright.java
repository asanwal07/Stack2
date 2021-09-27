// Q3.NEXTSMALLER TO RIGHT

// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to "next smaller element on the right" for all elements
// of array
// 4. Input and output is handled for you.

// "Next smaller element on the right" of an element x is defined as the first
// element to right of x having value smaller than x.
// Note -> If an element does not have any element on it's right side smaller
// than it, consider -1 as it's "next smaller element on right"
// e.g.
// for the array [2 5 9 3 1 12 6 8 7]
// Next smaller for 2 is 1
// Next smaller for 5 is 3
// Next smaller for 9 is 3
// Next smaller for 3 is 1
// Next smaller for 1 is -1
// Next smaller for 12 is 6
// Next smaller for 6 is -1
// Next smaller for 8 is 7
// Next smaller for 7 is -1

/*SAME APPROACH hai bus loop dekhna kis side se chalna ye dekhna hota**/

import java.io.*;
import java.util.*;

public class Main {
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

            int[] nge = solve(a);
            display(nge);
      }

      public static int[] solve(int[] arr) {
            int[] sr = new int[arr.length];

            Stack<Integer> st = new Stack<>();

            sr[arr.length - 1] = -1;

            st.push(arr[arr.length - 1]);

            for (int i = arr.length - 2; i >= 0; i--) {

                  while (st.size() > 0 && st.peek() >= arr[i]) {
                        st.pop();
                  }

                  if (st.size() == 0) {
                        sr[i] = -1;
                  } else {
                        sr[i] = st.peek();
                  }
                  st.push(arr[i]);

            }

            return sr;
      }

}