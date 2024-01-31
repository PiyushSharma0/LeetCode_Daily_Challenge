// Link: https://leetcode.com/problems/daily-temperatures/description/
// Difficulty: Medium
// Time Complexity: O(n)
// Space Complexity: O(1) if we don't count the answer array as that's just to return the result

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int hottest = 0;
        int answer[] = new int[n];
        
        for (int currDay = n - 1; currDay >= 0; currDay--) {
            int currentTemp = temperatures[currDay];

            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }
            
            int days = 1;
            while (temperatures[currDay + days] <= currentTemp) {
                days += answer[currDay + days];
            }
            answer[currDay] = days;
        }
        return answer;
    }
}
