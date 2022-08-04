package clock;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Observer;
import javax.swing.*;


public class EditAlarm  extends JFrame{
    Model model;
    Alarm alarm;

    JSpinner date_spinner = new JSpinner( new SpinnerDateModel());
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    JLabel editlabel = new JLabel("Edit Alarm");
    JButton saveButton = new JButton("Save");
    JButton deleteButton = new JButton("Delete");

    public EditAlarm(Model model, Alarm alarm){
        this.model = model;
        this.alarm = alarm;

        setTitle("Edit Alarm");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Container pane = getContentPane();
        pane.setLayout(null);

        editlabel.setFont(new Font("futura", Font.BOLD, 30));
        editlabel.setBounds(100, 10, 200, 50);
        pane.add(editlabel);

        date_spinner.setBounds(100, 60, 200, 50);
        date_spinner.setFont(new Font("futura", Font.BOLD, 30));
        date_spinner.setEditor(new JSpinner.DateEditor(date_spinner, sdf.toPattern()));
        pane.add(date_spinner);

        saveButton.setBounds(100, 110, 200, 50);
        saveButton.setFont(new Font("futura", Font.BOLD, 30));
        pane.add(saveButton);

        deleteButton.setBounds(100, 160, 200, 50);
        deleteButton.setFont(new Font("futura", Font.BOLD, 30));
        pane.add(deleteButton);

        saveButton.setActionCommand("SAVE");
        deleteButton.setActionCommand("DELETE");

        saveButton.addActionListener(new EditAlarmActionListener(this));
        deleteButton.addActionListener(new EditAlarmActionListener(this));

        this.addWindowListener(new EditAlarmWindowAdapter(this,alarm));
    }
}
