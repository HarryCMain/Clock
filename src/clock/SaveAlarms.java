package clock;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.awt.Font;

public class SaveAlarms extends JFrame {

    JLabel saveLabel = new JLabel("Save Alarms");
    JButton yesButton = new JButton("Yes");
    JButton noButton = new JButton("No");
    JFileChooser fileChooser = new JFileChooser();
    JTextField fileName = new JTextField();
    JButton openButton = new JButton("Open");

    public SaveAlarms(Model model){

        setTitle("Save Alarms");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Container pane = getContentPane();
        pane.setLayout(null);

        saveLabel.setBounds(100, 10, 100, 20);
        saveLabel.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(saveLabel);

        fileName.setBounds(100, 40, 100, 20);
        fileName.setFont(new Font("futura", Font.BOLD, 20));
        fileName.setEditable(true);
        pane.add(fileName);

        openButton.setBounds(100, 70, 100, 20);
        openButton.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(openButton);

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setDialogTitle("Save Alarms");
        fileChooser.showSaveDialog(this);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "ics");
        fileChooser.setFileFilter(filter);
        pane.add(fileChooser);

        yesButton.setBounds(100, 100, 100, 20);
        yesButton.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(yesButton);

        noButton.setBounds(100, 130, 100, 20);
        noButton.setFont(new Font("futura", Font.BOLD, 20));
        pane.add(noButton);

        yesButton.setActionCommand("YES");
        noButton.setActionCommand("NO");
        openButton.setActionCommand("FILE");

        yesButton.addActionListener(new SaveAlarmsActionListener(this, model));
        noButton.addActionListener(new SaveAlarmsActionListener(this, model));
        openButton.addActionListener(new SaveAlarmsActionListener(this, model));


    }

    
}
