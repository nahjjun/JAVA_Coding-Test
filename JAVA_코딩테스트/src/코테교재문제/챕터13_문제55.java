package 코테교재문제;

import java.util.Arrays;
import java.util.Comparator;

public class 챕터13_문제55 {
	public static String solution(int[] numbers) {
		// numbers 배열의 각 요소를 String으로 변환
		String[] s= new String[numbers.length];
		for(int i=0; i<numbers.length; ++i) {
			s[i] = new String();
			s[i] = String.valueOf(numbers[i]);
		}
		
		// s 배열을 내림차순으로 정렬. 이때, 기준은 제일 앞에 있는 숫자
		Arrays.sort(s, (o1,o2)-> (o2+o1).compareTo(o1+o2));
		// 반환값이 음수이면 첫번째 객체가 두 번째 객체보다 앞에 온다.
		if(s[0].equals("0")) return "0";
		
		//해당 배열의 값을 순서대로 이어붙인다.
		StringBuilder result = new StringBuilder();
		for(String tmp:s) {
			result.append(tmp);
		}
		
		return result.toString();
	}
	public static void main(String[] args) {
		int[] numbers = {3,30,34,5,9};
		System.out.println(solution(numbers));
	}
}
