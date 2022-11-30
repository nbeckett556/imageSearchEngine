import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class EuclideanDistance {

    public static String writeColorEDToFile(String imagesFilePath,
                                          String queryImageFilePath) throws Exception{
        String writerFilePath = "../colorEuclideanDistance.txt";
        FileWriter myWriter = new FileWriter(writerFilePath);

        File dir = new File(imagesFilePath);

        int[] quryHist = CreateRgbHist.createRgbHistVector(queryImageFilePath);

        for (File file : dir.listFiles()) {
                int[] hist = CreateRgbHist.createRgbHistVector(file.getPath());
                double distance = calculateEuclideanDist(quryHist, hist);
                myWriter.write(file.getPath() + ":" + distance + ",");
        }
        myWriter.close();

        return writerFilePath;
    }

    public static String[] getSimilarImages(String filePath, int numImagesReturned) throws Exception {

        String allImageNamesAndDistances = readColorEDFromFile(filePath);

        String[] individualImageNamesAndDistances = allImageNamesAndDistances.split(",");
        String[] individualImageNames = new String[individualImageNamesAndDistances.length];
        String[] individualImageDistances = new String[individualImageNamesAndDistances.length];
        for(int i=0; i<individualImageNamesAndDistances.length; i++)
        {
            String[] tempImageAndDistance = individualImageNamesAndDistances[i].split(":");
            individualImageNames[i] = tempImageAndDistance[0];
            individualImageDistances[i] = tempImageAndDistance[1];
        }
        int[] indexes = SortAscending.sort(individualImageDistances);
        int[] relevantIndexes = new int[numImagesReturned];
        System.arraycopy(indexes, 0, relevantIndexes, 0, relevantIndexes.length);
        String[] relevantImages = new String[numImagesReturned];

        int count = 0;
        for (int index: relevantIndexes) {
            relevantImages[count] = individualImageNames[index];
            count++;
        }

        return relevantImages;
    }

    private static String readColorEDFromFile(String filePath) throws Exception{
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        String data = "";
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        return data;
    }

    private static double calculateEuclideanDist(int[] quryRgbHist, int[] rgbHist){
        int size = rgbHist.length;
        double[] runningTotal = new double[size];
        for (int i = 0; i < size; i++)
        {
            runningTotal[i] = Math.sqrt(quryRgbHist[i]^2 + rgbHist[i]^2);
        }
        double sum = 0;
        for (double v : runningTotal) sum = sum + v;

        return sum/runningTotal.length;
    }
}
