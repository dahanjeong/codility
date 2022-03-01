// Array A에서 A 배열 크기 절반 이상의 중복된 Integer가 있으면, 해당 Integer가 있는 인덱스 중 하나를 찾는 문제.
// A[i]가 가지고 있는 고유의 index와 value를 둘 다 가지는 Nums라는 자료형을 만들고,
// Nums의 index를 유지한 채 value만 비교하는 CompNums를 만들었다.
// numbers는 value기준으로 정렬이 되었기 때문에 for문을 돌면서 이전 값과 상이하면 그 당시의 cnt가 A.length/2인지 확인한다.

package Lesson08_Leader;

import java.util.*;

class Solution {
    static int N;
    static Nums[] numbers;

    public int solution(int[] A) {
        if(A.length == 0) return -1;
        if(A.length == 1) return 0;

        N = A.length;
        numbers = new Nums[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = new Nums(i, A[i]);
        }

        Arrays.sort(numbers, new CompNumbers());

        int cnt = 1;
        int ans = numbers[0].v;
        for(int i = 1; i < N; i++) {
            if(numbers[i-1].v == numbers[i].v) {
                cnt++;
                if(cnt > N/2) return numbers[i].i;
            } else {
                if(cnt > N/2) return ans;
                else {
                    cnt = 1;
                    ans = numbers[i].i;
                }
            }
        }

        return -1;
    }

    static class Nums {
        int i, v;
        Nums(int i, int v) {
            this.i = i;
            this.v  = v;
        }
    }

    static class CompNumbers implements Comparator<Nums> {
        @Override
        public int compare(Nums a1, Nums a2) {
            return a1.v - a2.v;
        }
    }
}

