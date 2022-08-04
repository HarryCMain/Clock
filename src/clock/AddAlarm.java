package clock;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class AddAlarm extends JFrame {
    Model model;


    JSpinner date_spinner = new JSpinner( new SpinnerDateModel());
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    JLabel setlabel = new JLabel("Set Alarm");
    JButton setbutton = new JButton("Set");

    public AddAlarm(Model model) {
        this.model = model;
        setTitle("Add Alarm");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Container pane = getContentPane();
        pane.setLayout(null);
        setlabel.setFont(new Font("futura", Font.BOLD, 30));
        setlabel.setBounds(100, 10, 200, 50);
        pane.add(setlabel);

        date_spinner.setBounds(100, 60, 200, 50);
        date_spinner.setFont(new Font("futura", Font.BOLD, 30));
        date_spinner.setEditor(new JSpinner.DateEditor(date_spinner, sdf.toPattern()));
        pane.add(date_spinner);

        setbutton.setBounds(100, 110, 200, 50);
        setbutton.setFont(new Font("futura", Font.BOLD, 30));
        pane.add(setbutton);

        setbutton.addActionListener(new AddAlarmActionListener(this, model));

        this.addWindowListener(new AddAlarmWindowAdapter(this, model));

    }




}
