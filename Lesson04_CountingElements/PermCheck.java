// Array A가 순열을 이루는지 확인하는 문제.
// A를 정렬한 뒤, A[가장 마지막]이 배열 A의 크기보다 크면 불가
// A[i]가 i+1이 아니면 불가

package Lesson04;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);

        if(A[A.length - 1] >  A.length) return 0;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) return 0;
        }

        return 1;
    }
}
