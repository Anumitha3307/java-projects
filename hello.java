package week6;

class hello extends Thread{
     @Override
     public void run(){
        System.err.println("hello world");
     }
     public static void main(String[] args){
      hello thread = new hello();
      thread.start();
     }
}
