// X 위치에서 D만큼 점프했을 때 Y 위치 이상까지 도달하는데 걸리는 횟수

package Lesson03;

class Solution {
    public int solution(int X, int Y, int D) {
        int ans = 0;
        int diff = Y - X;
        ans += diff / D;
        if(diff % D > 0) ans++;

        return ans;
    }
}
