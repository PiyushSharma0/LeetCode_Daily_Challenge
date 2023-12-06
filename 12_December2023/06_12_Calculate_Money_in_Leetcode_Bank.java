class Solution {
  public int totalMoney(int n) {
    // Calculate the number of complete weeks and the remaining days
    final int weeks = n / 7;
    
    // Calculate the sum of the trapezoidal numbers for the first week
    final int firstWeek = trapezoid(1, 7);
    
    // Calculate the sum of the trapezoidal numbers for the last full week
    final int lastFullWeek = trapezoid(1 + weeks - 1, 7 + weeks - 1);
    
    // Calculate the sum of the trapezoidal numbers for the remaining days
    final int remainingDays = trapezoid(1 + weeks, n % 7 + weeks);
    
    // Calculate the total money using the trapezoidal number formula
    return (firstWeek + lastFullWeek) * weeks / 2 + remainingDays;
  }

  // Returns the sum of trapezoidal numbers from 'a' to 'b'.
  private int trapezoid(int a, int b) {
    return (a + b) * (b - a + 1) / 2;
  }
}
