package queuemanager;

/**
 * A wrapper for bundling up an item and its integer priority.
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private final T item;
    private final int priority;

    public PriorityItem(T item, int priority) {
        this.item = item;
        this.priority = priority;
    }

    
    /** 
     * @return T
     */
    public T getItem() {
        return item;
    }

    
    /** 
     * @return int
     */
    public int getPriority() {
        return priority;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "(" + getItem() + ", " + getPriority() + ")";
    }
}
