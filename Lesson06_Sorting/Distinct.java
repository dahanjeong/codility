// 구분되는 숫자의 개수를 구하는 문제.
// Set 자료 구조 활용

package Lesson06_Sorting;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }

        return numbers.size();
    }
}
