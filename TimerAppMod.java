import javax.swing.JOptionPane;

public class TimerAppMod {
    public void countDown() {
        String input = JOptionPane.showInputDialog("Input the minutes that will be counted down");
        if (input == null||input.equal("")) {
            throw new RuntimeException("Please give an input");
        }
        int minutes = Integer.parseInt(input);
        if (minutes < 0) {
            throw new RuntimeException("Invalid Value:Minutes can't be given as negative integers");
        }
        if (minutes == 0) {
            throw new RuntimeException("Invalid Value:Please give a number that is greater than 0");
        }
        TimerApp a = new TimerApp();
        a.setMin(minutes);
        a.start();
    }
}

