package clock;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;


public class Alarm extends TimerTask {



    private String alarmical; //alarm in icalander format
    private Date alarmdatetime; //raw java time format
    private boolean active; // is it on or off

    //constructor
    public Alarm(Date alarm){
        alarmdatetime = alarm;
        active = false;
        alarmical = convertformat(alarmdatetime);
    }

    @Override
    //this is the method that is called when the alarm is activated
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Alarm is active");
        JOptionPane.showMessageDialog(null, "Alarm is active for: " + new SimpleDateFormat("DD/MM/YYYY HH:mm:ss").format(alarmdatetime));
        active = true;
    }

    
    /** 
     * @param alarm
     * @return String
     */
    //convert java time format to icalander format
    public String convertformat(Date alarm){
        String tempalarmvar = new SimpleDateFormat("yyyyMMdd").format(alarmdatetime) + "T" + String.valueOf(new SimpleDateFormat("HHmmss").format(alarmdatetime) + "Z");
        return tempalarmvar;
    }

    
    /** 
     * @return String
     */
    //getters and setters

    public String getAlarmical() {
        return alarmical;
    }

    
    /** 
     * @return boolean
     */
    public boolean isActive() {
        return active;
    }

    
    /** 
     * @return Date
     */
    public Date getAlarmdatetime() {
        return alarmdatetime;
    }

    //abbandoned implementation
/* 
String name;
int hour;
int minute;
int second;
boolean active;


    public Alarm(String name, int hour, int minute, int second, boolean active) {
    this.name = name;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
        this.active = active;
    }

        public String getName() {
            return name;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }

        public boolean isActive() {
            return active;
        }

    @Override
    public String toString() {
        return getName();
        
    }

    */

 }
