import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TimerApp extends JPanel {

    private int sec;
    private double min;
    private int hour;
    private int transformedSec;


    TimerApp() {
        JFrame a = new JFrame();
        a.setTitle("Timer App");
        a.setSize(300, 300);
        a.getContentPane().add(this);
        a.setVisible(true);
        a.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setMin(double min) {
        this.min = min;
    }


    public void paintComponent(Graphics g) {
        String seconds;
        String hours;
        String minutes;
        int transformedMin;
        transformedMin = (int) min % 60;
        int angle = (int) (90 - 6 * min);
        int left_edge = 50;
        int top = 50;
        int diameter = 100;
        int angle1 = 90 - 6 * sec;
        g.setFont(new Font("", Font.BOLD, 25));
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawOval(left_edge, top, diameter, diameter);
        g.drawLine(left_edge + diameter / 2, top + 5, left_edge + diameter / 2, top + 5 + diameter / 2);
        g.setColor(Color.CYAN);
        g.fillArc(left_edge + 5, top + 5, diameter - 10, diameter - 10, angle, 8);
        g.setColor(Color.GREEN);
        g.fillArc(left_edge + 5, top + 5, diameter - 10, diameter - 10, angle1, 8);
        g.setColor(Color.black);
        if (transformedSec < 10)
            seconds = "0" + transformedSec;
        else
            seconds = "" + transformedSec;
        if (transformedMin >= 10 && transformedMin<= 60)
            hours = "" + transformedMin;
        else
            hours = "0" + transformedMin;
        if (hour < 10)
            minutes = "0" + hour;
        else
            minutes = "" + hour;
        g.drawString(minutes + ":" + hours + ":" + seconds, 150, 250);
        this.repaint();
    }

    public void start() {
        try {
            Thread.sleep(1000);
            min = min - 0.0167;
            sec--;
            if (sec <= 0) {
                transformedSec = sec + 60;

            }
            if (transformedSec == 0)
                sec = 0;

            {
                hour = (int) (min / 60);
            }
            if (min <= 0 && hour != 0)
                min = min + 60;

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } finally {
            if (min <= 0 && hour == 0) {
                Thread.currentThread().interrupt();
                JOptionPane.showMessageDialog(null, "The countdown is finished!");

            } else
                start();
        }
    }
}








