package week10;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Java is great. Java is powerful. Java is popular!";
        
        // Convert text to lowercase and split words
        String[] words = text.toLowerCase().replaceAll("[^a-z ]", "").split(" ");
        
        // Create frequency map
        Map<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Print word frequencies without lambda expression
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
