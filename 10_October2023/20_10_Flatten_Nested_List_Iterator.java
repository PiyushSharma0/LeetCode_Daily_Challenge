// Link: https://leetcode.com/problems/flatten-nested-list-iterator/
// Difficulty: Medium
// Time complexity: O(n)
// Space complexity: O(n)

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

interface NestedInteger {
  public boolean isInteger();

  public Integer getInteger();

  public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
  public NestedIterator(List<NestedInteger> nestedList) {
    addInteger(nestedList);
  }

  @Override
  public Integer next() {
    return q.poll();
  }

  @Override
  public boolean hasNext() {
    return !q.isEmpty();
  }

  private Queue<Integer> q = new ArrayDeque<>();

  private void addInteger(final List<NestedInteger> nestedList) {
    for (final NestedInteger ni : nestedList)
      if (ni.isInteger())
        q.offer(ni.getInteger());
      else
        addInteger(ni.getList());
  }
}