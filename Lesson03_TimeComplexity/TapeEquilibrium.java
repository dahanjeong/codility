// P 인덱스를 기준으로 A[0] ~ A[P-1]의 합과 A[P] ~ A[N-1]의 합이 가장 작은 절대값을 찾는 문제
// 처음에 전체 Array 값을 다 더한 end를 구하고,
// 한 칸씩 전진하면서 end에서는 현재 값을 빼며 갱신하고,
// start는 더해주면서 갱신하고 비교.

package Lesson03;

class Solution {
    public int solution(int[] A) {
        int start = 0;
        int end = A[0];
        for(int i = 1; i < A.length; i++) {
            end += A[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < A.length; i++) {
            start += A[i - 1];
            end -= A[i - 1];

            ans = Math.min(ans, Math.abs(start - end));
        }

        return ans;
    }
}
