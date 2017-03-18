package CountingChoicesWithRecursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author leemartie
 *
 */
public class PalindromeSet {
	
	public HashMap<String, Integer> map = new HashMap<String, Integer>();
	public Set<Set<String>> found = new HashSet<Set<String>>();
	
	public String reverse(String word){
		return new StringBuilder(word).reverse().toString();
	}
	
	public boolean isPalindrom(String word){
		int size = word.length();		
		int half = word.length()/2;
		
		for(int i = 0; i<half; i++){
			
			int inc = i;	
			if(word.charAt(i) != word.charAt(size-inc-1)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		
		PalindromeSet ps = new PalindromeSet();
		String[] list = {"abc", "cba", "dog", "god", "potato", "burrito", "race", "car", "tat", "racef"};
		
		int min = -1;
		
		//put in a map and find the min O(n)
		for(int i = 0; i<list.length;i++){
			String word = list[i];
			ps.map.put(word, i);	
			if(min == -1 || min > word.length()){
				min = word.length();
			}
		}
		
		
		
		//do a hash map look up on reverse of each word and prefix of word up to min length, which would be O(n*d)
		//n is length of list
		//d is difference between largest word and smallest.
		for(int i = 0; i<list.length;i++){
			
			String wordf = list[i];
			String revf = ps.reverse(wordf);
			
			String word = wordf;
			String rev = revf;
			
			int size = word.length();
			
			while(size >= min){
				//is the reverse in the list
				Integer score = ps.map.get(rev);
			
				if(score != null && score != i && (ps.isPalindrom(rev+wordf) || ps.isPalindrom(wordf+rev))){
					Set<String> pair = new HashSet<String>();
					pair.add(wordf);
					pair.add(rev);
					ps.found.add(pair);
				
				}
				
				word = word.substring(0, word.length()-1);
				rev = ps.reverse(word);
				size = word.length();
			}
		}
		
		System.out.println(ps.found);

			
		}
	}
