package 코테교재문제;
// 유니온-파인드 알고리즘을 활용하면, 각 노드의 루트 노드를 경로 압축이 된 파인드 알고리즘으로 찾았을 때 더욱 효율적으로 변한다
import java.util.*;
public class 챕터10_문제33_섬연결하기_2 {
	public static int[] set;
	public static int solution(int n, int[][] costs) {
		Arrays.sort(costs, (o1,o2)->Integer.compare(o1[2],o2[2])); // 비용을 기준으로 다리를 오름차순 정렬을 한다
		set = new int[n];
		for(int i=0; i<n; ++i) set[i]=i; // 집합 배열은 처음에 자기 자신을 부모로 갖는다.
		
		int totalCost=0; // 지금까지 쓴 비용
		int usedEdges=0; // 사용된 간선 개수
		
		for(int[] cost:costs) {
			int first = cost[0]; // 첫번째 노드
			int second = cost[1]; // 두번째 노드
			int price = cost[2]; // 비용
			
			if(find(first) != find(second)) { // 사이클이 존재하지 않도록 두 노드의 집합의 루트 노드가 같지는 않은지 확인한다.(루트 노드가 같으면 연결했을 때 불필요한 간선이 추가되기 때문)
				union(first,second);
				totalCost += price;
				++usedEdges;
			}
			if(usedEdges == n-1) break; // 최적의 간선 개수는 n-1개이므로, 해당 간선 개수에 도달하면 반복문을 종료하고 비용을 return한다.			
		}
		return totalCost;
	}
	public static int find(int n) { // n이 포함된 집합의 루트 노드 찾기
		if(set[n]==n) return n; // 부모값이 자기 자신인 노드에 도달하면 해당 노드값 반환(루트노드이기 때문임)
		return set[n] = find(set[n]); // 경로 압축(루트노드를 바로 자신의 부모 노드로 설정해줌으로써 경로를 압축시켜준다.)
	}
	public static void union(int n1, int n2) { // 두 노드를 연결(루트 노드를 같게 해주는)
		int root1 = set[n1];
		int root2 = set[n2];
		if(root1 != root2) set[root2] = root1; // 두 노드의 부모 노드가 같지 않다면 두 트리를 합친다. 
	}
}
