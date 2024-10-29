package 코테교재문제;
import java.util.*;
public class 챕터12_문제46_N퀸 {
	public static boolean [][]chess;
	public static int count;
	public static int solution(int n) {
		chess = new boolean[n][n];
		count = 0;
		for(int i=0; i<n; ++i)
			for(int j=0; j<n; ++j)	
				backtracking(n, i, j);
		
		return count;
	}
	public static void backtracking(int n, int row, int col) {
		if(chess[row][col]) return; // 해당 칸이 갈 수 없는 칸이면 함수 종료
		++count; // 해당 칸이 비어있으면 카운트 증가
		chess[row][col]=true; // 퀸 배치
		// 해당 퀸이 갈 수 있는 길은 전부 true로 바꾸어준다.
		fillBlock(n, row, col);
	
	}
	public static void fillBlock(int n, int row, int col) { // 해당 좌표에서 퀸이 갈 길을 true 처리해주는 함수 -> 자신보다 다음에 있는 칸들만 채우면 됨
		for(int i=row+1; i<n; ++i) chess[i][col] = true; // 같은 열에 있는 칸을 true 처리
		for(int i=col+1; i<n; ++i) chess[row][i] = true; // 같은 행에 있는 칸을 true 처리
		for(int i=row, j=col; i<n && j<n; ++i, ++j) chess[i][j] = true; // 우측으로 내려가는 대각선상에 있는 칸을 true 처리
		for(int i=row, j=col; i<n && j>=0; ++i, --j) chess[i][j] = true; // 좌측으로 내려가는 대각선상에 있는 칸을 true 처리
	}
	public static void main(String[] args) {
		int n=4;
		System.out.println(solution(n));
		
	}
}
