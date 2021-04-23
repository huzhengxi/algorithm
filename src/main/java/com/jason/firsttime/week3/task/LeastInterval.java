package com.jason.firsttime.week3.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 621. 任务调度器
 */
public class LeastInterval {

  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> freq = new HashMap<Character, Integer>();
    for (char c : tasks) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    //任务总数
    int m = freq.size();
    List<Integer> nextValid = new ArrayList<Integer>();
    List<Integer> rest = new ArrayList<Integer>();
    Set<Entry<Character, Integer>> entrySet = freq.entrySet();
    for (Map.Entry<Character, Integer> entry : entrySet) {
      int val = entry.getValue();
      nextValid.add(1);
      rest.add(val);
    }
    int time = 0;
    for (int i = 0; i < tasks.length; i++) {
      ++time;
      int minNextValid = Integer.MAX_VALUE;
      for (int j = 0; j < m; j++) {
        if (rest.get(j) != 0) {
          minNextValid = Math.min(minNextValid, nextValid.get(j));
        }
      }
      time = Math.max(time, minNextValid);
      int best = -1;
      for (int j = 0; j < m; j++) {
        if (rest.get(j) != 0 && nextValid.get(j) <= time) {
          if (best == -1 || rest.get(j) > rest.get(best)) {
            best = j;
          }
        }
      }
      nextValid.set(best, time + n + 1);
      rest.set(best, rest.get(best) - 1);
    }
    return time;
  }

  public static void main(String[] args) {
    LeastInterval interval = new LeastInterval();
    char[] task = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    int n = 2;
    System.out.println(interval.leastInterval(task, n));
  }
}
