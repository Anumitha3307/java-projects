package week9;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
      
        HashSet<String> student = new HashSet<>();
        student.add("Alice");
        student.add("Bob");
        student.add("Charlie");
        student.add("David");
        student.add("Alice"); 
        student.add("Eve");

        System.out.println("Student set: " + student);
        System.out.println("Size of Student set: " + student.size());

        System.out.println("Is Charlie in the set? " + student.contains("Charlie"));

        student.remove("Bob");
        System.out.println("After removing Bob: " + student);

        System.out.println("Size after removal: " + student.size());
        System.out.println("Is the set empty? " + student.isEmpty());

        System.out.println("Iterating using for-each loop:");
        for (String s : student) {
            System.out.println(s);
        }

        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = student.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashSet<String> newStudents = new HashSet<>();
        newStudents.add("Alice");
        newStudents.add("Eve");
        newStudents.add("Frank");

        HashSet<String> commonStudents = new HashSet<>(student);
        commonStudents.retainAll(newStudents);
        System.out.println("Common students: " + commonStudents);

        student.removeAll(commonStudents);
        System.out.println("Student set after removing common students: " + student);

        String[] studentArray = student.toArray(new String[0]);
        System.out.println("Student array: " + Arrays.toString(studentArray));

        
        student.clear();
        System.out.println("Student set after clearing: " + student);
    }
}
