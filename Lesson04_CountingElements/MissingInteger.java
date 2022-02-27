// Array A에서 가장 작은 양의 정수를 찾는 문제
// A의 최대값이 100만이라 count할 배열 선언
// 정렬한 A의 가장 마지막 값이 양수면, count 배열을 선언하고 A[i] 해당하는 위치에 cnt++;
// count 배열을 돌면서 0인 값을 찾으면 종료
// count 배열을 돌았는데도 ans가 갱신되지 않으면 A의 가장 마지막 양수 + 1
// A가 음수로만 이루어진 배열이면 1 return

package Lesson04;

import java.util.*;

class Solution {
    public int solution(int[] A) {        
        Arrays.sort(A);

        int ans = -1;
        int[] cnt;
        if(A[A.length - 1] > 0) {
            cnt = new int[A[A.length - 1] + 1];
            for(int i = 0; i < A.length; i++) {
                if(A[i] > 0) {
                    cnt[A[i]]++;
                }
            }

            for(int i = 1; i < cnt.length; i++) {
                if(cnt[i] == 0) {
                    ans = i;
                    break;
                }
            }

            if(ans == -1) ans = A[A.length - 1] + 1;
        }

        return ans == -1 ? 1 : ans;
    }
}
