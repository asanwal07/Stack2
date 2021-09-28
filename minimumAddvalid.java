// Q.LEETCODE 921. Minimum Add to Make Parentheses Valid.
/*
 * 1: Given a string S of '(' and ')' parentheses. 2: You need to find count of
 * minimum number of parentheses '(' or ')' when added in any positions so that
 * the resulting parentheses string is valid. Example 1: Input: s = "())"
 * Output: 1 Example 2: Input: s = "(((" Output: 3 Example 3: Input: s = "()"
 * Output: 0 Example 4: Input: s = "()))((" Output: 4
 */

/**
 * SIMPLE APPROACH ->> Minimum Add to Make Parentheses Valid HAI TOH VALID VALO
 * KO HTA DE JITNE BRACKET BCHE UTNE ADDTION KRNI 
 * E.G. Input: s = "())" {1 VALID
 * PART HAI ISME USEY REMOVE KRU TO BCHA EK INVALID UTNE HI REQUIRED HAI TO MAKE
 * IT VALID} 
 * E.G. 2 s = "()))((" {SAME ISME HAI 4 ADD KRNE PDENGAY}
 */

// Simple approach ->>
// You can approach this problem by using stack but it can take O(n) space .so instead of using stack we can do this only using 2 variables open and ans.
// //Take two variables open and answer . Now iterate through the given array and increment open if we encounter opening bracket . Now check in else condition that if any closing bracket comes and if there is any open bracket for it then decrease the count of open otherwise if open count is zero that means we have encountered the invalid bracket so increment answer variable .
// At last add open in the answer beacuse if there are any opening bracket that doesnt find their closing pair that makes it invalid so we will increase it answer.//
import java.io.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class Main {
      public static int minAddToMakeValid(String S) {
            Stack<Character> st = new Stack<>();
            // ist approach using stack<<--{
            // for (int i = 0; i < S.length(); i++) {
            // char ch = S.charAt(i);

            // if (ch == '(') {
            // st.push(ch);
            // } else {
            // if (st.size() > 0 && st.peek() == '(') {
            // st.pop();
            // } else {
            // st.push(ch);
            // }
            // }

            // }
            // }-->>
            int open = 0;
            int ans = 0;
            for (char ch : S.toCharArray()) {
                  if (ch == '(') {
                        open++;
                  } else {
                        if (open > 0) {
                              open--;
                        } else {
                              ans++;
                        }
                  }
            }
            ans += open;
            return ans;
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            int result = minAddToMakeValid(read.readLine());
            System.out.println(result);
      }
}