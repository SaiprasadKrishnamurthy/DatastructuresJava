package stacks

import spock.lang.Specification


/**
 * Created by saikris on 05/01/2016.
 */
class StackProblemsSpec extends Specification {

    def "should check if the expression has a balanced set of parantheses for a valid expression "() {
        given: "an expression with a balanced set of paranthesis"
        def inputExpression = "a((b+c)*{cd}+[ac])"
        expect: "true"
        StackProblems.isParanthesisBalanced(inputExpression)
    }

    def "should check if the expression has a balanced set of parantheses for an  invalid expression "() {
        given: "an expression with an unbalanced set of paranthesis"
        def inputExpression = "a(()]"
        expect: "false"
        !StackProblems.isParanthesisBalanced(inputExpression)
    }

    def "should convert an infix to postfix notation for a simple expression "() {
        def inputInfixExpression = "x * y / 5 * z + p"
        def expectedPostfixExpression = "x y * 5 / z * p +"

        given:
        "a simple infix expression"

        expect:
        "the postfix notation"
        StackProblems.postfixOf(inputInfixExpression) == expectedPostfixExpression.replace(" ", "")
    }

    def "should find the min element efficiently"() {
        given: "a stack of integers"
        SmartStack stack = SmartStack.of(20, 6, 4, 10, 5, 100, 120, -1, -10, 200, 7, 6, 4, 0)

        expect:
        stack.min() == -10
    }
}