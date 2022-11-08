import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);

        Container c = frame.getContentPane();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("crowds/Crowds056.jpg"));

        c.add(label);
        frame.setVisible(true);

        FileWriter myWriter = new FileWriter("C:/Users/Niamh/OneDrive/Documents/Final Project/filename.txt");

        File dir = new File("crowds/");
        int[] quryHist = createRgbHist.createHistVector("crowds/Crowds056.jpg");


        for (File file : dir.listFiles()) {
            int[] hist = createRgbHist.createHistVector(file.getPath());
            double[] runningTotal = new double[768];
            for (int i = 0; i < hist.length; i++)
            {
                runningTotal[i] = Math.sqrt(quryHist[i]^2 + hist[i]^2);
            }
            double sum = 0;
            for (double v : runningTotal) sum = sum + v;

            double distance = sum/runningTotal.length;
            myWriter.write(file.getPath() + ":" + distance + ",");
        }
        myWriter.close();

        File myObj = new File("C:/Users/Niamh/OneDrive/Documents/Final Project/filename.txt");
        Scanner myReader = new Scanner(myObj);
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }

        String[] individualImages = data.split(",");
        System.out.println(individualImages[0]);
        String[] individualImageNames = new String[individualImages.length];
        String[] individualImageDistances = new String[individualImages.length];
        for(int i=0; i<individualImages.length; i++)
        {
            String[] tempImageAndDistance = individualImages[i].split(":");
            individualImageNames[i] = tempImageAndDistance[0];
            individualImageDistances[i] = tempImageAndDistance[1];
        }
        int[] indexes = sortAscending.bubbleSort(individualImageDistances);
        int[] relevantIndexes = new int[5];
        System.arraycopy(indexes, 0, relevantIndexes, 0, relevantIndexes.length);

        for (int index: relevantIndexes) {
            System.out.println(individualImageNames[index]);
            JFrame frame1 = new JFrame();
            frame1.setSize(500, 500);

            Container c1 = frame1.getContentPane();
            JLabel label1 = new JLabel();
            label1.setIcon(new ImageIcon(individualImageNames[index]));

            c1.add(label1);
        }

    }
}