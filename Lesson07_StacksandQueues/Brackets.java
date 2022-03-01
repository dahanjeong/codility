// String S가 ( ), { }, [ ]이 대칭으로 이루어졌는지 확인하는 문제.
// 하나의 (, {, [가 나오면 반드시 먼저 동일한 ), }, ]가 나와야 대칭.
// 중간에 ) )와 같이 stack이 비어있는 케이스가 있기 때문에 else 구문에서 stack의 크기 확인 필요.

package Lesson07_StacksandQueues;

import java.util.*;


class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();        

        if(S.length() % 2 != 0) return 0;
        
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if(stack.isEmpty()) return 0;
                
                char last = stack.pop();
                if(c == ')' && last != '(') return 0;
                else if(c == '}' && last != '{') return 0;
                else if(c == ']' && last != '[') return 0;
            }            
        }

        if(!stack.isEmpty()) return 0;

        return 1;
    }
}
