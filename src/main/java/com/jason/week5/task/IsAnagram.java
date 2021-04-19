package com.jason.week5.task;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram" 输出: true
 */
public class IsAnagram {

  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();

    for (char ch : s.toCharArray()) {
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (char ch : t.toCharArray()) {
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
    System.out.println(isAnagram.isAnagram("rat", "car"));
  }
}
