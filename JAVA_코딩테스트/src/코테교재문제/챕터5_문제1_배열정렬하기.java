package 코테교재문제;

import java.util.Arrays;

public class 챕터5_문제1_배열정렬하기 {
	public static int[] solution(int[] _arr) {
		Arrays.sort(_arr);
		return _arr;
	}
	public static void main(String[] args) {
		int[] arr = {5,1,2,8,21,3,4};
		int[] clone = arr.clone();
		clone = solution(clone);
		System.out.print(Arrays.toString(arr)+'\n');
		System.out.print(Arrays.toString(clone));
	}
}
