// 동쪽으로 여행하는 차와 서쪽으로 여행하는 차가 서로 마주치는 쌍이 몇 개인지 찾는 문제.
// 1을 만나면 1의 좌측에 있는 모든 0을 찾으면 되는 문제
// 배열을 순환하면서 0을 지속적으로 Count해준다.

package Lesson05_PrefixSums;

class Solution {
    public int solution(int[] A) {
        int ans = 0;
        int zero = 0;

        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) zero++;
            else ans += zero;

            if(ans > 1000000000 || ans < 0) {
                ans = -1;
                break;
            }
        }

        return ans;
    }
}
