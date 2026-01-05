package week7;

public s2{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.addAll(Arrays.asList(5, 15, 25, 35, 45));
        System.out.println("Stack: " + stack);
        stack.push(12);
        stack.push(22);
        stack.push(32);
        System.out.println("After Pushing: " + stack);
        stack.pop();
        stack.pop();
        System.out.println("After Popping: " + stack);
        
        Stack<Integer> peekStack = new Stack<>();
        peekStack.addAll(Arrays.asList(100, 200, 300, 400));
        System.out.println("Top Element: " + peekStack.peek());
        
        Stack<Integer> searchStack = new Stack<>();
        searchStack.addAll(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Position of 30: " + searchStack.search(30));
        
        Stack<String> emptyStack = new Stack<>();
        System.out.println("Is Empty Initially: " + emptyStack.isEmpty());
        emptyStack.push("Apple");
        emptyStack.push("Banana");
        emptyStack.push("Cherry");
        System.out.println("Is Empty After Pushing: " + emptyStack.isEmpty());
        
        // Reverse a String using Stack
        String str = "STACK";
        Stack<Character> charStack = new Stack<>();
        for (char ch : str.toCharArray()) charStack.push(ch);
        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) reversed.append(charStack.pop());
        System.out.println("Reversed String: " + reversed);
        
        // Check for Balanced Parentheses
        System.out.println("Balanced ({}[])": " + isBalanced("({[]})"));
        System.out.println("Balanced ([{}])": " + isBalanced("([{}])"));
        System.out.println("Balanced ({[)]}": " + isBalanced("({[)]}"));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
     }
 }