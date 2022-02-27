// Integer N을 입력 받아 가장 긴 1 ~ 1의 가장 긴 0을 찾는 문제.
// Integer.toBinaryString()이 중요.

package Lesson01;

class Solution {
    public int solution(int N) {
        String[] binary = Integer.toBinaryString(N).split("");

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < binary.length; i++) {
            if(binary[i].equals("0")) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 0;
            }
        }

        return ans;
    }
}
