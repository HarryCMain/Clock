package clock;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Calendar;

public class Model {

    int hour;
    int minute;
    int second;
    private int oldSecond;

    private final PropertyChangeSupport propertyChangeSupport;

    public Model() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        update();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void update() {
        Calendar date = Calendar.getInstance();
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);

        if (oldSecond != second) {
            propertyChangeSupport.firePropertyChange("second", oldSecond, second);
        }
    }
}