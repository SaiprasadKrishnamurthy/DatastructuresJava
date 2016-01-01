package linkedlists;

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
}
