// Q.LEETCODE 856. Score of Parentheses

/*
 * Given a balanced parentheses string s, return the score of the string.
 * 
 * The score of a balanced parentheses string is based on the following rule:
 * 
 * "()" has score 1. AB has score A + B, where A and B are balanced parentheses
 * strings. (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()" Output: 1 Example 2:
 * 
 * Input: s = "(())" Output: 2 Example 3:
 * 
 * Input: s = "()()" Output: 2 Example 4:
 * 
 * Input: s = "(()(()))" Output: 6
 */

/*SIMPLE QUESTION HAI HUMEY BUS SCORE BTANA HAI JO BRACKETS KO MILA K BNEGA UN NE DIA H SCORE KYA HOGA LIKE () ISKA 1 SCORE HAI , (()) ISKA 2 HAI SCORE 2*A VALI PROPERTY SE 
TOH BUS OPEN BRAC K LIE -1 SE NOTE KR TOH OPEN AYA TOH STACK MAI PUSH -1 AUR USKE CORRESPONDING AGR SATHI MILGYA CLOSING BRACKET TOH PHLE POP KR FIR USKI VALUE 1 PUSH KRDE AND CLSING
*/

import java.io.*;
import java.util.*;

public class Main {
      public static int scoreOfParentheses(String s) {
            Stack<Integer> st = new Stack<>();

            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                  if (s.charAt(i) == '(')
                        st.push(-1);
                  else {
                        if (st.peek() == -1) {
                              // -1 HAI MTLAB OPENING HAI ISS CLOSING K LIE TOH POP KRVA AUR ISKI VALUE DALDE
                              st.pop();
                              st.push(1);
                        } else {
                              // -1 NHI HAI ISKA MTLAB KI VALUES HAI PHLE SE HI TOH DO THE SAME UNTIL SIZE
                              // BECOME ZERO OR WE FOUND OPENING AND ADD IN VALUES AND PUSH TWICE OF IT INTO
                              // STACK (bcz of 2*A property).
                              val = 0;
                              while (st.size() > 0 && st.peek() != -1) {
                                    val += st.peek();
                                    st.pop();
                              }
                              st.pop();
                              st.push(2 * val);
                        }
                  }
            }
            // ye ()() is vale case ko handle krega jisme inn brackets ko kisi ne ni cover
            // toh unki value add krdo bus val mai.
            val = 0;
            while (st.size() > 0) {
                  val += st.peek();
                  st.pop();
            }
            return val;
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            int score = scoreOfParentheses(read.readLine());
            System.out.println(score);

      }
}
