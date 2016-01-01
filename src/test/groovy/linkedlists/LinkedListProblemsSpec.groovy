package linkedlists

import linkedlists.LinkedList
import spock.lang.Specification


/**
 * Created by saikris on 01/01/2016.
 */
class LinkedListProblemsSpec extends Specification {

    def "should convert an array of numbers to a linkedlist "() {
        given: "an array of integers"
        Integer[] arr = [1, 2, 3, 4, 5] as Integer[]

        when: "passed in to construct a linkedlist"
        LinkedList actual = LinkedList.create(arr)

        then: "a doubly linkedlist should be created with the elements of the array"

        actual.head.data == 5
        actual.head.next.data == 4
        actual.head.next.next.data == 3
        actual.head.next.next.next.data == 2
        actual.head.next.next.next.next.data == 1
        actual.head.next.next.next.next.next == null

        actual.head.next.next.next.next.prev.data == 2
        actual.head.next.next.next.prev.data == 3
        actual.head.next.next.prev.data == 4
        actual.head.next.prev.data == 5
        actual.head.prev == null
    }
}