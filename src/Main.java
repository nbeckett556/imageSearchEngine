public class Main {
    public static void main(String[] args) throws Exception {

        ShowImage.showImageFrame("crowds/Crowds001.jpg");

        String colorEDFilePath = EuclideanDistance.writeColorEDToFile("crowds/",
                "crowds/Crowds001.jpg");

        String[] returnedSearchImages = EuclideanDistance.getSimilarImages(colorEDFilePath, 5);

        for (String image: returnedSearchImages) {
            System.out.println(image);
            ShowImage.showImageFrame(image);
        }

    }
}