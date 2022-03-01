// 배열 A에서 Leader가 있으면서 i위치에서 배열을 반으로 나누었을 때
// A[0] ~ A[i]에서 Leader의 개수가 절반 이상이고, A[i+1] ~ A[N-1]까지 Leader의 개수가 절반 이상이면
// Leader를 나눌 수 있는 구조라고 간주한다.
// Leader를 나눌 수 있는 구조의 개수를 구하는 문제

package Lesson08_Leader;

import java.util.*;

class Solution {    
    static Nums[] numbers;

    public int solution(int[] A) {
        if(A.length == 0 || A.length == 1) return 0;        

        numbers = new Nums[A.length];
        
        for(int i = 0; i < A.length; i++) {
            numbers[i] = new Nums(i, A[i]);
        }
        Arrays.sort(numbers, new CompNums());

        // Leader 찾기        
        int leader = numbers[0].v;
        int cnt = 1;
        boolean isLeader = false;
        for(int i = 1; i < A.length; i++) {            
            if(isLeader) { // 리더가 이미 나왔을 때
                if(numbers[i].v == numbers[i-1].v) cnt++; // 리더의 개수를 추가
                else break; // 정렬된 numbers이기 때문에 값이 다르면 for문 종료
            } else { // 리더가 정해지지 않았을 때
                if(numbers[i].v == numbers[i-1].v) {
                    cnt++;
                    if(cnt > A.length / 2) { // 리더인지 확인
                        isLeader = true;
                        leader = numbers[i].v;
                    }
                } else {
                    if(cnt > A.length / 2) { // 값이 다른데 리더의 조건을 갖췄으면, 기존 값이 leader가 됨
                        leader = numbers[i-1].v;
                        break;
                    } else {
                        leader = numbers[i].v; // 리더 갱신
                        cnt = 1;
                    }
                }
            }
        }
        
        if(cnt < A.length / 2) return 0;

        // leader가 있는 Position 기록(있으면 1, 없으면 0)
        int[] position = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            if(numbers[i].v == leader) position[numbers[i].i] = 1;
        }

        int ans = 0;
        int leftCnt = 0;
        int rightCnt = cnt;
        int leftLen = 0;
        int rightLen = A.length;
        for(int i = 0; i < A.length; i++) {
            leftCnt += position[i];
            rightCnt -= position[i];
            leftLen++;
            rightLen--;
            
            // 왼쪽의 Leader 개수가 왼쪽 길이 / 2보다 크고
            // 오른쪽의 Leader 개수가 오른쪽 길이 / 2보다 크면 만족
            if((leftCnt > leftLen/2) && (rightCnt > rightLen/2)) ans++;
        }      

        return ans;
    }

    static class Nums {
        int i, v;
        Nums(int i, int v) {
            this.i = i;
            this.v = v;
        }
    }

    static class CompNums implements Comparator<Nums> {
        @Override
        public int compare(Nums a1, Nums a2) {
            return a1.v - a2.v;
        }
    }
}

