package 코테교재문제;
import java.util.*;
public class 챕터8_문제20_할인행사 {
	public static int solution(String[] want, int[] number, String[] discount) {
		HashMap<String, Integer> wantMap = new HashMap<>();
		int i=0;
		for(String s:want) { // want 배열로 HashMap을 제작한다
			wantMap.put(s, number[i++]); // 정현이가 원하는 제품과 그에 맞는 제품 개수를 넣어준다
		}
		
		// discount에서 순서대로 10개씩 빼서 각 경우의 수의 제품별 수량을 세기 위한 HashMap 배열
		int discountLength = discount.length;
		HashMap<String, Integer>[] discountMap = new HashMap[discountLength-9]; 
		
		for(int j=0; j<discountLength-9; ++j) {
			discountMap[j] = new HashMap<>();
			for(int c = j; c<j+10; ++c) { // 10개의 discount 원소들의 개수를 HashMap에 넣음으로써 센다.
				String currentKey = discount[c]; // discount에서 현재 제품
				if(discountMap[j].containsKey(currentKey)) { // discountMap이 해당 키(제품명)를 갖고있는 경우
					discountMap[j].put(currentKey, discountMap[j].get(currentKey)+1); // 개수를 하나 증가시켜준다.
				}
				else { // discountMap이 해당 키(제품명)를 갖고있지 않은 경우
					discountMap[j].put(currentKey, 1); // discountMap에 put해준다
				}
			}
		}
		
		int count=0; // 문제의 조건을 만족하는 날짜들을 세는 변수 
		for(HashMap<String, Integer> tmpMap:discountMap) {
			if(tmpMap.equals(wantMap)) ++count;
		}
		return count;
	}
	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		System.out.println(solution(want,number, discount));
		
	} 
}
