package clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observer;
import javax.swing.*;
import java.awt.Font;




public class ViewAlarm extends JFrame {
    
    Model model;
    JLabel timelabel = new JLabel("Time");
    JLabel datelabel = new JLabel("Date");
    JButton btn_alarm1 = new JButton("");
    JButton btn_alarm2 = new JButton("");
    JButton btn_alarm3 = new JButton("");
    JButton btn_alarm4 = new JButton("");
    JButton btn_alarm5 = new JButton("");
    
    Container pane = getContentPane();

    public ViewAlarm(Model model){

        this.model = model;
        setTitle("Alarms");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        pane.setLayout(null);

        timelabel.setBounds(10, 10, 100, 20);
        timelabel.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(timelabel);

        datelabel.setBounds(10, 40, 100, 20);
        datelabel.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(datelabel);

        this.addWindowListener(new ViewAlarmWindowAdapter(this));


    }
}
