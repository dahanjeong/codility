// 쌍을 가지지 않는 숫자를 출력하는 문제
// Set 자료구조를 중복을 확인
// Set에 있으면 => pair로 Set의 값 삭제
// Set에 없으면 => Set의 추가

package Lesson02;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> pairs = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
            if(pairs.contains(A[i])) {
                pairs.remove(A[i]);
            } else {
                pairs.add(A[i]);
            }
        }

        return pairs.iterator().next();
    }
}
