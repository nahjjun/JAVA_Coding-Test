package 코테교재문제;
import java.util.*;
public class 챕터8_문제22_베스트앨범 {
	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> genresCount; // 각 장르별 재생 횟수를 저장하는 해시맵
		List<Map.Entry<String, Integer>> genresEntryList; // 장르별 재생 횟수를 기준으로 내림차순 정렬한 엔트리 리스트
		HashMap<String, ArrayList<Integer>> musicMap; // 각 장르별로 (key: 장르 이름, value: 노래 코드 배열)로 해서 저장할 map
		List<Integer> result = new ArrayList<>(); // return할 결과 배열
		
		genresCount = new HashMap<>(); // 각 장르별 재생 횟수를 저장하는 해시맵
		// 각 장르별로 HashMap을 통해 재생 횟수를 구한다.
		for(int i=0; i<genres.length; ++i) {
			String s = genres[i];
			if(genresCount.containsKey(s)) { // 해당 해시맵이 해당 장르를 포함하고 있다면, value값 증가시킴 
				genresCount.put(s, genresCount.get(s)+plays[i]);
			}
			else { // 해시맵이 해당 장르를 갖고있지 않다면, 해당 키의 value를 재생값으로 초기화 
				genresCount.put(s, plays[i]);
			}
		}
		
		// 해당 해시맵에서 entry값을 얻어와 리스트로 만든 뒤, 장르들을 value값 순서대로 내림차순 시킨다.
		genresEntryList = new ArrayList<>(genresCount.entrySet()); // 장르별 재생 횟수를 기준으로 내림차순 정렬한 엔트리 리스트
		Collections.sort(genresEntryList, new Comparator<Map.Entry<String, Integer>>() { 
			@Override
			public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) { // 각 엔트리의 value값을 기준으로 내림차순 시키기 위해 Comparator의 compare 함수를 오버라이딩해서 return값을 설정해준다
				return entry2.getValue().compareTo(entry1.getValue());
			}
		});
		
		// 각 장르별로 (key: 장르 이름, value: 노래 코드 배열)로 해서 map에 넣는다
		musicMap = new HashMap<String, ArrayList<Integer>>();
		for(int i=0; i<genres.length; ++i) {
			if(!musicMap.containsKey(genres[i])) { // 아직 맵에 해당 장르가 없는 경우
				ArrayList<Integer> musicList = new ArrayList<>(); // list를 만들어서
				musicList.add(i); // 해당 리스트에 노래 코드를 넣어주고
				musicMap.put(genres[i], musicList); // 맵에 장르와 함께 넣어준다.
			}
			else { // 맵에 해당 장르가 있는 경우
				ArrayList<Integer> tmp = musicMap.get(genres[i]); // 해당 장르의 리스트를 가져와서 
				tmp.add(i); // 노래 코드를 추가해주고
				musicMap.put(genres[i], tmp);	// 다시 맵에 해당 장르와 함께 넣어준다.
			}
		}
		
		// 장르별로 맵에 저장되어있는 노래 배열을 plays 배열(노래 재생 횟수)의 값을 기준으로 내림차순 정렬한다.
		for(Map.Entry<String, Integer> e:genresEntryList) {
			String genre = e.getKey(); // 장르명을 받아온다.
			ArrayList<Integer> musicList = musicMap.get(genre); // 해당 장르명에 저장되어있는 노래 리스트를 가져온다
			Comparator<Integer> c = new Comparator<Integer>() { // 내림차순 정렬을 시키기 위한 Comparator 객체 생성
				@Override
				public int compare(Integer o1, Integer o2) {
					Integer p1 = plays[o1];
					Integer p2 = plays[o2];
					return p2.compareTo(p1);
				}
			};
			musicList.sort(c); // 사용자 지정 Comparator로 내림차순 정렬한다.
			for(int i=0; i<2; ++i) {
				if(musicList.size()<2 && i==1) break; // 장르별 음악이 2개 미만인 경우는 1개나 0개만 결과 배열에 넣는다
				result.add(musicList.get(i)); // 내림차순으로 정렬되어있는 musicList의 
			}
		}
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500,600,150,800,2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
}
