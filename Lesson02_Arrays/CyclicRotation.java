// Integer로 구성된 Array에서 K만큼 index를 이동시키는 문제
// index+K가 배열의 크기를 초과하면 나머지 연산자를 이용

package Lesson02_Arrays;

class Solution {
    public int[] solution(int[] A, int K) {
        int[] ans = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            if(i + K >= A.length) {
                ans[(i + K) % A.length] = A[i];
            } else {
                ans[i + K] = A[i];
            }
        }

        return ans;
    }
}
