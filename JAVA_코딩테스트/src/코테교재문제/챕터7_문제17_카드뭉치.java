package 코테교재문제;
import java.util.*;
public class 챕터7_문제17_카드뭉치 {
	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		Queue<String> q1 = new ArrayDeque<>();
		Queue<String> q2 = new ArrayDeque<>();
		for(String s:cards1) q1.add(s);
		for(String s:cards2) q2.add(s);
			
		for(String s:goal) {
			if(q1.isEmpty() && q2.isEmpty()) return "No"; // 두 큐가 전부 빈 경우
			else if(q1.isEmpty() || q2.isEmpty()) { // 두 큐 중에 한쪽만 빈 경우
				Queue<String> tmp;		// tmp에 비지 않은 큐를 받는다
				if(q1.isEmpty()) tmp = q2;
				else tmp = q1;
				if(!tmp.peek().equals(s)) return "No"; // 비지 않은 큐와 내용이 같지 않으면 No 반환
				tmp.poll();
			}
			else { // 두 큐 모두 비지 않은 경우
				if(q1.peek().equals(s)) q1.poll();
				else if(q2.peek().equals(s)) q2.poll();
				else return "No";
			}
		}
		return "Yes";
	}
	public static void main(String[] args) {
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		System.out.println(solution(cards1, cards2, goal));
	}
}
