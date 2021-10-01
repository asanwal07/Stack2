// Leetcode 1190 || Reverse Substrings Between Each Pair Of Parentheses
/*
 * You are given a string s that consists of lower case English letters and
 * brackets.
 * 
 * Reverse the strings in each pair of matching parentheses, starting from the
 * innermost one.
 * 
 * Your result should not contain any brackets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(abcd)" Output: "dcba" Example 2:
 * 
 * Input: s = "(u(love)i)" Output: "iloveu" Explanation: The substring "love" is
 * reversed first, then the whole string is reversed. Example 3:
 * 
 * Input: s = "(ed(et(oc))el)" Output: "leetcode" Explanation: First, we reverse
 * the substring "oc", then "etco", and finally, the whole string.
 */

/* JO innermost bracket hai phle unko solve last 2 question jaise kie same vaisi approach hai. */

import java.io.*;
import java.util.*;

public class reversesubstring {
      public static String reverseParentheses(String s) {
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {

                  if (s.charAt(i) == ')') {
                        // q ki help li qki reverse krni thi stack mai pdi chiz
                        Queue<Character> q = new LinkedList<>();
                        while (st.peek() != '(') {
                              q.add(st.pop());
                        }
                        st.pop();
                        while (q.size() > 0) {
                              // reverse hora h yeh q se nikal ra agey se stack mai dalra fir
                              st.push(q.remove());
                        }

                  } else {
                        st.push(s.charAt(i));
                  }
            }
            char[] ans = new char[st.size()];
            int i = ans.length - 1;
            // char array bnali jo stack mai pda h pop krke piche se array mai dala and fir
            // ise string bna k return kr dia
            while (i >= 0) {
                  ans[i] = st.pop();
                  i--;
            }

            return new String(ans);
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            String result = reverseParentheses(read.readLine());
            System.out.println(result);

      }
}