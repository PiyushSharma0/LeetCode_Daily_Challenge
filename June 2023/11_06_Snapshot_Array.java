// Link: https://leetcode.com/problems/snapshot-array/
// Difficulty: Medium
// Time Complexity: O(logN) for set, O(1) for snap, O(logN) for get
// Space Complexity: O(N)

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> snapshots;
    private int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0); // Initialize with snap_id 0 and value 0
            snapshots.add(map);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> map = snapshots.get(index);
        map.put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> map = snapshots.get(index);
        Integer value = map.floorEntry(snapId).getValue();
        return value;
    }
}