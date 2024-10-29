package 코테교재문제;
import java.util.*;

public class 챕터5_문제5_행렬의곱셈 {
	public static int[][] solution(int[][] _arr1, int[][] _arr2) {
		int[][] result = new int[_arr1.length][_arr2[0].length];
		for(int i=0; i<_arr1.length; ++i) { // 앞 행렬의 행
			for(int j=0; j<_arr2[0].length; ++j) { // 뒷 행렬의 열
				int sum=0;
				for(int k=0; k<_arr1[0].length; ++k) {
					sum += _arr1[i][k]*_arr2[k][j];
				}
				result[i][j] = sum;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		int[][] arr3 = {{2,3,2},{4,2,4},{3,1,4}};
		int[][] arr4 = {{5,4,3},{2,4,1},{3,1,1}};
		
		int[][] result = solution(arr3, arr4);
		for(int i=0; i<result.length; ++i) {
			System.out.print(Arrays.toString(result[i])+'\n');
		}
	}
}
