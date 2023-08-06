// Link: https://leetcode.com/problems/number-of-music-playlists/
// Difficulty: Hard
// Time Complexity: O(N * L) where N is the number of songs and L is the length of the playlist
// Space Complexity: O(N * L) since we use a 2D array of size N * L to store the result

class Solution {
    private static final int MOD = 1000000007;

    public int numMusicPlaylists(int totalSongs, int goal, int k) {
        // Create a 2D array to store the number of ways to create playlists
        // dp[i][j] represents the number of playlists of length i with j distinct songs
        long[][] dp = new long[goal + 1][totalSongs + 1];

        // Base case: There's only one way to create an empty playlist with no distinct songs
        dp[0][0] = 1;

        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= totalSongs; j++) {
                // Play a new song: Choose from the remaining (totalSongs - j + 1) songs
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * (totalSongs - j + 1)) % MOD;

                // Play a song that has been played before if enough distinct songs are available
                if (j > k) {
                    // Choose from the previous j songs that have already been played
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }

        // The result is stored in dp[goal][totalSongs], modulo 10^9 + 7
        return (int) dp[goal][totalSongs];
    }
}
