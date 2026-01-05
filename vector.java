package week7;

import java.util.*;
public class vector {
    public static void main(String[] args) {
        Vector<Integer>  v = new Vector<>();
        v.add(5);
        v.add(15);
        v.add(25);
        v.add(35);
        v.add(45);
        System.out.println(v);
        v.remove(3);
        System.out.println(v);
        boolean contains60 = v.contains(60);
        System.out.println(contains60);
        Vector<String>  name = new Vector<>();
        name.add("Alice");
        name.add("charlie");
        name.add("david");
        name.add("bob");
        Collections.sort(name);
        System.out.println(name);
        for(String s: name){
            System.out.println(s);
        }
        System.out.println();
        System.out.println("using Listiterator: ");
        ListIterator<String> s1 = name.listIterator();
        while(s1.hasNext()){
            System.out.println(s1.next());
        }
    }
}
