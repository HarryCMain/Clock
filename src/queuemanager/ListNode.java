package queuemanager;

public class ListNode<T> {
    private T item;
    ListNode<T> next;
    
    public ListNode(T item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }
    
    
    /** 
     * @return T
     */
    public T getItem() {
        return item;
    }
    
    
    /** 
     * @return ListNode<T>
     */
    public ListNode<T> getNext() {
        return next;
    }
} //this is probably a good replacement for individual node classes