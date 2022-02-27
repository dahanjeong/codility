// 배열 A에서 삼각형을 이루는 조건(두 변의 합이 하나의 변보다 항상 크다)이 되는지 확인하는 문제.
// 배열을 정렬하고 작은 두 변이 가장 긴 변보다 크면 삼각형 가능
// Element가 -Integer.MAX_VALUE ~ Integer.MAX_VALUE이기 때문에 long을 선언해서 확인

package Lesson06_Sorting;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        for(int i = 2; i < A.length; i++) {
            long a = A[i - 2];
            long b = A[i - 1];
            long c = A[i];

            if(a + b > c) return 1;
        }

        return 0;
    }
}
