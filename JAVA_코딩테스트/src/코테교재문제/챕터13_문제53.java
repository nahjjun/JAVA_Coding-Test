package 코테교재문제;

import java.util.Arrays;

public class 챕터13_문제53 {
	public static long solution(int n) {
		String[] s = String.valueOf(n).split("");
		Arrays.sort(s,(o1,o2)->o2.compareTo(o1));
		StringBuilder ans = new StringBuilder();
		for(String tmp:s) {
			ans.append(tmp);
		}	
		
		return Long.parseLong(ans.toString());
	}
	public static void main(String[] args) {
		int n=118372;
		System.out.println(solution(n));
	}
}
