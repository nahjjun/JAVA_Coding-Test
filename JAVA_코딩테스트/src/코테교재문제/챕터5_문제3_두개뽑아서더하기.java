package 코테교재문제;

import java.util.*;

public class 챕터5_문제3_두개뽑아서더하기 {
	public static int[] solution(int[] _arr) {
		HashSet<Integer> h = new HashSet<Integer>();
		for(int i=0; i<_arr.length; ++i) {
			for(int j=i+1; j<_arr.length; ++j) {
				h.add(_arr[i]+_arr[j]);
			}
		}
		int[] result = h.stream().sorted().mapToInt(Integer::intValue).toArray();
		return result;
	}
	public static void main(String[] args) {
		int[] arr = {2,1,3,4,1};
		
		int[] result = solution(arr);
		System.out.print(Arrays.toString(result));
	}
}
