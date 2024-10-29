package 코테교재문제;
import java.util.*;
public class 챕터8_문제24_메뉴리뉴얼 {
	public static String[] solution(String[] orders, int[] course) {
		HashSet<Character>[] customers = new HashSet[orders.length]; // 손님 수만큼 해시셑을 생성한다
		HashSet<String> result = new HashSet<>(); // 결과를 넣을 list
		HashSet<Integer> courseSet = new HashSet<>();
		for(int c:course) courseSet.add(c);
		
		// 각 손님별로 주문한 메뉴들을 각각의 해시셑에 넣는다.
		int i=0;
		for(String s:orders) { // s는 각 손님이 주문한 메뉴 String
			customers[i] = new HashSet<Character>(); // 손님별 메뉴를 저장할 HashSet을 동적할당
			for(int j=0; j<s.length(); ++j) customers[i].add(s.charAt(j)); // 각 손님의 메뉴들을 HashSet에 저장한다
			++i;
		}
		
		// 손님별로 주문한 메뉴들을 해시셑에 넣은 이후에, 각 손님마다 자신의 메뉴 구성이 다른 곳에 한 곳이라도 똑같이 존재하는지 확인한다.
		for(i=0; i<orders.length; ++i) { // i는 현재 검사할 손님의 인덱스
			for(int j=0; j<orders.length; ++j) { // j는 현재 검사할 손님을 제외한 다른 손님들을 가리킬 인덱스
				if(j == i) continue; // 손님 자기 자신이 주문한 메뉴는 검사하지 않는다.
				if(customers[i].size() > customers[j].size()) continue; // 자신보다 크기가 작은 메뉴 구성은 검사하지 않는다.
				
				boolean isFound = true;
				for(int a=0; a<orders[i].length(); ++a) { // 현재 검사할 손님의 각 메뉴들이 다른 손님들의 HashSet에 존재하는지 확인한다
					if(!customers[j].contains(orders[i].charAt(a))) {
						isFound=false; // 만약 현재 검사할 손님의 메뉴가 다른 손님의 HashSet에 존재하지 않는 경우가 있다면, 해당 손님은 해당하지 않는다.
						break;
					}
				}
				if(isFound) { // 해당 메뉴 구성이 세트로 만들어질 수 있다면,
					result.add(orders[i]); // 결과 리스트에 더해준 뒤, 다음 손님의 메뉴 구성이 세트로 만들어질 수 있는지 검사하도록 한다.
					break;
				}
				else continue; // 해당 메뉴 구성이 세트로 만들어질 수 없다면, 다음 손님과 비교하러 간다.
			}
		}
		
		// 검사가 완료되었다면, course 배열에 있는 길이와 동일하지 않은 경우를 제외한다
		for(String s:result) {
			if(courseSet.contains(s.length())) continue; // 만약 해당 길이에 해당한다면 지나침
			result.remove(s);
		}
		String[] tmp = result.toArray(new String[0]);
		Arrays.sort(tmp);
		return tmp; // List<String>을 String[]으로 바꾸는 방법
	}
	public static void main(String[] args) {
		String []orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
		
	}
}
