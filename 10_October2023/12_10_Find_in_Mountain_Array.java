// Link: https://leetcode.com/problems/find-in-mountain-array/
// Difficulty: Hard
// Time complexity: O(logn)
// Space complexity: O(1)

interface MountainArray {
    int get(int index);
    int length();
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // Find the peak (the highest element) in the mountain array
        int peakIndex = findPeak(mountainArr, n);
        
        // Perform a binary search on the left side of the peak
        int left = binarySearchLeft(mountainArr, target, 0, peakIndex);
        if (left != -1) {
            return left; // If found, return the index
        }
        
        // Perform a binary search on the right side of the peak
        int right = binarySearchRight(mountainArr, target, peakIndex + 1, n - 1);
        return right; // If found, return the index
    }
    
    // Find the index of the peak element in the mountain array
    private int findPeak(MountainArray mountainArr, int n) {
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int nextValue = mountainArr.get(mid + 1);
            
            if (midValue < nextValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left; // Return the index of the peak
    }
    
    // Binary search on the left side of the mountain
    private int binarySearchLeft(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            
            if (midValue == target) {
                return mid; // If found, return the index
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // If not found, return -1
    }
    
    // Binary search on the right side of the mountain
    private int binarySearchRight(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            
            if (midValue == target) {
                return mid; // If found, return the index
            } else if (midValue < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1; // If not found, return -1
    }
}
