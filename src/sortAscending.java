public class sortAscending {

    public static int[] bubbleSort(String[] distances) {

        int size = distances.length;
        double[][] doubleDistances = new double[size][2];
        for (int x = 0; x < size; x++) {
            doubleDistances[x][0] = Double.parseDouble(distances[x]);
            doubleDistances[x][1] = x;
        }

        // loop to access each array element
        for (int i = 0; i < size - 1; i++){

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++){

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (doubleDistances[j][0] > doubleDistances[j + 1][0]) {

                    // swapping occurs if elements
                    // are not in the intended order
                    double temp = doubleDistances[j][0];
                    doubleDistances[j][0] = doubleDistances[j + 1][0];
                    doubleDistances[j + 1][0] = temp;

                    temp = doubleDistances[j][1];
                    doubleDistances[j][1] = doubleDistances[j + 1][1];
                    doubleDistances[j + 1][1] = temp;
                }
            }
        }
        int[] indexes = new int[size];
        for (int i = 0; i < size; i++){
            indexes[i] = (int)doubleDistances[i][1];
        }
        return indexes;
    }
}

