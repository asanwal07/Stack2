// public class removeoutermost {

// }
// LEETCODE Q.1021 Remove Outermost Parentheses
/*
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where
 * A and B are valid parentheses strings, and + represents string concatenation.
 * 
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses
 * strings. A valid parentheses string s is primitive if it is nonempty, and
 * there does not exist a way to split it into s = A + B, with A and B nonempty
 * valid parentheses strings.
 * 
 * Given a valid parentheses string s, consider its primitive decomposition: s =
 * P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 * 
 * Return s after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of s.
 * Example 1:
 * 
 * Input: s = "(()())(())" Output: "()()()" Explanation: The input string is
 * "(()())(())", with primitive decomposition "(()())" + "(())". After removing
 * outer parentheses of each part, this is "()()" + "()" = "()()()".
 */

/* SIMPLE LOGIC HAI AGR STACK SIZE ZERO HAI , OPENING BRACKET AYA TOH PUSH KRO USSEY BUT USS SE PHLE CHECK KRLE KI STACK SIZE 0 TOH NI HAI IF IT IS THAT MEANS KI VO OUTERMOST HAI USSEY SB(ANSWER) MAI ADD KRLE AND PUSH THE OPENING BRACKET SAME WITH CLOSING BRACKET AYA TOH POP KR CHECK KR SIZE ZERO HAI TO VO OUTERMOST HAI OTHERWISE NOT. */

import java.io.*;
import java.util.*;

public class Main {
      public static String removeOuterParentheses(String s) {
            Stack<Character> st = new Stack<>();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);

                  if (ch == '(') {
                        if (st.size() > 0) {
                              sb.append(ch);
                        }
                        st.push(ch);
                  } else {
                        st.pop();
                        if (st.size() > 0) {
                              sb.append(ch);
                        }

                  }
            }
            return sb.toString();
      }

      public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

            String result = removeOuterParentheses(read.readLine());
            System.out.println(result);
      }
}
