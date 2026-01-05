package week7;

import java.util.*;
public class linkedlist {
    public static void main(String[] args) {
      LinkedList<Integer> l = new LinkedList<>();
      l.add(10);
      l.add(20);
      l.add(30);
      l.add(40);
      l.add(50);
      System.out.println(l);
      l.add(2, 25);
      System.out.println(l);
      l.remove(3);
      System.out.println(l);
      boolean contains30 = l.contains(30);
      System.out.println(contains30);
      for (int i:l) {
          System.out.println(i);
      }
      ListIterator<Integer> it = l.listIterator();
      while(it.hasNext()){
        System.out.println(it.next());
      }
    }
}
