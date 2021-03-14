package com.jason.week1;

import java.util.HashMap;
import java.util.Map;

/**
 *242. 有效的字母异位词
 */
public class IsAnagram {

  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    if (s.length() != t.length()) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) - 1);
      if (map.get(ch) < 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsAnagram isAnagram = new IsAnagram();

    System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
    System.out.println(isAnagram.isAnagram("rat", "cat"));
  }
}
