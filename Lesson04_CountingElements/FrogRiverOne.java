// 개구리가 X위치까지 도달하는데, 1~X까지의 나뭇잎이 필요하다.
// X위치에 도달할 수 있는 가장 빠른 시간을 구하는 문제.
// Set 자료구조를 이용해서 1~X까지의 나뭇잎을 저장하고,
// Set의 크기가 X가 되면 모든 나뭇잎이 모이기 때문에 그 시점의 Array Index를 가져오면 됨.

package Lesson04;

import java.util.*;

class Solution {
    public int solution(int X, int[] A) {
        Set<Integer> leaves = new HashSet<>();

        int ans = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] <= X && !leaves.contains(A[i])) {
                leaves.add(A[i]);
            }

            if(leaves.size() == X) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}

