// LEETCODE 946. Validate Stack Sequences

// take elements from pushed array and keep pushing it into the stack and at the same time check it with popped array that whether the element we want is present at peek of stack or not, if it is present pop the element and increment your j pointer (which is pointing to required element in popped element) .Now at last if j == length of pushed that means the answer is correct beacuse all elements are distinct and we have popped all the required element with help j pointer.

import java.io.*;
import java.util.*;

public class validateStackSeq {
      public static boolean validateStackSequences(int[] pushed, int[] popped) {
            int j = 0;

            Stack<Integer> st = new Stack<>();

            for (int e : pushed) {
                  st.push(e);

                  while (st.size() > 0 && st.peek() == popped[j]) {
                        st.pop();
                        j++;
                  }
            }
            return j == pushed.length;

      }

      public static int[] getArr(String s) {
            String nums[] = s.split(" ");
            int n = nums.length;
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                  ar[i] = Integer.parseInt(nums[i]);
            }
            return ar;
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            int pushed[] = getArr(read.readLine());
            int popped[] = getArr(read.readLine());

            boolean result = validateStackSequences(pushed, popped);

            System.out.println(result);
      }
}
