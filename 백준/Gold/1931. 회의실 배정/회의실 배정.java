import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Meeting implements Comparable<Meeting>{
		int start, end;
		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Meeting o) {
			// 종료시간이 빠른순
			int diff = Integer.compare(this.end, o.end);
			if(diff != 0) return diff;
			// 종료시간이 같다면 시작시간이 빠른 순
			return Integer.compare(this.start, o.start);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());
	}
	static List<Meeting> getSchedule(Meeting[] meetings){
		List<Meeting> list = new ArrayList<>();
		Arrays.sort(meetings);
		list.add(meetings[0]);
		for(int i = 1; i < meetings.length; i++) {
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}

}
