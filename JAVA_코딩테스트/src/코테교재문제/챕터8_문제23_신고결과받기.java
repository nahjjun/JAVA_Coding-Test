package 코테교재문제;
import java.util.*;
public class 챕터8_문제23_신고결과받기 {
	public static int[] solution(String[] id_list, String[] report, int k) {
		HashMap<String, Integer> id_reportedCountMap = new HashMap<>(); // 해당 아이디가 몇번 신고당했는지 기록하는 해시맵
		HashMap<String, ArrayList<String>> id_reportedIdListMap = new HashMap<>(); // 해당 아이디가 어떤 아이디들을 신고했는지 기록하는 해시맵
		ArrayList<Integer> result = new ArrayList<>();
		
		// 각 Map들을 초기화해준다.
		for(String s:id_list) {
			id_reportedCountMap.put(s, 0); // 각 아이디별 신고 횟수 0으로 초기화
			id_reportedIdListMap.put(s, new ArrayList<String>()); // 각 아이디별 신고 아이디 배열 선언 및 초기화
		}
		
		// report 배열을 읽기 시작한다.
		for(String s:report) {
			String[] command = s.split(" "); // 공백을 기준으로 명령어를 하나씩 읽는다
			// 신고당한 아이디가 해당 아이디로부터 이미 신고당했는지 확인한다.
			if(!id_reportedIdListMap.get(command[0]).contains(command[1])) { // 신고한 아이디를 key로 한 value 리스트에 신고당한 아이디가 포함되어있지 않은 경우(신고를 당하지 않은 경우)
				id_reportedCountMap.put(command[1], id_reportedCountMap.get(command[1])+1); // 신고당한 아이디의 신고 횟수를 증가시킴
				ArrayList<String> tmp = id_reportedIdListMap.get(command[0]); // 신고한 아이디의 value 리스트를 가져온다
				tmp.add(command[1]); // 해당 리스트에 신고당한 아이디를 추가한다
				id_reportedIdListMap.put(command[0], tmp); // 다시 리스트를 넣어준다.
			}
		}
		
		// id 리스트를 돌면서 id_reportedCountMap의 value값이 k 미만인 경우는 해시맵에서 제거한다
		for(String s:id_list) {
			if(id_reportedCountMap.get(s) < k) id_reportedCountMap.remove(s); 
		}
		
		// 다시 id 리스트를 돌면서, id_reportedIdListMap의 value 리스트에 있는 신고한 아이디들이 id_reportedCountMap에 존재하는지 확인한다.
		for(String s:id_list) {
			ArrayList<String> tmp = id_reportedIdListMap.get(s); // 해당 아이디가 신고한 아이디 리스트를 가져온다
			int count=0;
			for(String n:tmp) {
				if(!id_reportedCountMap.containsKey(n)) continue; // 만약 해당 리스트에 있는 아이디가 id_reportedCountMap에 포함되어있지 않으면(해당 아이디의 신고횟수가 k번 미만이면) result값을 증가시키지 않고 패스
				++count; // count값 증가
			}
			result.add(count); // count값 결과 list에 add
		}
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
