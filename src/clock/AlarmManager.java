package clock;

public class AlarmManager<Alarm> {
//disregard, abbandoned solution 
/* 
    private Alarm[] alarms;
    private int size;
    private int capacity;
    private int index;

    public AlarmManager(int capacity) {
        this.capacity = capacity;
        this.alarms = new Alarm[capacity];
        this.size = 0;
        this.index = -1;
    }

    public void add(Alarm alarm) {
        if (size == capacity) {
            throw new IllegalStateException("AlarmManager is full");
        }
        index = index + 1;
        alarms[index] = alarm;
        size = size + 1;
    }

    public void remove() {
        if (size == 0) {
            throw new IllegalStateException("AlarmManager is empty");
        }
        for (int i = 0; i < index; i++) {
            alarms[i] = alarms[i + 1];
        }
        index = index - 1;
        size = size - 1;
    }

    public Alarm head() {
        if (size == 0) {
            throw new IllegalStateException("AlarmManager is empty");
        }
        return alarms[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(alarms[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int index() {
        return index;
    }

    public Alarm[] getAlarms() {
        return alarms;
    }

    public void setAlarms(Alarm[] alarms) {
        this.alarms = alarms;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setAlarm(int index, Alarm alarm) {
        this.alarms[index] = alarm;
    }

    public Alarm getAlarm(int index) {
        return this.alarms[index];
    }


*/

}
