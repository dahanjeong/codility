// A는 물고기의 크기, B는 물고기의 방향(상, 하)
// 물고기가 상, 하로 흐르다가 만날 때 더 큰 물고기가 작은 물고기를 잡아 먹는다.
// 살아있는 모든 물고기의 수를 구하는 문제.

// 하류로 내려가는 물고기를 Stack에 넣고,
// 상류로 올라가는 물고기를 만나면 Stack을 하나씩 꺼내면서 비교한다.

package Lesson07_StacksandQueues;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        
        int ans = 0;
        int j = 0;
        for(int i = 0; i < A.length; i++) {
            if(B[i] == 1) stack.push(A[i]);
            else {
                if(stack.isEmpty()) ans++;
                else {
                    while(!stack.isEmpty()) {
                        int size = stack.pop();
                        // Downstream 물고기가 Upstream 물고기보다 크면 다시 담는다.
                        if(size > A[i]) {
                            stack.push(size);
                            break;
                        }
                    }
                    // 모든 Stack을 제거한 Downstream 물고기
                    if(stack.isEmpty()) ans++;
                }
            }
        }
        
        ans += stack.size();

        return ans;
    }
}
