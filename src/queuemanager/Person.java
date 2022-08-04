package queuemanager;

/**
 * Minimal "person" class.
 *
 * At the moment a Person object just holds their name, but in a more realistic
 * system, there would obviously be more.
 */
public class Person {

    protected String name;

    public Person(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return getName();
    }
}
