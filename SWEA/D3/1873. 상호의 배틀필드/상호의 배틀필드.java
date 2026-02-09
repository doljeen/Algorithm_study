import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static char[][] map;
	public static int row, col, H, W;
	public static char current;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				map[i] = str.toCharArray();
			}
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^') {
						row = i;
						col = j;
						current = map[i][j];
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] active = str.toCharArray();
			
			for(int i = 0; i < N; i++) {
				switch(active[i]) {
				case 'U':
					current = '^';
					if(row-1<0 || map[row-1][col] == '#' || map[row-1][col] == '-' || map[row-1][col] == '*') {
						map[row][col] = '^';
					} else {
						map[row][col] = '.';
						row--;
						map[row][col] = '^';
					}
					break;
				case 'D':
					current = 'v';
					if(row+1>=H || map[row+1][col] == '#' || map[row+1][col] == '-'|| map[row+1][col] == '*') {
						map[row][col] = 'v';
					} else {
						map[row][col] = '.';
						row++;
						map[row][col] = 'v';
					}
					break;
				case 'L':
					current = '<';
					if(col-1 < 0 || map[row][col-1] == '#' || map[row][col-1] == '-'|| map[row][col-1] == '*') {
						map[row][col] = '<';
					} else {
						map[row][col] = '.';
						col--;
						map[row][col] = '<';
					}
					break;
				case 'R':
					current = '>';
					if(col+1 >= W || map[row][col+1] == '#' || map[row][col+1] == '-'|| map[row][col+1] == '*') {
						map[row][col] = '>';
					} else {
						map[row][col] = '.';
						col++;
						map[row][col] = '>';
					}
					break;
				case 'S':
					shoot();
					break;
				}
			}
			System.out.print("#" + test_case + " ");
			for(int k = 0; k < H; k++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[k][j]);
				}
				System.out.println();
			}
			
		}
	}
	private static void shoot() {
		int r = row;
		int c = col;
		if(current == '<') {
			if(col - 1 < 0) {
				return;
			}
			while (c >= 0) {
			    if (map[row][c] == '*') {
			        map[row][c] = '.';
			        break;
			    } else if (map[row][c] == '#') {
			        break;
			    }
			    c--;
			}
			
		} else if(current == '>') {
			if(col + 1 >= W) {
				return;
			}
			while(c < W) {
				if(map[row][c] == '*') {
					map[row][c] = '.';
					break;
				} else if(map[row][c] == '#'){
					break;
				}
				c++;
			}
		} else if(current == '^') {
			if(row - 1 < 0) {
				return;
			}
			while(r >= 0) {
				if(map[r][col] == '*') {
					map[r][col] = '.';
					break;
				} else if(map[r][col] == '#'){
					break;
				}
				r--;
			}
		} else {
			if(row + 1 >= H) {
				return;
			}
			while(r < H) {
				if(map[r][col] == '*') {
					map[r][col] = '.';
					break;
				} else if(map[r][col] == '#'){
					break;
				}
				r++;
			}
				
		}
	}

}
