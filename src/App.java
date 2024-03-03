import java.util.Scanner;

public class App {
    //Código principal
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //---------------------------------------
        // Escolha entre matriz ou vetor
        System.out.println("Digite 'M' para matriz ou 'V' para vetor:");
        char choiceType = scanner.next().charAt(0);
        if (choiceType == 'M' || choiceType == 'm') {
            // Operações com Matriz
            System.out.println("Digite 'T' para transpor ou 'S' para somar:");
            char choiceOperation = scanner.next().charAt(0);

            if (choiceOperation == 'T' || choiceOperation == 't') {
                // Transposição de Matriz
                System.out.println("Digite o número de linhas e colunas da matriz:");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                double[][] data = new double[rows][cols];

                // CHAMAR MATRIZ
                Matrix matrix = new Matrix(rows, cols, data);
                Matrix.inserirMatriz(rows, cols, data);
                System.out.println("Matriz original:");
                Matrix.apresentarMatriz(matrix);

                // Transpor a matriz e imprimir a matriz transposta
                Matrix matrizTransposta = LinearAlgebra.transpose(matrix);
                System.out.println("Matriz transposta:");
                Matrix.apresentarMatriz(matrizTransposta);
            } else if (choiceOperation == 'S' || choiceOperation == 's') {
                // Soma de Matrizes
                System.out.println("Digite o número de linhas e colunas da primeira matriz:");
                int rows1 = scanner.nextInt();
                int cols1 = scanner.nextInt();
                double[][] data1 = new double[rows1][cols1];

                // CHAMAR PRIMEIRA MATRIZ
                Matrix matrix1 = new Matrix(rows1, cols1, data1);
                Matrix.inserirMatriz(rows1, cols1, data1);
                System.out.println("Digite o número de linhas e colunas da segunda matriz:");
                int rows2 = scanner.nextInt();
                int cols2 = scanner.nextInt();
                double[][] data2 = new double[rows2][cols2];
                // CHAMAR SEGUNDA MATRIZ
                Matrix matrix2 = new Matrix(rows2, cols2, data2);
                Matrix.inserirMatriz(rows2, cols2, data2);
                // Somar as duas matrizes e imprimir o resultado
                Matrix matrizSoma = LinearAlgebra.sum(matrix1, matrix2);
                System.out.println("Primeira matriz:");
                Matrix.apresentarMatriz(matrix1);// apresenta a primeira matriz
                System.out.println("Segunda matriz:");
                Matrix.apresentarMatriz(matrix2);// apresenta a segunda matriz
                System.out.println("Resultado da soma das matrizes:");
                Matrix.apresentarMatriz(matrizSoma);
            } else {
                System.out.println("Operação inválida. Por favor, digite 'T' para transpor ou 'S' para somar.");
            }
        } else if (choiceType == 'V' || choiceType == 'v') {
            // Operações com Vetor
            System.out.println("Digite 'T' para transpor:");
            char choiceOperation = scanner.next().charAt(0);

            if (choiceOperation == 'T' || choiceOperation == 't') {
                // Transposição de Vetor
                System.out.println("Digite o tamanho do vetor:");
                int dim = scanner.nextInt();
                double[] vetorData = new double[dim];

                // CHAMAR VETOR
                Vector vector = new Vector(dim, vetorData);
                vector.inserirVector(dim, vetorData);

                // Transpor o vetor e imprimir o vetor transposto
                Vector vetorTransposto = LinearAlgebra.transpose(vector);
                System.out.println("Vetor original:");
                vector.apresentarVectorLinha(dim, vetorData);
                System.out.println("Vetor transposto:");
                vetorTransposto.apresentarVectorColuna(dim, vetorTransposto.elements);
            } else {
                System.out.println("Operação inválida. Por favor, digite 'T' para transpor.");
            }
        } else {
            System.out.println("Escolha inválida. Por favor, digite 'M' para matriz ou 'V' para vetor.");
        }
    }
}
