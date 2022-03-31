public class Q2_1 {
    public static void main(String[] args) {
        int row1 = 1000;
        int col1 = 900;
        int row2 = 900;
        int col2 = 1200;

        long start = System.currentTimeMillis();

        int A[][] = new int[row1][col1];
        int B[][] = new int[row2][col2];
        int C[][] = new int[row1][col2];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = ( (int)Math.random() * 100 + 1);
            }
        }
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                B[i][j] = ((int)Math.random() * 100 + 1);
            }
        }

        for (int m = 0; m < row1; m++) {
            for (int p = 0; p < col2; p++) {
                for (int n = 0; n < col1; n++) {
                    C[m][p] += A[m][n] * B[n][p];
                }
            }
        }

        long end = System.currentTimeMillis();

        float sec = (end - start) / 1000F;

        System.out.println(sec + " seconds");
    }
}

