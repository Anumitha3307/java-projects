package week7;

import java.util.*;
public class arraylist {
    public static void main(String[] args) {
     ArrayList<Integer> integer =  new ArrayList<>();
    integer.add(10);
    integer.add(20);
    integer.add(30);
    integer.add(40);
    integer.add(50);
    System.out.println(integer);
    integer.add(2, 25);
    System.out.println(integer);
    integer.remove(3);
    System.out.println(integer);
    boolean contains30 = integer.contains(30);
    System.out.println(contains30);
    Collections.sort(integer);
    Collections.reverse(integer);
    System.out.println(integer);
    }
}
