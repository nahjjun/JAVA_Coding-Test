package 코테교재문제;
import java.util.*;
import java.util.Arrays;


public class 챕터5_문제2_배열제어하기 {
	public static Integer[] solution(int[] _arr) {
		/*
		 * _arr = Arrays.stream(_arr).distinct().toArray();
		Arrays.sort(_arr); 이건 가능.
		 */
		
		Integer[] arr = Arrays.stream(_arr).boxed().distinct().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = {5,1,2,8,8,8,2,21,3,4};
		Integer[] result = solution(arr);
		System.out.print(Arrays.toString(arr)+'\n');
		System.out.print(Arrays.toString(result));
	}
}
