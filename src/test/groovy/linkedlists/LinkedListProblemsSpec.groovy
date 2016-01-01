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

    def "should find the nth last element of the linkedlist "() {
        given: "a doubly linked list of integers"
            LinkedList list = LinkedList.create([1, 2, 3, 4, 5] as Integer[])

        // 5 4 3 2 1
        expect:
            list.nth(0, true) == 1
            list.nth(1, true) == 2
            list.nth(2, true) == 3
            list.nth(3, true) == 4
            list.nth(4, true) == 5
    }

    def "should find the size of the linkedlist "() {
        given: "a doubly linked list of integers"
        LinkedList list = LinkedList.create([1, 2, 3, 4, 5] as Integer[])

        // 5 4 3 2 1
        expect:
        list.size() == 5
    }
}