package linkedlists;

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

    public int mid() {
        LinkedNode p1 = head;
        LinkedNode p2 = head;

        int counter = 0;
        while (p1 != null) {
            if (counter % 2 != 0) {
                p2 = p2.getNext();
            }
            p1 = p1.getNext();
            counter++;
        }
        return p2.getData();
    }

    public boolean isEqual(LinkedList other) {

        LinkedNode curr = head;
        LinkedNode otherNode = other.head;

        while (curr != null && otherNode != null && curr.getData() == otherNode.getData()) {
            curr = curr.getNext();
            otherNode = otherNode.getNext();
        }
        return curr == null && otherNode == null;
    }

    public void reverse() {
        LinkedNode next, curr = head;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(curr.getPrev());
            curr.setPrev(next);
            head = curr;
            curr = next;
        }
    }

    public void reverseRecurse() {
        reverseRecurse(head.getPrev(), head);
    }

    private void reverseRecurse(LinkedNode prev, LinkedNode curr) {
        if (curr != null) {
            head = curr;
            reverseRecurse(curr, curr.getNext());
            curr.setNext(prev);
            if (prev != null) {
                prev.setPrev(curr);
            }
        }
    }


    public void swapAdjacentPairs() {
        LinkedNode p1 = head;

        while (p1 != null && p1.getNext() != null) {
            int temp = p1.getData();
            int nextData = p1.getNext().getData();
            p1.setData(nextData);
            p1.getNext().setData(temp);
            p1 = p1.getNext().getNext();
        }
    }
}
