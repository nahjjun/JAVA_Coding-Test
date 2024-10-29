package 코테교재문제;
import java.util.*;
public class 챕터11_문제38_네트워크 {
	public static ArrayList<Integer>[] array;
	public static boolean visited[];
	public static int solution(int n, int[][] computers) {
		array = new ArrayList[n]; 
		for(int i=0; i<n; ++i) array[i] = new ArrayList<>();
		visited = new boolean[n];
		
		for(int i=0; i<n; ++i) {	// 인접 리스트 표현 방식으로 그래프 표현 
			for(int j=0; j<n; ++j) {
				if(i==j) continue;
				if(computers[i][j]==1) array[i].add(j);
			}
		}
		int count=0;
		for(int i=0; i<n; ++i) {
			if(!visited[i]) {
				dfs(i);
				++count;
			}
		}
		return count;
	}
	public static void dfs(int current) {
		visited[current] = true;
		for(int next:array[current]) {
			if(!visited[next]) dfs(next);
		}
	}
	public static void main(String[] args) {
		int n=3;
		int[][] computers= {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(n,computers));
	}
}
