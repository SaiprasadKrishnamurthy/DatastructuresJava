package stacks;

import java.util.*;
import java.util.stream.Stream;

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

    public static String postfixOf(String p) {
        Map<String, Integer> operatorsToPriorities = new HashMap<>();
        operatorsToPriorities.put("+", 0);
        operatorsToPriorities.put("-", 0);
        operatorsToPriorities.put("*", 1);
        operatorsToPriorities.put("/", 1);
        StringBuilder result = new StringBuilder();
        Stack<String> operatorsStack = new Stack<>();

        String[] tokens = p.split("");

        Stream.of(tokens)
                .forEach(token -> {
                    // Operand.
                    if (!operatorsToPriorities.containsKey(token.trim())) {
                        result.append(token.trim());
                    } else {
                        if (operatorsStack.isEmpty()) {
                            operatorsStack.push(token.trim());
                        } else {
                            while (!operatorsStack.isEmpty() && operatorsToPriorities.get(token.trim()) <= operatorsToPriorities.get(operatorsStack.peek().trim())) {
                                result.append(operatorsStack.pop().trim());
                            }
                            operatorsStack.push(token.trim());
                        }
                    }
                });
        while (!operatorsStack.isEmpty()) {
            result.append(operatorsStack.pop());
        }
        return result.toString();
    }
}
