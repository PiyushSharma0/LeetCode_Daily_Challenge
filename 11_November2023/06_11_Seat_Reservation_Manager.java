// Link: https://leetcode.com/problems/seat-reservation-manager/
// Difficulty: Medium
// Time complexity: O(log n) for reserve() and O(1) for unreserve()
// Space complexity: O(n)

import java.util.HashSet;
import java.util.PriorityQueue;

class SeatManager {
    private PriorityQueue<Integer> availableSeats;  // Min-heap to store available seats
    private HashSet<Integer> reservedSeats;  // Set to store reserved seats
    
    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        reservedSeats = new HashSet<>();
        
        for (int i = 1; i <= n; i++) {
            availableSeats.offer(i);  // Initially, all seats are available, so add them to the min-heap.
        }
    }
    
    public int reserve() {
        if (!availableSeats.isEmpty()) {
            int seatNumber = availableSeats.poll();  // Get the smallest unreserved seat.
            reservedSeats.add(seatNumber);  // Reserve the seat.
            return seatNumber;
        } else {
            return -1;  // No available seats left.
        }
    }
    
    public void unreserve(int seatNumber) {
        if (reservedSeats.contains(seatNumber)) {
            reservedSeats.remove(seatNumber);  // Unreserve the seat.
            availableSeats.offer(seatNumber);  // Add the seat back to the available seats.
        }
    }
}