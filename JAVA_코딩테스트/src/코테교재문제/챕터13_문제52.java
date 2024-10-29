package 코테교재문제;

import java.util.Arrays;
import java.util.Scanner;

public class 챕터13_문제52 {
	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (o1,o2) -> o1.charAt(n)==o2.charAt(n)? o1.compareTo(o2) :Character.compare(o1.charAt(n), o2.charAt(n)));
		return strings;
	}
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		int n = 2;
		String[] strings = {"sun", "bed", "car"};
		strings = solution(strings, n);
		for(String s:strings) {
			System.out.print(s + " ");
		}
		
		scan.close();
	}
}
