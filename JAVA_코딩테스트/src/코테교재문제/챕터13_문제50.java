package 코테교재문제;
import java.util.*;
import java.util.stream.Collectors;
public class 챕터13_문제50 {
	public static String solution(String s) {
		int alpha[] = new int[26];
		for(char c:s.toCharArray()) {
			int idx = (int)(c-'a');
			alpha[idx]++;
		}
		ArrayList<Character> answer = new ArrayList<>();
		for(int j=0; j<alpha.length; ++j) {
			for(int i=0; i<alpha[j]; ++i) {
				answer.add((char)('a'+j));
			}
		}
		return answer.stream().map(String::valueOf).collect(Collectors.joining());
	}
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "algorithm";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}
}
