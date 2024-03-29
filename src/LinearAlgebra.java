public class LinearAlgebra {
    // MÉTODO TRANSPOSTA--------------------------------------------------------
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

    // ----------------------------------------------------------------------------------
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

    public static Matrix times(Matrix a, Matrix b) throws Exception {
        int rowsA = a.rows;
        int colsA = a.cols;
        int rowsB = b.rows;
        int colsB = b.cols;

        if (rowsA != rowsB || colsA != colsB) {
            throw new Exception("As matrizes devem ter o mesmo tamanho para a multiplicação elemento a elemento.");
        }

        double[][] resultData = new double[rowsA][colsA];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                resultData[i][j] = a.elements[i][j] * b.elements[i][j];
            }
        }

        return new Matrix(rowsA, colsA, resultData);
    }

    // Método para multiplicar elemento a elemento uma matriz por um escalar
    public static Matrix times(double scalar, Matrix matrix) {
        int rows = matrix.rows;
        int cols = matrix.cols;
        double[][] resultData = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultData[i][j] = scalar * matrix.elements[i][j];
            }
        }

        return new Matrix(rows, cols, resultData);
    }

    // Método para multiplicar elemento a elemento um vetor por um escalar
    public static Vector times(double scalar, Vector vector) {
        int dim = vector.dim;
        double[] resultData = new double[dim];

        for (int i = 0; i < dim; i++) {
            resultData[i] = scalar * vector.elements[i];
        }

        return new Vector(dim, resultData);
    }

    // Método para multiplicar elemento a elemento um vetor por outro vetor
    public static Vector times(Vector a, Vector b) throws Exception {
        int dimA = a.dim;
        int dimB = b.dim;

        if (dimA != dimB) {
            throw new Exception("Os vetores devem ter o mesmo tamanho para a multiplicação elemento a elemento.");
        }

        double[] resultData = new double[dimA];

        for (int i = 0; i < dimA; i++) {
            resultData[i] = a.elements[i] * b.elements[i];
        }

        return new Vector(dimA, resultData);
    }

    // Método dot para multiplicação de duas matrizes
    public static Matrix dot(Matrix a, Matrix b) throws Exception {
        int rowsA = a.rows;
        int colsA = a.cols;
        int rowsB = b.rows;
        int colsB = b.cols;

        if (colsA != rowsB) {
            throw new Exception(
                    "O número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.");
        }

        double[][] resultData = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                double sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += a.elements[i][k] * b.elements[k][j];
                }
                resultData[i][j] = sum;
            }
        }

        return new Matrix(rowsA, colsB, resultData);
    }

    // Eliminação Gaussiana
    public static Matrix gauss(Matrix a) {
        int rows = a.rows;
        int cols = a.cols;
        double[][] data = a.elements;

        // Iterar sobre as colunas
        for (int i = 0; i < cols - 1; i++) {
            // Iterar sobre as linhas abaixo da linha atual
            for (int j = i + 1; j < rows; j++) {
                double factor = data[j][i] / data[i][i]; // Fator de multiplicação

                // Iterar sobre as colunas, começando da coluna atual
                for (int k = i; k < cols; k++) {
                    data[j][k] -= factor * data[i][k]; // Realizar a operação de eliminação
                }
            }
            // Apresentar a matriz após cada iteração
            System.out.println("Matriz após a iteração " + (i + 1) + ":");
            Matrix.apresentarMatriz(new Matrix(rows, cols, data));
        }
        return new Matrix(rows, cols, data); // Retornar a matriz resultante da eliminação gaussiana
    }
    // GAUS JORDAN - ELIMINAÇÃO A MAIS CASO ESTEJA ERRADO
    public static Matrix gaussJordan(Matrix a) {
        int rows = a.rows;
        int cols = a.cols;
        double[][] data = a.elements.clone(); // Clonando os dados para evitar a alteração da matriz original
    
        // Iterar sobre as colunas
        for (int i = 0; i < cols; i++) {
            // Encontrar o pivô (primeiro elemento não nulo) na coluna atual
            int pivotRow = -1;
            for (int j = i; j < rows; j++) {
                if (data[j][i] != 0) {
                    pivotRow = j;
                    break;
                }
            }
    
            // Se não houver pivô nesta coluna, continue para a próxima coluna
            if (pivotRow == -1)
                continue;
    
            // Trocar linhas para mover o pivô para a diagonal principal
            double[] temp = data[i];
            data[i] = data[pivotRow];
            data[pivotRow] = temp;
    
            // Normalizar a linha do pivô para que o pivô seja igual a 1
            double pivot = data[i][i];
            for (int j = 0; j < cols; j++) {
                data[i][j] /= pivot;
            }
    
            // Reduzir as outras linhas
            for (int j = 0; j < rows; j++) {
                if (j != i) {
                    double factor = data[j][i];
                    for (int k = 0; k < cols; k++) {
                        data[j][k] -= factor * data[i][k];
                    }
                }
            }
    
            // Apresentar a matriz após cada iteração
            System.out.println("Matriz após a iteração " + (i + 1) + ":");
            Matrix.apresentarMatriz(new Matrix(rows, cols, data));
        }
    
        return new Matrix(rows, cols, data); // Retornar a matriz resultante da eliminação Gauss-Jordan
    }
    
    // Solve
    public static Matrix solve(Matrix augmentedMatrix) {
        // Realiza a eliminação gaussiana
        Matrix gaussianEliminationResult = gauss(augmentedMatrix);

        int rows = gaussianEliminationResult.rows;
        int cols = gaussianEliminationResult.cols;

        // Verifica se o sistema é consistente ou inconsistente
        boolean consistent = true;
        for (int i = 0; i < rows; i++) {
            boolean allZero = true;
            for (int j = 0; j < cols - 1; j++) {
                if (gaussianEliminationResult.elements[i][j] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero && gaussianEliminationResult.elements[i][cols - 1] != 0) {
                consistent = false;
                break;
            }
        }

        // Resolve o sistema retroativamente se for consistente
        if (consistent) {
            double[] solution = new double[rows];
            for (int i = rows - 1; i >= 0; i--) {
                double sum = 0;
                for (int j = i + 1; j < cols - 1; j++) {
                    sum += gaussianEliminationResult.elements[i][j] * solution[j];
                }
                solution[i] = (gaussianEliminationResult.elements[i][cols - 1] - sum)
                        / gaussianEliminationResult.elements[i][i];
            }

            // Verifica se a solução contém NaN
            boolean containsNaN = false;
            for (double sol : solution) {
                if (Double.isNaN(sol)) {
                    containsNaN = true;
                    break;
                }
            }

            // Retorna uma mensagem indicando se a solução é válida ou não
            if (containsNaN) {
                System.out.println("A solução é indefinida (contém valores NaN).");
                return null; // ou retorne uma matriz especial indicando que a solução é inválida
            } else {
                double[][] solutionMatrix = new double[rows][1];
                for (int i = 0; i < rows; i++) {
                    solutionMatrix[i][0] = solution[i];
                }
                return new Matrix(rows, 1, solutionMatrix);
            }
        } else {
            System.out.println("O sistema é inconsistente - sem solução.");
            return null; // ou retorne uma matriz especial indicando que o sistema é inconsistente
        }
    }
}
