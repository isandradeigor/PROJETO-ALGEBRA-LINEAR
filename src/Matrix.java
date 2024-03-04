public class Matrix {
    int rows;
    int cols;
    double[][] elements;
    // MATRIX CONSTRUCTOR
    public Matrix(int rows, int cols, double[][] elements) {
        this.rows = rows;
        this.cols = cols;
        this.elements = elements;
    }
    // OBTER E RETORNAR O VALOR DE UM ELEMENTO
    public void get(int i, int j) {
        System.out.printf("%.0f%n",elements[i - 1][j - 1]);
    }
    // SETAR UM NOVO VALOR A UM ELEMENTO
    public void set(int i, int j, double value) {
        elements[i - 1][j - 1] = value;
    }
    //DAR VALOR A MATRIZ
    public static void inserirMatriz(int rows, int cols, double[][] elements){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[i][j] = Math.round(Math.random() * 10);
            }
        }
    }
    //APRESENTAR A MATRIZ
    public static void apresentarMatriz(Matrix matrix) {
        int rows = matrix.rows;
        int cols = matrix.cols;
        double[][] elements = matrix.elements;
        System.out.printf("-----------%n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.0f ", elements[i][j]);
            }
            System.out.println(" ");
        }
        System.out.printf("-----------%n");
    }
}

