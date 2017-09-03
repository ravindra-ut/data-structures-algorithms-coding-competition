class RotateMatrix {
    public void rotate(int[][] matrix) {
        // 90 degree rotation = matrix transpose then matrix horizontal swap
        // matrix transpose
        if(matrix == null){
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // transpose of a matrix , matrix[i][j] <-> matrix[j][i]
        for(int i = 0; i < rows; i++){
            // important j moves from i to cols
            // 1 2 3
            //   5 6
            //     9
            for(int j=i; j < cols; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // horizontal swap of elements 1 2 3 4<--> 4 3 2 1
        for(int i = 0 ; i < rows; i++){
            for(int j=0; j < cols/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
    }
}