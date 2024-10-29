package 코테교재문제;
import java.util.*;
public class 챕터8_문제21_오픈채팅방 {
 public static StringBuilder[] solution(String[] record) {
	 List<String> command = new ArrayList<>(); // 명령어들을 넣는 리스트
	 List<String> id = new ArrayList<>(); // 유저 아이디를 넣는 리스트
	 HashMap<String, String> id_nicknameMap = new HashMap<>(); // 유저 아이디에 맞는  
	 
	 for(String s:record) {
		 // 주어진 명령어를 공백을 기준으로 분리한다.
		 String[] tmp = s.split(" ");
		 
		 if(tmp[0].equals("Change")) id_nicknameMap.put(tmp[1], tmp[2]); // 해당 아이디를 key로 닉네임을 저장
		 else if(tmp[0].equals("Leave")) {
			 command.add(tmp[0]); // 명령어 저장
			 id.add(tmp[1]); // 유저 아이디 저장
		 }
		 else if(tmp[0].equals("Enter")){
			 command.add(tmp[0]); // 명령어 저장
			 id.add(tmp[1]); // 유저 아이디 저장
			 id_nicknameMap.put(tmp[1], tmp[2]); // 해당 아이디를 key로 닉네임을 저장
		 }
	 }
	 
	 StringBuilder[] result = new StringBuilder[command.size()];
	 for(int i=0; i<command.size(); ++i) {
		 result[i] = new StringBuilder(); 
		 switch(command.get(i)) {
		 case "Enter":
			 result[i].append(id_nicknameMap.get(id.get(i))+"님이 들어왔습니다.");
			 break;
		 case "Leave":
			 result[i].append(id_nicknameMap.get(id.get(i))+"님이 나갔습니다.");
			 break;
		 default:
			 break;
		 }
	 }
	 return result;
 }
}
