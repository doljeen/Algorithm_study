import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		for(int i =0 ; i<n; i++)
		{
			Stack<Character> st= new Stack<>();
			String s;
			s = sc.next();
			int len = s.length();
			char arr[] = new char[len];
			arr = s.toCharArray();
			for(int j=0; j<len ; j++)
			{
				if(arr[j] == '(')
				{
					st.push('(');
				}
				else
				{
					if(st.isEmpty())
					{
						st.push(')');
						break;
					}
					else
					{
						st.pop();
					}
				}
			}

			if(st.isEmpty())
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			
		}
		
		
	}

}
