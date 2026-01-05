package week5;

public class LongestOddSequence {
    public static int sumOfLongestOddSequence(int[] arr) {
        int maxLen = 0, currentLen = 0, maxSum = 0, currentSum = 0;
        boolean hasOdd = false;

        for (int num : arr) {
            if (num % 2 != 0) { // Check if the number is odd
                hasOdd = true;
                currentLen++;
                currentSum += num;
            } else {
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxSum = currentSum;
                } else if (currentLen == maxLen) {
                    maxSum += currentSum;
                }
                currentLen = 0;
                currentSum = 0;
            }
        }

        // Final check in case the longest sequence is at the end
        if (currentLen > maxLen) {
            maxSum = currentSum;
        } else if (currentLen == maxLen) {
            maxSum += currentSum;
        }

        return hasOdd ? maxSum : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 9, 11, 4, 1, 1, 1, 6, 7, 3};
        System.out.println(sumOfLongestOddSequence(arr));
    }
}

