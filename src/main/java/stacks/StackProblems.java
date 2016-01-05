package stacks;

import java.util.*;

/**
 * Created by saikris on 05/01/2016.
 */
public class StackProblems {


    public static boolean isParanthesisBalanced(String expression) {
        Map<Character, Character> paranthesisPairs = new HashMap<>(3);
        paranthesisPairs.put('(', ')');
        paranthesisPairs.put('{', '}');
        paranthesisPairs.put('[', ']');
        Set<Character> leftParanthesisSet = paranthesisPairs.keySet();
        Collection<Character> rightParanthesisSet = paranthesisPairs.values();

        Stack<Character> paranthesisEvaluatorStack = new Stack<>();

        for (Character token : expression.toCharArray()) {
            if (leftParanthesisSet.contains(token)) {
                paranthesisEvaluatorStack.push(token);
            } else if (rightParanthesisSet.contains(token)) {
                Character recent = paranthesisEvaluatorStack.pop();
                if (!paranthesisPairs.get(recent).equals(token)) {
                    return false;
                }
            }
        }
        return paranthesisEvaluatorStack.isEmpty();
    }

}
