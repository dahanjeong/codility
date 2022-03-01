// '(', ')'로 이루어진 String S가 ()의 구조로 이루어져 있는지 확인하는 문제.
// 여는 괄호, 닫는 괄호를 각각 다른 큐에 담는데,
// 닫는 괄호가 더 많은데 나오면 ()의 구조가 될 수 없음.

package Lesson07_StacksandQueues;

import java.util.*;

class Solution {
    public int solution(String S) {
        if(S.length() % 2 != 0) return 0;

        Queue<Character> que1 = new LinkedList<>();
        Queue<Character> que2 = new LinkedList<>();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if(que1.size() < que2.size() && c == '(') return 0;
            else {
                if(c == '(') que1.add(c);
                else que2.add(c);
            }

        }

        if(que1.size() != que2.size()) return 0;

        return 1;        
    }
}
