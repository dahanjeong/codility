// H 배열을 지나면서 H[N-1] 높이를 만족시키는 블럭이 몇개인지 구하는 문제.
// Stack에는 높은 벽을 가지고 있으면,
// H[i]가 Stack의 벽보다 높으면, Stack에 추가
// H[i]가 Stack의 벽보다 낮으면, 블럭의 경계선이 되기 때문에 Stack을 꺼내면서 계속 비교

package Lesson07_StacksandQueues;

import java.util.*;

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        
        int ans = 0;
        stack.push(H[0]);
        for(int i = 1; i < H.length; i++) {                        
            while(!stack.isEmpty()) {
                int height = stack.peek();

                if(height > H[i]) {                        
                    ans++;
                    stack.pop();                    
                } else if(height < H[i]) {
                    stack.push(H[i]);
                    break;
                } else {
                    break;
                }
            }            

            if(stack.isEmpty()) stack.push(H[i]);
            
        }

        ans += stack.size();

        return ans;
    }
}