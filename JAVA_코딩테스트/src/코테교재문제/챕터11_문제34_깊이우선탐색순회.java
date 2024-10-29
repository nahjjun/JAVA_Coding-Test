package 코테교재문제;
import java.util.*;
public class 챕터11_문제34_깊이우선탐색순회 {
	public static int[] solution(int[][] graph, int start, int n) {
		ArrayList<Integer>[] array = new ArrayList[n+1]; // 각 노드가 가리키는 노드를 갖고있는 리스트 배열
		boolean[] visited = new boolean[n+1]; // 해당 노드를 방문했는지 확인
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0; i<n+1; ++i) {
			array[i] = new ArrayList<>();
			visited[i] = false;
		}
		
		for(int[] i:graph) array[i[0]].add(i[1]); // 각 노드를 연결해준다.
		
		Stack<Integer> stack = new Stack<>(); // DFS를 위한 스택을 선언한다.
		stack.push(start);
		visited[start] = true;
		while(!stack.isEmpty()) { // 스택이 빌 때까지 반복(노드를 전부 탐색하기 전까지 반복)
			int popped = stack.pop();
			result.add(popped);
			for (int i = array[popped].size() - 1; i >= 0; --i) {
                int nextNode = array[popped].get(i);
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                    visited[nextNode] = true; // 스택에 넣는 즉시 방문 처리
                }
            }
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		int[][] graph = {{1,2},{1,3},{2,4},{2,5},{3,6},{5,6}};
		int start = 1;
		int n=6;
		System.out.println(Arrays.toString(solution(graph, start, n)));
	}
}
