package 코테교재문제;
import java.util.*;
public class 챕터11_문제37_게임맵최단거리 {
	public static class Pair{
		public int x;
		public int y;
		public Pair(int _x, int _y) {
			x=_x;
			y=_y;
		}
	}
	public static ArrayList<Pair>[][] graph; // 각 노드가 움직을 수 있는 노드 위치를 pair객체 리스트로 담고 있는 2차원 배열
	public static boolean[][] visited;
	public static int solution(int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		graph = new ArrayList[n][m];
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j)
				graph[i][j] = new ArrayList<>();
		}
		visited = new boolean[n][m];
		
		int result=0;
		return result;
	}
	public static void buildGraph(int[][] maps, Pair current, int n, int m) { // 그래프 구축 함수
		if(maps[current.x][current.y] == 0) return; 
		
		
		
		
	}
}
