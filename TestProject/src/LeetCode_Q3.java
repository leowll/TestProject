import java.util.HashMap;
/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
public class LeetCode_Q3 {

	public static void main(String[] args) {
		String s = "abccdefggh";
		int len = lengthOfLongestSubstring(s);
		System.out.println(len);
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length(); ++i) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}
}
