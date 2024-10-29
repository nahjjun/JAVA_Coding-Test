package 코테교재문제;
import java.util.*;
public class 챕터11_문제41_경주로건설 {
	public static class Node{
		public int nodeX, nodeY; // 노드 자기 자신의 번호
		public Node(int nX, int nY) {
			nodeX = nX;
			nodeY = nY;
		}
	}
	
	public static final int INF = Integer.MAX_VALUE; // 무한대 숫자
	public static final Node INFnode = new Node(INF,INF);
	public static final int[] mRows = {-1,1,0,0}; // 상하좌우
	public static final int[] mCols = {0,0,-1,1};
	
	public static int N; // 주어진 보드판의 면 길이
	public static boolean visited[][]; // 해당 노드가 방문한 노드인지 확인하기 위한 배열
	public static int leastPrice[][]; // 각 노드별 최소 비용
	public static Node prevNode[][]; // 코너인지를 확인하기 위한 이전 노드 저장 배열
	
	public static int solution(int[][] board) {
		PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->leastPrice[o2.nodeX][o2.nodeY] - leastPrice[o1.nodeX][o1.nodeY]); // 비용이 적은 노드부터 방문
		queue.add(new Node(0,0));
		visited[0][0] = true; 
		leastPrice[0][0] = 0;
		prevNode[0][0] = new Node(0,0);
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			for(int i=0; i<4; ++i) {
				int nextX = now.nodeX+mRows[i];
				int nextY = now.nodeY+mCols[i];
				
				if(nextX<0 || nextX>=N || nextY<0 || nextY>=N) continue; // 정해진 범위를 벗어나면 다음으로 건너뜀
				if(board[nextX][nextY]==1) continue; // 다음 위치가 벽이면 건너뜀
				if(visited[nextX][nextY]) continue; // 방문한 노드이면 건너뜀
				queue.add(new Node(nextX, nextY));
				visited[nextX][nextY] = true;
				
				
				
			}
			
			
		}
		
		
		return 1;
	}
	public static void init(int[][] board) {
		N= board.length; // 보드판 면 길이 초기화
		visited = new boolean[N][N]; // 해당 노드가 방문한 노드인지 확인하기 위한 배열 초기화
		
		leastPrice = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				leastPrice[i][j] = INF;
				prevNode[i][j] = INFnode;
			}
		}
		
	}
}
