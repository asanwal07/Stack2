
// public class minimumremove {

// }
// LEETCODE Q.1249. Minimum Remove to Make Valid Parentheses

/*
 * Given a string s of '(' , ')' and lowercase English characters.
 * 
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any
 * positions ) so that the resulting parentheses string is valid and return any
 * valid string.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, contains only lowercase characters, or It can be
 * written as AB (A concatenated with B), where A and B are valid strings, or It
 * can be written as (A), where A is a valid string.
 * adfaf
 * 
 * Example 1:
 * 
 * Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)"
 * , "lee(t(c)ode)" would also be accepted. Example 2:
 * 
 * Input: s = "a)b(c)d" Output: "ab(c)d" Example 3:
 * 
 * Input: s = "))((" Output: "" Explanation: An empty string is also valid.
 */
/*SAME APPROACH HAI JO LAST QUESTION MAI USEE KREE HAI */

import java.io.*;
import java.util.*;

public class minimumremove {
      public static String reverseParentheses(String s) {

            char chars[] = s.toCharArray();
            // string ko char array mai chnge kro.
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                  if (chars[i] == '(') {
                        st.push(i);
                        // OPENING ARA H MAST PUSH KRO
                  } else if (chars[i] == ')') {
                        // ST SIZE 0 HAI AND CLOSING AYA TOH SIMPLE INVALID USS JGH PE . dal de char ki
                        // array mai
                        if (st.size() == 0) {
                              chars[i] = '.';
                        } else {
                              st.pop();
                        }
                  }
            }

            while (st.size() > 0) {
                  chars[st.pop()] = '.';
            }

            StringBuilder sb = new StringBuilder();
            // string return toh isle ab stringbuilder bnale aur char array se answer nikal
            // le
            for (char c : chars) {
                  if (c != '.') {
                        sb.append(c);
                  }
            }
            return sb.toString();
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            String result = reverseParentheses(read.readLine());
            System.out.println(result);

      }
}
