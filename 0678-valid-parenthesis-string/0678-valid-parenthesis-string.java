class Solution {
   public boolean checkValidString(String s) {
    Stack<Integer> stackOpen = new Stack<>();
    Stack<Integer> stackStar = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            stackOpen.push(i);
        } else if (c == '*') {
            stackStar.push(i);
        } else { // c == ')'
            if (!stackOpen.isEmpty()) {
                stackOpen.pop();
            } else if (!stackStar.isEmpty()) {
                stackStar.pop();
            } else {
                return false; // no matching open parenthesis or star
            }
        }
    }
    // match remaining open parentheses and stars
    while (!stackOpen.isEmpty() && !stackStar.isEmpty()) {
        if (stackOpen.pop() > stackStar.pop()) {
            return false; // open parenthesis comes after star
        }
    }
    return stackOpen.isEmpty();
}}