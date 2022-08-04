package queuemanager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementation of the PriorityQueue ADT using a sorted array for storage.
 *
 * Because Java does not allow generic arrays (!), this is implemented as an
 * array of Object rather than of PriorityItem&lt;T&gt;, which would be natural.
 * Array elements accessed then have to be cast to PriorityItem&lt;T&gt; before
 * using their getItem() or getPriority() methods.
 * 
 * This is an example of Java's poor implementation getting in the way. Java
 * fanboys will no doubt explain at length why it has to be this way, but note
 * that Eiffel allows it because Eiffel generics were done right from the start,
 * rather than being tacked on as an afterthought and limited by issues of
 * backward compatibility. Humph!
 * 
 * @param <T> The type of things being stored.
 */
public class SortedArrayPriorityQueue<T> implements PriorityQueue<T> {
    
    /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public SortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }//end constructor

    
    /** 
     * @return T
     * @throws QueueUnderflowException
     */
    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            return ((PriorityItem<T>) storage[0]).getItem();
        }
    }//end head

    
    /** 
     * @param item
     * @param priority
     * @throws QueueOverflowException
     */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
            while (i > 0 && ((PriorityItem<T>) storage[i - 1]).getPriority() < priority) {
                storage[i] = storage[i - 1];
                i = i - 1;
            }
            storage[i] = new PriorityItem<>(item, priority);
        }
    }

    
    /** 
     * @throws QueueUnderflowException
     */
    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            for (int i = 0; i < tailIndex; i++) {
                storage[i] = storage[i + 1];
            }
            tailIndex = tailIndex - 1;
        }
    }//end remove

    
    /** 
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    } // returns true if the queue is empty

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    } // returns a string representation of the queue


    public int count() { return tailIndex + 1 ; }

    
    /** 
     * @return ArrayList<Object>
     */
    // return arraylist of queue
    public ArrayList<Object> returnArrayList() {

        ArrayList<Object> arrayList = new ArrayList<>(Arrays.asList(storage));

        return arrayList;
    }

    
    /** 
     * @param item
     * @return Object
     */
    // search for an item in the queue
    public Object search(T item) {

        ArrayList<Object> arrayList = new ArrayList<>(Arrays.asList(storage));
        Object returnValue = null;

        for (Object object : arrayList) {

            System.out.println(object);

            if (object == item) {

                returnValue = object;
            }
        }

        return returnValue;
    }
/* 
    @Test

    public void TestSortedArrayPriorityQueue() throws QueueUnderflowException, QueueOverflowException{
        SortedArrayPriorityQueue<String> queue = new SortedArrayPriorityQueue<>(5);
        queue.add("A", 1);
        queue.add("B", 2);
        queue.add("C", 3);
        queue.add("D", 4);
        queue.add("E", 5);
        assertArrayEquals(new Object[]{"A", "B", "C", "D", "E"}, queue.storage);
        queue.remove();
        assertArrayEquals(new Object[]{"B", "C", "D", "E"}, queue.storage);
        queue.remove();
        assertArrayEquals(new Object[]{"C", "D", "E"}, queue.storage);
        queue.remove();
        assertArrayEquals(new Object[]{"D", "E"}, queue.storage);
        queue.remove();
        assertArrayEquals(new Object[]{"E"}, queue.storage);
        queue.remove();
        assertArrayEquals(new Object[]{}, queue.storage);
        assertEquals(true, queue.isEmpty());
    } */
}
