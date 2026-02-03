import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int k= sc.nextInt();
		Queue <Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=n; i++)
		{
			queue.offer(i);
		}
		System.out.print("<");
		while(!queue.isEmpty())
		{
			for(int i=0; i<k-1; i++)
			{
				int temp = queue.poll();
				queue.offer(temp);
			}
			
			if(queue.size() == 1)
			{
				System.out.print(queue.poll()+">");
			}
			else
			{
				System.out.print(queue.poll()+", ");

			}
		}
		
	}

}
