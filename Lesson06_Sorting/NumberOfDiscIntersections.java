// 겹치는 원의 개수를 구하는 문제.
// 우측 경계의 최소값이 좌측 경계값보다 크면 겹치는 원
// 중복이 겹치지 않도록 i만큼 뺴줌.
// 어려움... 다른 코드 참고함 ㅠㅠ

package Lesson06_Sorting;

import java.util.*;

class Solution {    

    public int solution(int[] A) {
        int N = A.length;       
        long[] left = new long[N];
        long[] right = new long[N];
        
        for(int i = 0; i < N; i++) {
            left[i] = i - (long)A[i];
            right[i] = i + (long)A[i];
        }
        Arrays.sort(left);
        Arrays.sort(right);       

        int ans = 0;
        int j = 0;
        for(int i = 0; i < N; i++) {
            while(j < N && right[i] >= left[j]) {
                ans += j;
                ans -= i;
                j++;
            }
        }

        if(ans > 10000000) ans = -1;

        return ans;
    }
}
