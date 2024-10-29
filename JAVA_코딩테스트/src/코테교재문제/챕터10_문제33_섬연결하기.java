package 코테교재문제;
import java.util.*;
public class 챕터10_문제33_섬연결하기 {
	public static int solution(int n, int[][] costs) {
		int minLine = n-1; // 최소 간선 개수 설정
		Queue<ArrayList<Integer>> queue = new ArrayDeque<>(); // 각 노드들을 서로 잇는 경우의 수를 모두 담을 큐
		HashSet<Integer> set = new HashSet<>();
		int minCost=0; // 최소비용
		
		while(true) { // 각 최소 간선 개수만큼 costs 배열에서 선들의 경우들을 뽑는다
			set.clear();
			for(int i=0; i<n; ++i) set.add(i); // 모든 노드들이 연결되었는지 확인하기 위한 해시셋 설정
			queue.clear();
			pick(costs.length, minLine, 0, new ArrayList<Integer>(), queue); // 모든 경우의 수를 뽑아서 queue에 저장함
			while(!queue.isEmpty()) { // 큐가 빌때까지 반복문 진행
				ArrayList<Integer> tmp = queue.poll();
				int cost=0;
				for(int t:tmp) { // 각 인덱스를 돌면서 들어있는 노드들은 셋에서 지우고, 비용을 측정한다.
					cost += costs[t][2];
					if(set.contains(costs[t][0])) set.remove(costs[t][0]);
					if(set.contains(costs[t][1])) set.remove(costs[t][1]);
				}
				if(set.isEmpty()) { // 모든 노드를 연결하는데 성공한 경우
					if(minCost==0) minCost=cost;
					else minCost = Math.min(minCost, cost); // 최소값을 갱신해줌
				}
			}
			if(minCost==0) minLine++;
			else break;
		}
		return minCost;
	}
	// 모든 경우의 수를 뽑는 함수 (지피티 돌림)
	// n은 costs의 길이(선의 개수), minLine은 뽑아야될 개수, start는 조합을 시작할 배열의 인덱스 
	public static void pick(int n, int minLine, int start, ArrayList<Integer> tmp, Queue<ArrayList<Integer>> queue) {
		if(minLine==0) {
			queue.add(new ArrayList<>(tmp));
			return;
		}
		for(int i=start; i<=n-minLine; ++i) {
			tmp.add(i);
			pick(n, minLine-1, i+1, tmp, queue);
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		int n=4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(n,costs));
	}
}
