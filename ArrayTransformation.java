package week5;

public class ArrayTransformation {
    public static int[] transformArray(int[] arr) {
        if (arr.length == 0) return new int[0];
        
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (arr[i] - min) * min;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 8, 3, 10};
        int[] transformedArr = transformArray(arr);
        for (int num : transformedArr) {
            System.out.print(num + " ");
        }
    }
}

