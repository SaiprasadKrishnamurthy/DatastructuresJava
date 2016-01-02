package linkedlists;

/**
 * Created by saikris on 31/12/2015.
 */
public class LinkedNode {

    private Integer data;
    private LinkedNode next;
    private LinkedNode prev;

    public LinkedNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }


    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode prev) {
        this.prev = prev;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
