// 주어진 배열에서 3개의 요소를 곱해 가장 큰 수를 구하는 문제.
// 배열의 마지막 3개를 곱하는 경우와
// [-5, 5, -5, 4] 케이스처럼 음수 2개 * 최대 양수도 케이스가 될 수 있음.

package Lesson06_Sorting;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        int N = A.length - 1;
        int ans = A[N] * A[N - 1] * A[N - 2];        
        if(A[0] <= 0 && A[1] <= 0 && A[N] > 0) {
            ans = Math.max(ans, A[0] * A[1] * A[N]);
        } 

        return ans;
    }
}

