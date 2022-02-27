// A~B 사이에서 K배수의 개수를 찾는 문제.
// K배수의 시작점을 찾고, 1~B의 K배수의 개수에서 1~A의 K배수를 빼고 +1을 해주면 된다.
// 제출했는데 [1, 1, 11] 케이스와 [0, 0, 1] 케이스가 있어서
// 마지막에 A와 B가 같고 K로 나누어지는 여부에 따라 예외처리 추가

package Lesson05_PrefixSums;

class Solution {
    public int solution(int A, int B, int K) {
        int start = 0;
        for(int i = A; i <= B; i++) {
            if(i % K == 0) {
                start = i;
                break;
            }
        }        
        
        if(A == B) {
            return A % K == 0 ? 1 : 0;
        }
         
        return B / K - start / K + 1;
    }
}
