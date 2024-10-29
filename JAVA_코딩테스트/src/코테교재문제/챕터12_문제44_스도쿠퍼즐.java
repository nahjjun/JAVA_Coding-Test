package 코테교재문제;
import java.util.*;
public class 챕터12_문제44_스도쿠퍼즐 {
	public static class Block{
		public int r, c;
		public Block(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static int[][] solution(int[][] b){
		int[][] board = b;
		findSolution(board);
		return board
				;
	}
	public static boolean canIn(int[][] board, int num, int row, int col) { // 해당 자리에 들어갈 수 있는지 확인하는 함수
		return !(isInRow(board, num,row) || isInCol(board, num,col) || isInBox(board, num, row, col));
	}
	public static boolean isInRow(int[][] board, int num, int row) { // 해당 행에 해당 숫자가 존재하는지 검사하는 함수
		for(int target:board[row]) {
			if(target == num) return true;
		}
		return false;
	}
	public static boolean isInCol(int[][] board, int num, int col) { // 해당 열에 해당 숫자가 존재하는지 검사하는 함수
		for(int i=0; i<9; ++i) {
			if(board[i][col] == num) return true;
		}
		return false;
	}
	public static boolean isInBox(int[][] board, int num, int row, int col) {
		int startRow=(row/3)*3;
		int startCol=(col/3)*3;
		
		for(int r=startRow; r<startRow+3; ++r) {
			for(int c=startCol; c<startCol+3; ++c) {
				if(board[r][c]==num) return true;
			}
		}
		return false;
	}
	
	public static Block findEmptyBlock(int[][] board) { // board에 빈 블럭이 있는지, 만약 있다면 해당 블럭을 반환하는 함수 
		for(int i=0; i<9; ++i) {
			for(int j=0; j<9; ++j) {
				if(board[i][j]==0) return new Block(i,j);
			}
		}
		return null;
	}
	public static boolean findSolution(int[][] board) {
		Block block = findEmptyBlock(board);
		if(block==null) return true; // 빈 공간이 없다면 true 반환
		int row = block.r;
		int col= block.c;
		for(int i=1; i<=9; ++i) {
			if(canIn(board, i, block.r, block.c)) {
				board[row][col]=i;
				if(findSolution(board)) return true; // 빈 공간이 없으면 재귀를 종료시킨다
				board[row][col]=0; // 가능한 숫자가 없으면 원래의 0으로 되돌린다.
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] board = {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
		};
		int[][] result = solution(board);
		Arrays.stream(result).forEach(row->System.out.println(Arrays.toString(row)));
	}
}