package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Controller {

    private Timer timer;
    private Model model;

    public Controller(Model model, View view) {
        this.model = model;

        // Update the model every 100 milliseconds
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update();
            }
        });
        timer.start();
    }
}