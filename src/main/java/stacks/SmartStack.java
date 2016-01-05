package stacks;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * Created by saikris on 05/01/2016.
 */
public class SmartStack extends Stack<Integer> {

    private final Stack<Integer> minstack = new Stack<>();

    public static SmartStack of(Integer... integers) {
        SmartStack s = new SmartStack();
        Stream.of(integers).forEach(i -> {
            s._push(i);
        });
        return s;
    }

    @Override
    public Integer push(Integer item) {
        return _push(item);
    }

    private Integer _push(Integer i) {
        if (minstack.isEmpty() || i < minstack.peek()) {
            minstack.push(i);
        }
        return super.push(i);
    }

    @Override
    public Integer pop() {
        Integer top = pop();
        if (top.equals(minstack.peek())) {
            minstack.pop();
        }
        return top;
    }

    public Integer min() {
        return minstack.peek();
    }
}
