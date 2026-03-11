import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static String[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        
        int T = Integer.parseInt(st.nextToken());
        
        go:for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine().trim());
            n = Integer.parseInt(st.nextToken());
            
            str = new String[n];
            
            Trie trie = new Trie();
            
            for (int i = 0; i < n; i++) {
            	str[i] = br.readLine();
            }
            
            for (int i = 0; i < n; i++) {
            	if (!trie.insertAndCheckPrefix(str[i])) {
            		System.out.println("NO");
            		continue go;
            	}
            }

            System.out.println("YES");
        }
    }

    static class TrieNode {
    	Map<Character, TrieNode> children = new HashMap<>();
    	boolean isEndOfWord = false;
    }
    
    static class Trie {
    	public TrieNode root = new TrieNode();
    	
    	public boolean insertAndCheckPrefix(String word) {
    		TrieNode curr = root;
    		for (int i = 0; i < word.length(); i++) {
    			char ch = word.charAt(i);
    			
    			if (curr.children.get(ch) == null) {
    				curr.children.put(ch, new TrieNode());
    			}
    			
    			curr = curr.children.get(ch);
    			
    			//이미 이전에 겹치는 단어가 있을 때
    			if (curr.isEndOfWord && i < word.length() - 1) return false;
    		}
    		
    		if (!curr.children.isEmpty()) return false;
    		if (curr.isEndOfWord) return false;
    		curr.isEndOfWord = true;
    		return true;
    	}
    }
    
}