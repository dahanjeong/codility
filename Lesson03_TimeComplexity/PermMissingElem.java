// 다른 Integer로 구성된 Array에서 빠진 숫자를 찾는 문제
// Array를 사전에 오름차순 정렬하고,
// index + 1 값과 다른 값 또는 -1을 유지하면 제일 마지막 숫자

package Lesson03;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        int ans = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }

        if(ans == -1) ans = A.length + 1;

        return ans;
    }
}

