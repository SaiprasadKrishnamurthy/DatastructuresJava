package stacks

import spock.lang.Specification


/**
 * Created by saikris on 05/01/2016.
 */
class StackProblemsSpec extends Specification {

    def "should check if the expression has a balanced set of parantheses for a valid expression "() {
        given: "an expression with a balanced set of paranthesis"
            def inputExpression = "a((b+c)*{cd}+[ac])"
        expect:
            StackProblems.isParanthesisBalanced(inputExpression)
    }

    def "should check if the expression has a balanced set of parantheses for an  invalid expression "() {
        given: "an expression with an unbalanced set of paranthesis"
            def inputExpression = "a(()]"
        expect:
            !StackProblems.isParanthesisBalanced(inputExpression)
    }
}