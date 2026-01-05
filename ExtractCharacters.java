package week5;

public class ExtractCharacters {
    public static String extractChars(String input1, int input2, int input3) {
        String vowels = "aeiouAEIOU";
        StringBuilder extracted = new StringBuilder();
        
        for (char c : input1.toCharArray()) {
            if ((input2 == 1 && vowels.indexOf(c) != -1) || (input2 == 0 && vowels.indexOf(c) == -1)) {
                extracted.append(c);
            }
        }
        
        String result = extracted.toString();
        return (input3 == 1) ? result.toUpperCase() : result.toLowerCase();
    }
    
    public static void main(String[] args) {
        String input1 = "Hello World!";
        int input2 = 1;  // Extract vowels
        int input3 = 0;  // Convert to lowercase
        System.out.println(extractChars(input1, input2, input3)); // Output: "eoo"
    }
}


