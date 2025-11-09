package Etapa3;

public class Etapa3 {
    public boolean checkBrackets(StaticStack s1) {
        StaticStack temp = new StaticStack(s1.numElements());
        int openCount = 0, closeCount = 0;
        while (!s1.isEmpty()) {
            char c = (char) s1.pop();
            temp.push(c);
            if (c == '(') openCount++;
            else if (c == ')') closeCount++;
        }
        if (openCount != closeCount) return false;
        StaticStack check = new StaticStack(temp.numElements());
        while (!temp.isEmpty()) {
            char c = (char) temp.pop();
            if (c == ')') {
                check.push(c);
            } else if (c == '(') {
                if (check.isEmpty()) return false;
                check.pop();
            }
        }
        return check.isEmpty();
    }
}