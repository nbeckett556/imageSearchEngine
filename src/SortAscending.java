public class SortAscending {

    public static int[] sort(String[] distances){
        int size = distances.length;
        double[][] distancesAsDoublesWithIndexes = new double[size][2];
        for (int x = 0; x < size; x++) {
            distancesAsDoublesWithIndexes[x][0] = Double.parseDouble(distances[x]);
            distancesAsDoublesWithIndexes[x][1] = x;
        }
        return bubbleSort(distancesAsDoublesWithIndexes);
    }

    private static int[] bubbleSort(double[][] arr) {

        int size = arr.length;
        
        for (int i = 0; i < size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                if (arr[j][0] > arr[j + 1][0]) {
                    double temp = arr[j][0];
                    arr[j][0] = arr[j + 1][0];
                    arr[j + 1][0] = temp;

                    temp = arr[j][1];
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][1] = temp;
                }
            }
        }
        int[] indexes = new int[size];
        for (int i = 0; i < size; i++){
            indexes[i] = (int)arr[i][1];
        }
        return indexes;
    }
}

