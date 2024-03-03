public class LinearAlgebra {
    //MÉTODO TRANSPOSTA--------------------------------------------------------
    // Método para calcular a transposta de uma matriz
    public static Matrix transpose(Matrix matrix) {
        int rows = matrix.cols; // Inverte linhas e colunas
        int cols = matrix.rows; // Inverte linhas e colunas
        double[][] transposedData = new double[rows][cols]; // Inverte linhas e colunas

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedData[i][j] = matrix.elements[j][i]; // Inverte linhas e colunas
            }
        }

        return new Matrix(rows, cols, transposedData); // Inverte linhas e colunas
    }

    // Método para calcular o vetor transposto
    public static Vector transpose(Vector vector) {
        int dim = vector.dim;
        double[] transposedData = new double[dim];

        for (int i = 0; i < dim; i++) {
            transposedData[i] = vector.elements[i];
        }

        return new Vector(dim, transposedData);
    }
    //----------------------------------------------------------------------------------
    // Método para somar duas matrizes
    public static Matrix sum(Matrix a, Matrix b) throws Exception {
        int rowsA = a.rows;
        int colsA = a.cols;
        int rowsB = b.rows;
        int colsB = b.cols;

        if (rowsA != rowsB || colsA != colsB) {
            throw new Exception("As matrizes devem ter o mesmo tamanho para serem somadas.");
        }

        double[][] sumData = new double[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                sumData[i][j] = a.elements[i][j] + b.elements[i][j];
            }
        }

        return new Matrix(rowsA, colsA, sumData);
    }

    // Método para somar dois vetores
    public static Vector sum(Vector a, Vector b) throws Exception {
        int dimA = a.dim;
        int dimB = b.dim;

        if (dimA != dimB) {
            throw new Exception("Os vetores devem ter o mesmo tamanho para serem somados.");
        }

        double[] sumData = new double[dimA];

        for (int i = 0; i < dimA; i++) {
            sumData[i] = a.elements[i] + b.elements[i];
        }

        return new Vector(dimA, sumData);
    }
}
