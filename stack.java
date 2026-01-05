package week7;

import java.util.*;
public class stack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(5);
        s.add(15);
        s.add(25);
        s.add(35);
        s.add(45);
        System.out.println(s);
        s.push(12);
        s.push(22);
        s.push(32);
        System.out.println(s);
        Stack<Integer> peekstack =new Stack<>();
         peekstack.add(100);
         peekstack.add(200);
         peekstack.add(300);
         peekstack.add(400);
         System.out.println(peekstack.peek());
         Stack<Integer> searchstack = new Stack<>();
         searchstack.add(10);
         searchstack.add(20);
         searchstack.add(30);
         searchstack.add(40);
         searchstack.add(50);
         int pos=searchstack.search(30);
     if(pos!=-1){
        System.out.println(pos);
     }else{
        System.out.println("element not found");
     }
     Stack<String> estack = new Stack<>();
           estack.push("apple");
           estack.push("banana");
           estack.push("orange");
           System.out.println(estack.isEmpty());
           String input ="HASINI";
           Stack<Character> c = new Stack<>();
           for(char ch:input.toCharArray()){
            c.push(ch);
           }
           StringBuilder reverse = new StringBuilder();
           while(!c.isEmpty()){
            reverse.append(c.pop());
           }
           System.out.println(reverse);
    }
}