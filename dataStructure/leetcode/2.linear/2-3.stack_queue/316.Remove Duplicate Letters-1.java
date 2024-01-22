import java.util.*;

class Solution {
	public static Set<Character> toSortedSet(String s) {
		Set<Character> set = new TreeSet<>((o1, o2) -> Character.compare(o1, o2));
		for (int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));
		return set;
	}

	public static String removeDuplicateLetters(String s) {
		for (char c : toSortedSet(s)) {
			String suffix = s.substring(s.indexOf(c));

			if (toSortedSet(s).equals(toSortedSet(suffix))) {
				return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
			}
		}
		return "";
	}
}

// Set<Character> set = new TreeSet<>(new Comparator<Character>() {

// 	@Override
// 	public int compare(Character o1, Character o2) {
// 		if (o1 == o2)
// 			return 0;
// 		else if (o1 > o2)
// 			return 1;
// 		else
// 			return -1;
// 	}
// });