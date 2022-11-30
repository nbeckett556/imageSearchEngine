public class Main {
    public static void main(String[] args) throws Exception {

        ShowImage.showImageFrame("F1-CarsQuery/F1-Cars034.jpg");

        String colorEDFilePath = EuclideanDistance.writeColorEDToFile("imageDatabase/",
                "F1-CarsQuery/F1-Cars034.jpg");

        String[] returnedSearchImages = EuclideanDistance.getSimilarImages(colorEDFilePath, 5);

        for (String image: returnedSearchImages) {
            System.out.println(image);
            ShowImage.showImageFrame(image);
        }

    }
}