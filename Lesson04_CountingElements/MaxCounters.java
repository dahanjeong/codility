// A[i]가 N보다 작으면, A[i]의 위치에 해당하는 값을 ++
// A[i]가 N+1이면, 현재 가장 큰 값으로 모두 갱신
// N이 10만이기 때문에 갱신 시에 N만큼의 for문을 이중으로 돌면 시간복잡도가 O(N2)이 되어 올바른 접근방법이 아님.
// max값을 가지고 있으면서 cnt[A[i]]에 해당 하는 값이 max보다 작으면 max+1로 자연스럽게 바꿔주고,
// N+1이면 현재 가장 큰 값인 update를 max에 넣어준다.
// 제일 마지막에 max보다 작은 값들은 모두 max로 갱신하면 시간 복잡도는 O(N+M)

package Lesson04;

class Solution {
    public int[] solution(int N, int[] A) {
        int[] cnt = new int[N];

        int update = 0;
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == N + 1) {
                max = update;
            } else {
                int pos = A[i] - 1;
                if(cnt[pos] < max) {
                    cnt[pos] = max + 1;
                } else {
                    cnt[pos]++;
                }

                if(cnt[pos] > update) {
                    update = cnt[pos];
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(cnt[i] < max) {
                cnt[i] = max;
            }
        }

        return cnt;
    }
}
