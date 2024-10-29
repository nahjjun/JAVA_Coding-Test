package 코테교재문제;
import java.util.*;
public class 챕터8_문제19_완주하지못한선수 {
	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> hMap = new HashMap<>();
		for(String s:participant) {
			if(hMap.containsKey(s)) { // 만약 이미 map에 동일한 이름의 참가자가 있다면
				hMap.put(s,hMap.get(s)+1); // 해당 참가자의 value값을 +1 해줌으로써 인원수를 늘린다.
			}
			else { // map에 동일한 이름의 참가자가 없을 때
				hMap.put(s, 1); // 참가자 이름을 key로 넣고 value값으로 인원수를 넣는다.
			}
		}
		for(String s:completion) {
			if(hMap.get(s) == 1) { // 만약 해당 이름의 참가자가 한명인 경우
				hMap.remove(s); // map에서 해당 참가자를 제외시킨다
			}
			else { // 해당 이름의 참가자가 한명 이상인 경우
				hMap.put(s,hMap.get(s)-1); // 해당 참가자의 인원수를 감소시킨다. 
			}
		}
		String result = new String();
		for(String key:hMap.keySet()) {
			result = key;
		}
		return result;
	}
	
}
