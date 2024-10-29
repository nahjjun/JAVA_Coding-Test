package 코테교재문제;
import java.util.*;
public class 챕터5_문제7_방문길이 {
	public static int solution(String _dirs) {
		int[][] array = new int[10][10]; // 좌표판 
		int count=0; // 개수
		
		int x=5, y=5;
		int length = _dirs.length();
		
		for(int i=0; i<length; ++i) {
			int xPlus=1, yPlus=1;
			int xPost=x, yPost=y;			
			switch(_dirs.charAt(i)) {
			case 'U':
				y += yPlus;
				break;
			case 'D':
				y -= yPlus;
				break;
			case 'R':
				x += xPlus;
				break;
			case 'L':
				x -= xPlus;
				break;
			}
			if(x<0) {
				x += xPlus;
				continue;
			}
			else if(x>10) {
				x -= xPlus;
				continue;
			}
			else if(y<0) {
				y += yPlus;
				continue;
			}
			else if(y>10) {
				y -= yPlus;
				continue;
			}	
			if(array[x][y] == 0 || array[xPost][yPost] == 0) {
				array[x][y] = 1;
				++count;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		String s = "ULURRDLLU";
		System.out.println(solution(s));
	}
}
