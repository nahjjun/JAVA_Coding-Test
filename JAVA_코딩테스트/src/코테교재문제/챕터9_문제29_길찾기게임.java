package 코테교재문제;
import java.util.*;
import java.util.stream.*;

public class 챕터9_문제29_길찾기게임 {
	public static int[][] solution(int[][] nodeInfo){
		HashMap<Integer, ArrayList<Integer>> yMap = new HashMap<>(); // 각 y좌표별 노드의 x좌표를 저장하기 위한 해시맵
		HashMap<Integer, ArrayList<Integer>> xMap = new HashMap<>(); // 각 노드별로 연결된 좌,우 자식을 구분하기 위한 해시맵(연결되지 않은 상태이면 왼쪽 노드 자리에 값을 -1을 넣을 것이다)
		HashMap<Integer, Integer> compare = new HashMap<>();
		for(int i=0; i<nodeInfo.length; ++i) {
			compare.put(nodeInfo[i][0], i+1); // x좌표를 통해서 몇번 노드인지 알 수 있게 한다.
		}
		
		int maxY=0; // 가장 높은 y 좌표가 어디인지 알기 위한 변수
		
		for(int[] node:nodeInfo) { // 각 y 좌표별로 존재하는 노드들의 x좌표를 기록
			ArrayList<Integer> tmp;
			if(!yMap.containsKey(node[1])) tmp = new ArrayList<>();
			else tmp = yMap.get(node[1]);
			tmp.add(node[0]);
			yMap.put(node[1], tmp); // y좌표별 노드의 x좌표를 저장하는 리스트를 해시맵에 저장한다.
			maxY = Math.max(maxY, node[1]); // 최대 y 좌표를 갱신한다.
		}
		
		// 각 y좌표별 x 좌표 리스트를 오름차순으로 정렬해야한다
		yMap.forEach((key,value)->{ // HashMap의 forEach 함수를 통해서 각 entry를 순회한다.
			Collections.sort(value);
		});
		
		// y좌표가 큰 노드(상위 노드)부터 자신의 자식들을 구분한다.
		for(int i=maxY; i>=0; --i) {
			if(!yMap.containsKey(i)) continue; // 해당 y좌표대에 노드가 없으면 다음 y좌료대로 넘김
			
			ArrayList<Integer> parent = yMap.get(i); // 해당 y좌표가 갖고있는 x좌표의 리스트를 가져옴
			ArrayDeque<Integer> child = null;
			for(int j=i-1; j>=0; --j) { // 부모 노드의 자식이 될 y좌표 라인을 child 배열로 가져온다
				if(yMap.containsKey(j)) {
					ArrayList<Integer> tmp = yMap.get(j);
					child = tmp.stream().collect(Collectors.toCollection(ArrayDeque::new)); // stream을 활용해서 ArrayList를 ArrayDeque로 변경
					break;
				}
			}
			if(child==null) break; // 만약 자식이 될 y좌표 라인이 존재하지 않으면 반복문 종료
					
			for(int x:parent) { // 해당 x좌표 리스트를 돌면서 자식 노드들을 연결해야함
				// child deque에서 앞에서부터 값을 하나씩 빼면서 xMap의 각 노드에 연결한다
				if(!xMap.containsKey(x)) xMap.put(x, new ArrayList<Integer>()); // 해당 노드를 처음 연결하려면 리스트 생성
				
				while(!(child.isEmpty())) { // 자식으로 이을 노드가 다 떨어지면 연결 반복문 종료
					ArrayList<Integer> tmp = xMap.get(x);
					if(tmp.size() == 2) break; // 왼족, 오른쪽 노드가 전부 연결된 상태일 때 다음 노드로 변경
					if(tmp.size()==0 && child.peek()>x) { // 연결된 자식이 없는데 왼쪽 노드가 없으면 -1 추가
						tmp.add(-1);
						xMap.put(x, tmp);
					}
					tmp.add(child.poll());
					xMap.put(x, tmp);
				}
			}
			
		}
		
		// 각 노드들은 전부 연결되었기에, tree를 생성하고 전위, 후위 순회를 한다.
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		for(int i=0; i<maxY; ++i) {
			if(yMap.containsKey(i)) {
				
			}
			else tree.add(null);
		}
		
		
		
		
		
		
		return nodeInfo;
	}
	
	public static void main(String[] args) {
		int[][] nodeInfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};
		solution(nodeInfo);
	}
}
