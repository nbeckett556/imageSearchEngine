import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        Container c = frame.getContentPane();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("crowds/Crowds001.jpg"));

        c.add(label);
        frame.setVisible(true);

    }
}