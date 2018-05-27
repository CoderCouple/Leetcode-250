package Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> PreReqGraph = new HashMap<Integer, Set<Integer>>();
		Map<Integer, Set<Integer>> PostReqGraph = new HashMap<Integer, Set<Integer>>();
		int[] result = new int[numCourses];
		int newNode = 0;
		int toBeProcessed = 0;

		for (int row = 0; row < prerequisites.length; row++) {
			if (PreReqGraph.containsKey(prerequisites[row][0])) {
				Set<Integer> set = PreReqGraph.get(prerequisites[row][0]);
				set.add(prerequisites[row][1]);
				PreReqGraph.put(prerequisites[row][0], set);
			} else {
				Set<Integer> set = new HashSet<Integer>();
				set.add(prerequisites[row][1]);
				PreReqGraph.put(prerequisites[row][0], set);
			}

			if (PostReqGraph.containsKey(prerequisites[row][1])) {
				Set<Integer> set = PostReqGraph.get(prerequisites[row][1]);
				set.add(prerequisites[row][0]);
				PostReqGraph.put(prerequisites[row][1], set);
			} else {
				Set<Integer> set = new HashSet<Integer>();
				set.add(prerequisites[row][0]);
				PostReqGraph.put(prerequisites[row][1], set);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			Set<Integer> set = new HashSet<Integer>();
			if (!PreReqGraph.containsKey(i))
				PreReqGraph.put(i, set);

			if (!PostReqGraph.containsKey(i))
				PostReqGraph.put(i, set);
		}

		for (Map.Entry<Integer, Set<Integer>> entry : PreReqGraph.entrySet()) {
			if (entry.getValue().isEmpty())
				result[newNode++] = entry.getKey();
		}

		if (newNode == 0)
			return false;

		while (toBeProcessed < newNode) {
			int key = result[toBeProcessed];
			PreReqGraph.remove(key);
			Set<Integer> set = PostReqGraph.get(key);
			for (int item : set) {
				Set<Integer> s = PreReqGraph.get(item);
				s.remove(key);
				if (s.isEmpty())
					result[newNode++] = item;
			}
			toBeProcessed++;
		}

		if (PreReqGraph.isEmpty())
			return true;
		else
			return false;
	}
}
