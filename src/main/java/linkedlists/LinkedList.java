package linkedlists;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by saikris on 31/12/2015.
 */
public class LinkedList {

    private LinkedNode head;

    public LinkedNode getHead() {
        return head;
    }

    public void setHead(LinkedNode head) {
        this.head = head;
    }

    public static LinkedList create(Integer... ints) {
        LinkedList l = new LinkedList();

        for (int i = 0; i < ints.length; i++) {
            LinkedNode curr = new LinkedNode(ints[i]);
            curr.setNext(l.head);
            if (curr.getNext() != null) {
                curr.getNext().setPrev(curr);
            }
            l.head = curr;
        }
        return l;
    }

    @Override
    public String toString() {
        LinkedNode curr = head;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.getData() + " \u21c4 ");
            curr = curr.getNext();
        }
        builder.append("NIL");
        return builder.toString();
    }

    public Integer nth(int n, boolean fromLast) {
        if (fromLast) {
            LinkedNode p1 = head;
            LinkedNode p2 = head;

            // Move p1 n times
            for (int i = -1; i < n; i++) {
                if (p1 == null) throw new IndexOutOfBoundsException("n is more than the size of the list");
                p1 = p1.getNext();
            }
            while (p1 != null) {
                p1 = p1.getNext();
                p2 = p2.getNext();
            }
            return p2.getData();
        } else {
            LinkedNode p1 = head;
            LinkedNode curr = head;
            for (int i = -1; i < n; i++) {
                if (p1 == null) throw new IndexOutOfBoundsException("n is more than the size of the list");
                curr = p1;
                p1 = p1.getNext();
            }
            return curr.getData();
        }
    }

    public int size() {
        int size = 0;
        LinkedNode curr = head;
        while (curr != null) {
            curr = curr.getNext();
            size++;
        }
        return size;
    }
}
