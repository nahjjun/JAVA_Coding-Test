package 코테교재문제;
import java.util.*;
public class 챕터10_문제32_영어끝말잇기 {
	public static int[] solution(int n, String[] words) {
		String prev = words[0];
		HashSet<String> wordSet = new HashSet<>();
		wordSet.add(prev); // 해시셋에 이전 단어 넣기
		int[] result = {0,0};
		
		for(int i=1; i<words.length; ++i) {
			if(prev.charAt(prev.length()-1) != words[i].charAt(0)
					|| wordSet.contains(words[i])) { // 만약 끝말이 처음 단어와 이어지지 않거나 이미 나왔던 단어라면
				// 결과 String에 몇번째 사람인지와 몇번째 단어인지를 설정하고 반복문을 종료한다
				result[0] = i%n+1;
				result[1] = i/n+1;
				break;
			}
			wordSet.add(words[i]); // 단어를 해시셋에 넣어주고
			prev = words[i]; // 이전 단어로 설정해준다
		}
		return result;
	}
	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick","know","wheel","land","dream","mother","robot","tank"};
		System.out.println(Arrays.toString(solution(n,words)));
	}
}
