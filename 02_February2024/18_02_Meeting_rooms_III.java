// Link: https://leetcode.com/problems/meeting-rooms-iii/
// Difficulty: Hard
// Time Complexity: O(nlogn)
// Space Complexity: O(n)

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Meeting {
    public long endTime;
    public int roomId;

    public Meeting(long endTime, int roomId) {
        this.endTime = endTime;
        this.roomId = roomId;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];

        // Sort meetings based on their start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Priority queue to store occupied rooms based on meeting end time
        Queue<Meeting> occupiedRooms = new PriorityQueue<>((a, b) ->
                a.endTime == b.endTime ? Integer.compare(a.roomId, b.roomId) : Long.compare(a.endTime, b.endTime));

        // Priority queue to store available room IDs
        Queue<Integer> availableRoomIds = new PriorityQueue<>();

        // Initialize available room IDs
        for (int i = 0; i < n; ++i)
            availableRoomIds.offer(i);

        // Process each meeting
        for (int[] meeting : meetings) {
            final int start = meeting[0];
            final int end = meeting[1];

            // Free up rooms whose meetings have ended
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek().endTime <= start)
                availableRoomIds.offer(occupiedRooms.poll().roomId);

            if (availableRoomIds.isEmpty()) {
                // All rooms are occupied, delay the meeting and update the occupied rooms
                Meeting currentMeeting = occupiedRooms.poll();
                ++count[currentMeeting.roomId];
                occupiedRooms.offer(new Meeting(currentMeeting.endTime + (end - start), currentMeeting.roomId));
            } else {
                // Allocate an available room to the meeting
                final int roomId = availableRoomIds.poll();
                ++count[roomId];
                occupiedRooms.offer(new Meeting(end, roomId));
            }
        }

        // Find the room with the maximum booked meetings
        int maxIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
