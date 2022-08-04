package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JFileChooser;

class LoadAlarmsActionListener implements ActionListener {

    LoadAlarms view;
    Model model;

    public LoadAlarmsActionListener(LoadAlarms view, Model model) {

        this.view = view;
        this.model = model;
    }

    public LoadAlarmsActionListener(LoadAlarms view) {

        this.view = view;
    }

    
    /** 
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        String filepath = view.fileName.getText();
        ArrayList<String> icalAlarms = new ArrayList<>();

        // read file and separate out the alarms in their ical DTSTART format
        if (ae.getActionCommand() == "YES") {

            try {
                // read file
                BufferedReader file = new BufferedReader(new FileReader(filepath));
                String line;
                String[] lineSplit;
                  // loop through file and split each line into an array
                  while ((line = file.readLine()) != null) {

                    lineSplit = line.split(":");
                    java.util.List<String> lineArray = new ArrayList<String>(Arrays.asList(lineSplit));

                    // if the line starts with DTSTART put the datetime string into an array
                    if (lineArray.get(0).equals("DTSTART")) {

                        icalAlarms.add(lineArray.get(1));
                    }
                }

                // error checking
                System.out.println(icalAlarms);

                file.close();
            }
            catch (IOException e) {

            }

            // loop through alarms and add them to the queue
            for (String icalAlarm : icalAlarms) {

                //split string into characters and other formatting
                String[] icalChars;
                icalChars = icalAlarm.split("");
                ArrayList<String> icalSplit = new ArrayList<String>(Arrays.asList(icalChars));

                String year = icalSplit.get(0) + icalSplit.get(1) + icalSplit.get(2) + icalSplit.get(3);
                String month = icalSplit.get(4) + icalSplit.get(5);
                String day = icalSplit.get(6) + icalSplit.get(7);
                String hour = icalSplit.get(9) + icalSplit.get(10);
                String minutes = icalSplit.get(11) + icalSplit.get(12);

                String datetimeString = (hour + ":" + minutes + " " + day + "/" + month + "/" + year);
                DateFormat format = new SimpleDateFormat("HH:mm dd/MM/yyyy");

                try {

                    Date alarm = format.parse(datetimeString);
                    model.addAlarm(alarm);
                }
                catch (ParseException e) {

                }
            }

            view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
        }
 // no button
 else if (ae.getActionCommand() == "NO") {

    view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
}

// file choose functionality
else if (ae.getActionCommand() == "FILE") {

    // set text field to selected file
    view.fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
    int result = view.fileChooser.showOpenDialog(view);

    if (result == JFileChooser.APPROVE_OPTION) {

        File selectedFile = view.fileChooser.getSelectedFile();
        view.fileName.setText(String.valueOf(selectedFile));
    }
}
} 
}