import javax.swing.*;
import java.awt.*;

public class ShowImage {

    public static void showImageFrame (String filePath){
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        Container c = frame.getContentPane();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(filePath));

        c.add(label);
        frame.setVisible(true);
    }
}
