// A(1), C(2), G(3), T(4)로 이루어진 DNA에서 각 구간의 최소 DNA 값을 구하는 문제
// N이 100,000, M이 50,000이기 때문에 O(N*M)은 당연히 정답이 될 수 없다.
// IndexTree를 사용하면 O(MlogN)의 시간복잡도로 해결할 수 있다.
// IndexTree에서 부모 노드의 값을 최소값으로 가지고 있으면
// 좌측 구간에서는 우측 노드일 때, 우측 구간에서는 좌측 노드일 때 최소값을 계속 갱신하면서 제일 상위 노드까지 올라가면 된다.

package Lesson05_PrefixSums;

import java.util.*;

class Solution {

    static int nLeaf;
    static int[] tree, ans;

    public int[] solution(String S, int[] P, int[] Q) {
        char[] dnaChar = new char[S.length()];
        int[] dna = new int[S.length()];

        dnaChar = S.toCharArray();
        for(int i = 0; i < dna.length; i++) {
            if(dnaChar[i] == 'A') dna[i] = 1;
            else if(dnaChar[i] == 'C') dna[i] = 2;
            else if(dnaChar[i] == 'G') dna[i] = 3;
            else  dna[i] = 4;
        }

        // 최하위 노드값 구하기
        nLeaf = 1;
        while(nLeaf < dna.length) {
            nLeaf *= 2;
        }
        
        tree = new int[nLeaf * 2]; // Tree 만들기
        Arrays.fill(tree, 5); // 기본값을 최대값으로 설정

        for(int i = 0; i < dna.length; i ++) {
            set(i, dna[i]); // 구간 최소값 갱신
        }

        ans = new int[P.length];
        for(int i = 0; i < P.length; i++) {
            ans[i] = get(P[i], Q[i]); // 구간 최소값 가져오기
        }

        return ans;
    }

    static void set(int idx, int val) {
        idx += nLeaf;
        tree[idx] = val;

        while(idx > 1) {
            idx /= 2;
            tree[idx] = Math.min(tree[idx * 2], tree[idx * 2 + 1]);
        }
    }

    static int get(int left, int right) {
        left += nLeaf;
        right += nLeaf;

        int ret = Integer.MAX_VALUE;
        while(left <= right) {
            if(left % 2 == 1) {
                ret = Math.min(ret, tree[left++]);
            }

            if(right % 2 == 0) {
                ret = Math.min(ret, tree[right--]);
            }

            left /= 2;
            right /= 2;
        }

        return ret;
    }
}
