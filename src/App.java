import java.util.Scanner;

public class App {
    // Código principal
    @SuppressWarnings({ "resource", "static-access" })
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //---------------------------------------
        // Escolha entre matriz ou vetor
        System.out.println("Digite 'M' para matriz ou 'V' para vetor:");
        char choiceType = scanner.next().charAt(0);
        if (choiceType == 'M' || choiceType == 'm') {
            // Operações com Matriz
            System.out.println("Digite 'T' para transpor, 'S' para somar, 'E' para fazer a multiplicação, 'D' para o método dot, 'G' para o método gauss, 'L' para o método solve ou 'N' para não fazer operação:");
            char choiceOperation = scanner.next().charAt(0);

            if (choiceOperation == 'T' || choiceOperation == 't') {
                // Transposição de Matriz
                System.out.println("Digite o número de linhas e colunas da matriz:");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                double[][] data = new double[rows][cols];
                scanner.nextLine();
                // CHAMAR MATRIZ
                Matrix matrix = new Matrix(rows, cols, data);
                Matrix.inserirMatriz(rows, cols, data, scanner);
                System.out.println("Matriz original:");
                Matrix.apresentarMatriz(matrix);

                // Transpor a matriz e imprimir a matriz transposta
                Matrix matrizTransposta = LinearAlgebra.transpose(matrix);
                System.out.println("Matriz transposta:");
                Matrix.apresentarMatriz(matrizTransposta);
                //---
                while (true) {
                    System.out.println("Quer usar GET ou SET? (Digite 'S' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G") || choice.equals('g')) {
                        System.out.println("Digite o número da linha e coluna que deseja obter:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                        matrizTransposta.get(linha, coluna);
                    } else if (choice.equals("S") || choice.equals("s")) {
                        System.out.println("Digite o número da linha e coluna que deseja setar:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        matrizTransposta.set(linha, coluna, valor);
                        System.out.println("Matriz atualizada:");
                        Matrix.apresentarMatriz(matrizTransposta);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                    }
                }
                //---
            } else if (choiceOperation == 'S' || choiceOperation == 's') {
                // Soma de Matrizes
                System.out.println("Digite o número de linhas e colunas da primeira matriz:");
                int rows1 = scanner.nextInt();
                int cols1 = scanner.nextInt();
                double[][] data1 = new double[rows1][cols1];

                // CHAMAR PRIMEIRA MATRIZ
                Matrix matrix1 = new Matrix(rows1, cols1, data1);
                Matrix.inserirMatriz(rows1, cols1, data1, scanner);
                System.out.println("Digite o número de linhas e colunas da segunda matriz:");
                int rows2 = scanner.nextInt();
                int cols2 = scanner.nextInt();
                double[][] data2 = new double[rows2][cols2];
                // CHAMAR SEGUNDA MATRIZ
                Matrix matrix2 = new Matrix(rows2, cols2, data2);
                Matrix.inserirMatriz(rows2, cols2, data2, scanner);
                // Somar as duas matrizes e imprimir o resultado
                Matrix matrizSoma = LinearAlgebra.sum(matrix1, matrix2);
                System.out.println("Primeira matriz:");
                Matrix.apresentarMatriz(matrix1);// apresenta a primeira matriz
                System.out.println("Segunda matriz:");
                Matrix.apresentarMatriz(matrix2);// apresenta a segunda matriz
                System.out.println("Resultado da soma das matrizes:");
                Matrix.apresentarMatriz(matrizSoma);
                while (true) {
                    System.out.println("Quer usar GET ou SET? (Digite 'N' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G")) {
                        System.out.println("Digite o número da linha e coluna que deseja obter:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                        matrizSoma.get(linha, coluna);
                    } else if (choice.equals("S")) {
                        System.out.println("Digite o número da linha e coluna que deseja setar:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        matrizSoma.set(linha, coluna, valor);
                        System.out.println("Matriz atualizada:");
                        Matrix.apresentarMatriz(matrizSoma);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'G', 'S' ou 'N' para sair.");
                    }
                }
            }
            else if(choiceOperation == 'E' || choiceOperation == 'e'){
                System.out.println("Digite 'S' para multiplicação por escalar ou 'M' para multiplicação de matrizes:");
                char operationChoice = scanner.next().charAt(0);
                
                if(operationChoice == 'S' || operationChoice == 's') {
                    // Operação com Escalar
                    System.out.println("Digite o escalar:");
                    double scalar = scanner.nextDouble();
                    System.out.println("Digite o número de linhas e colunas da matriz:");
                    int rows = scanner.nextInt();
                    int cols = scanner.nextInt();
                    double[][] data = new double[rows][cols];
                    // CHAMAR MATRIZ
                    Matrix matrix1 = new Matrix(rows, cols, data);
                    Matrix.inserirMatriz(rows, cols, data, scanner);
                    
                    // Multiplicação da matriz por um escalar
                    Matrix resultMatrix = LinearAlgebra.times(scalar, matrix1);
                    System.out.println("Escalar:");
                    System.out.printf("%.0f%n", scalar);
                    System.out.println("Matriz:");
                    Matrix.apresentarMatriz(matrix1);
                    // Apresenta o resultado
                    System.out.println("Resultado da multiplicação por escalar:");
                    Matrix.apresentarMatriz(resultMatrix);
                    while (true) {
                        System.out.println("Quer usar GET ou SET? (Digite 'N' para sair)");
                        String choice = scanner.next().toUpperCase();
                        if (choice.equals("G")) {
                            System.out.println("Digite o número da linha e coluna que deseja obter:");
                            int linha = scanner.nextInt();
                            int coluna = scanner.nextInt();
                            System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                            resultMatrix.get(linha, coluna);
                        } else if (choice.equals("S")) {
                            System.out.println("Digite o número da linha e coluna que deseja setar:");
                            int linha = scanner.nextInt();
                            int coluna = scanner.nextInt();
                            System.out.println("Digite o novo valor:");
                            double valor = scanner.nextDouble();
                            resultMatrix.set(linha, coluna, valor);
                            System.out.println("Matriz atualizada:");
                            Matrix.apresentarMatriz(resultMatrix);
                        } else if (choice.equals("N")) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Operação inválida. Por favor, digite 'G', 'S' ou 'N' para sair.");
                        }
                    }
                    //---------------
                } else if(operationChoice == 'M' || operationChoice == 'm') {
                    // Multiplicação de Matrizes
                    System.out.println("Digite o número de linhas e colunas da primeira matriz:");
                    int rows1 = scanner.nextInt();
                    int cols1 = scanner.nextInt();
                    double[][] data1 = new double[rows1][cols1];
                    Matrix matrix1 = new Matrix(rows1, cols1, data1);
                    Matrix.inserirMatriz(rows1, cols1, data1, scanner);
            
                    System.out.println("Digite o número de linhas e colunas da segunda matriz:");
                    int rows2 = scanner.nextInt();
                    int cols2 = scanner.nextInt();
                    double[][] data2 = new double[rows2][cols2];
                    Matrix matrix2 = new Matrix(rows2, cols2, data2);
                    Matrix.inserirMatriz(rows2, cols2, data2, scanner);
                    
                    try {
                        // Verifica se as matrizes têm o mesmo tamanho
                        if (rows1 != rows2 || cols1 != cols2) {
                            throw new Exception("As matrizes devem ter o mesmo tamanho para serem multiplicadas elemento a elemento.");
                        }
                        
                        // Realiza a multiplicação elemento a elemento
                        Matrix resultMatrix = LinearAlgebra.times(matrix1, matrix2);
                        System.out.println("Primeira matriz:");
                        Matrix.apresentarMatriz(matrix1);// apresenta a primeira matriz
                        System.out.println("Segunda matriz:");
                        Matrix.apresentarMatriz(matrix2);// apresenta a segunda matriz
                        // Apresenta o resultado
                        System.out.println("Resultado da multiplicação elemento a elemento:");
                        Matrix.apresentarMatriz(resultMatrix);
                        while (true) {
                            System.out.println("Quer usar GET ou SET? (Digite 'S' para sair)");
                            String choice = scanner.next().toUpperCase();
                            if (choice.equals("G")) {
                                System.out.println("Digite o número da linha e coluna que deseja obter:");
                                int linha = scanner.nextInt();
                                int coluna = scanner.nextInt();
                                System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                                resultMatrix.get(linha, coluna);
                            } else if (choice.equals("S")) {
                                System.out.println("Digite o número da linha e coluna que deseja setar:");
                                int linha = scanner.nextInt();
                                int coluna = scanner.nextInt();
                                System.out.println("Digite o novo valor:");
                                double valor = scanner.nextDouble();
                                resultMatrix.set(linha, coluna, valor);
                                System.out.println("Matriz atualizada:");
                                Matrix.apresentarMatriz(resultMatrix);
                            } else if (choice.equals("N")) {
                                System.out.println("Saindo...");
                                break;
                            } else {
                                System.out.println("Operação inválida. Por favor, digite 'G', 'S' ou 'N' para sair.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Operação inválida. Por favor, digite 'S' para multiplicação por escalar ou 'M' para multiplicação de matrizes.");
                }
                
            }else if (choiceOperation == 'D' || choiceOperation == 'd') {
                // Operação de multiplicação de matrizes
                System.out.println("Digite o número de linhas e colunas da primeira matriz:");
                int rows1 = scanner.nextInt();
                int cols1 = scanner.nextInt();
                double[][] data1 = new double[rows1][cols1];
                Matrix matrix1 = new Matrix(rows1, cols1, data1);
                Matrix.inserirMatriz(rows1, cols1, data1, scanner);
            
                System.out.println("Digite o número de linhas e colunas da segunda matriz:");
                int rows2 = scanner.nextInt();
                int cols2 = scanner.nextInt();
                double[][] data2 = new double[rows2][cols2];
                Matrix matrix2 = new Matrix(rows2, cols2, data2);
                Matrix.inserirMatriz(rows2, cols2, data2, scanner);
                try {
                    // Verifica se o número de colunas da primeira matriz é igual ao número de linhas da segunda matriz
                    if (cols1 != rows2) {
                        throw new Exception("O número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz.");
                    }
                    // Realiza a multiplicação de matrizes
                    Matrix resultMatrix = LinearAlgebra.dot(matrix1, matrix2);
                    System.out.println("Primeira matriz:");
                    Matrix.apresentarMatriz(matrix1);
                    System.out.println("Segunda matriz:");
                    Matrix.apresentarMatriz(matrix2);
                    // Apresenta o resultado
                    System.out.println("Resultado da multiplicação de matrizes:");
                    Matrix.apresentarMatriz(resultMatrix);
                    while (true) {
                        System.out.println("Quer usar GET ou SET? (Digite 'S' para sair)");
                        String choice = scanner.next().toUpperCase();
                        if (choice.equals("G")) {
                            System.out.println("Digite o número da linha e coluna que deseja obter:");
                            int linha = scanner.nextInt();
                            int coluna = scanner.nextInt();
                            System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                            resultMatrix.get(linha, coluna);
                        } else if (choice.equals("S")) {
                            System.out.println("Digite o número da linha e coluna que deseja setar:");
                            int linha = scanner.nextInt();
                            int coluna = scanner.nextInt();
                            System.out.println("Digite o novo valor:");
                            double valor = scanner.nextDouble();
                            resultMatrix.set(linha, coluna, valor);
                            System.out.println("Matriz atualizada:");
                            Matrix.apresentarMatriz(resultMatrix);
                        } else if (choice.equals("N")) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Operação inválida. Por favor, digite 'G', 'S' ou 'N' para sair.");
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if (choiceOperation == 'G' || choiceOperation == 'g') {
                // Eliminação gaussiana
                System.out.println("Digite o número de linhas e colunas da matriz:");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                double[][] data = new double[rows][cols];
            
                //Inserir valores a matriz
                Matrix.inserirMatriz(rows, cols, data, scanner);
                // Criar a matriz
                Matrix matrix = new Matrix(rows, cols, data);
            
                // Realizar a eliminação gaussiana
                try {
                    System.out.println("Matriz original:");
                    Matrix.apresentarMatriz(matrix);
                    Matrix resultMatrix = LinearAlgebra.gauss(matrix);
                    System.out.println("Resultado da eliminação gaussiana:");
                    Matrix.apresentarMatriz(resultMatrix);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else if (choiceOperation == 'N' || choiceOperation == 'n') {
                // Nenhuma operação, apenas exibir a matriz
                System.out.println("Digite o número de linhas e colunas da matriz:");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                double[][] data = new double[rows][cols];

                // CHAMAR MATRIZ
                Matrix matrix = new Matrix(rows, cols, data);
                Matrix.inserirMatriz(rows, cols, data, scanner);
                System.out.println("Matriz:");
                Matrix.apresentarMatriz(matrix);
                while (true) {
                    System.out.println("Quer usar GET ou SET? (Digite 'S' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G")) {
                        System.out.println("Digite o número da linha e coluna que deseja obter:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.print("Valor na posição (" + linha + ", " + coluna + "): ");
                        matrix.get(linha, coluna);
                    } else if (choice.equals("S")) {
                        System.out.println("Digite o número da linha e coluna que deseja setar:");
                        int linha = scanner.nextInt();
                        int coluna = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        matrix.set(linha, coluna, valor);
                        System.out.println("Matriz atualizada:");
                        Matrix.apresentarMatriz(matrix);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'G', 'S' ou 'N' para sair.");
                    }
                }
            }
            else if (choiceOperation == 'L' || choiceOperation == 'l') {
                // Resolver sistema de equações lineares
                System.out.println("Digite o número de equações do sistema:");
                int equations = scanner.nextInt();
                System.out.println("Digite o número de incógnitas do sistema:");
                int variables = scanner.nextInt();
            
                System.out.println("Digite os elementos da matriz aumentada linha por linha (separe os elementos por espaço):");
                double[][] augmentedMatrixData = new double[equations][variables + 1];
                for (int i = 0; i < equations; i++) {
                    for (int j = 0; j <= variables; j++) {
                        augmentedMatrixData[i][j] = scanner.nextDouble();
                    }
                }
                // CHAMAR A MATRIZ
                Matrix augmentedMatrix = new Matrix(equations, variables + 1, augmentedMatrixData);
                try {
                    // Resolver o sistema de equações lineares
                    Matrix solution = LinearAlgebra.solve(augmentedMatrix);
                    // Exibir a solução
                    if(solution != null){
                        System.out.println("Solução do sistema de equações lineares:");
                        solution.apresentarMatriz(solution);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Operação inválida. Por favor, digite 'T' para transpor, 'S' para somar, ou 'N' para não fazer operação.");
            }
        }else if (choiceType == 'V' || choiceType == 'v') {
            // Operações com Vetor
            System.out.println("Digite 'T' para transpor, 'S' para somar, 'E' para fazer a multiplicação, ou 'N' para não fazer operação:");
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
                while (true) {
                    System.out.println("Quer usar GET, SET ou SAIR? (Digite 'N' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G")) {
                        System.out.println("Digite o índice que deseja obter:");
                        int indice = scanner.nextInt();
                        vetorTransposto.get(indice);
                    } else if (choice.equals("S")) {
                        System.out.println("Digite o índice que deseja setar:");
                        int indice = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        vetorTransposto.set(indice, valor);
                        System.out.println("Vetor atualizado:");
                        vetorTransposto.apresentarVectorColuna(dim, vetorTransposto.elements);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                    }
                }
            } else if (choiceOperation == 'S' || choiceOperation == 's') {
                // Soma de Vetores
                System.out.println("Digite o tamanho do primeiro vetor:");
                int dim1 = scanner.nextInt();
                double[] vetorData1 = new double[dim1];

                // CHAMAR PRIMEIRO VETOR
                Vector vector1 = new Vector(dim1, vetorData1);
                vector1.inserirVector(dim1, vetorData1);
                System.out.println("Digite o tamanho do segundo vetor:");
                int dim2 = scanner.nextInt();
                double[] vetorData2 = new double[dim2];

                // CHAMAR SEGUNDO VETOR
                Vector vector2 = new Vector(dim2, vetorData2);
                vector2.inserirVector(dim2, vetorData2);

                // Somar os dois vetores e imprimir o resultado
                Vector vetorSoma = LinearAlgebra.sum(vector1, vector2);
                System.out.println("Primeiro vetor:");
                vector1.apresentarVectorLinha(dim1, vetorData1);
                System.out.println("Segundo vetor:");
                vector2.apresentarVectorLinha(dim2, vetorData2);
                System.out.println("Resultado da soma dos vetores:");
                vetorSoma.apresentarVectorLinha(vetorSoma.dim, vetorSoma.elements);
                while (true) {
                    System.out.println("Quer usar GET, SET ou SAIR? (Digite 'N' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G")) {
                        System.out.println("Digite o índice que deseja obter:");
                        int indice = scanner.nextInt();
                        vetorSoma.get(indice);
                    } else if (choice.equals("S")) {
                        System.out.println("Digite o índice que deseja setar:");
                        int indice = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        vetorSoma.set(indice, valor);
                        System.out.println("Vetor atualizado:");
                        vetorSoma.apresentarVectorLinha(vetorSoma.dim, vetorSoma.elements);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                    }
                }
            }else if(choiceOperation == 'E' || choiceOperation == 'e'){
                System.out.println("Digite 'S' para multiplicação por escalar ou 'V' para multiplicação de vetores:");
                char operationChoice = scanner.next().charAt(0);

                if (operationChoice == 'S' || operationChoice == 's') {
                    // Operação com Escalar
                    System.out.println("Digite o escalar:");
                    double scalar = scanner.nextDouble();
                    System.out.println("Digite o tamanho do vetor:");
                    int dim = scanner.nextInt();
                    double[] vectorData = new double[dim];
                    // CHAMAR VETOR
                    Vector vector = new Vector(dim, vectorData);
                    vector.inserirVector(dim, vectorData);
                    
                    // Multiplicação do vetor por um escalar
                    Vector resultVector = LinearAlgebra.times(scalar, vector);
                    System.out.println("Escalar:");
                    System.out.printf("%.0f%n", scalar);
                    System.out.println("Vetor:");
                    vector.apresentarVectorLinha(dim, vectorData);
                    // Apresenta o resultado
                    System.out.println("Resultado da multiplicação por escalar:");
                    resultVector.apresentarVectorLinha(dim, resultVector.elements);
                    while (true) {
                        System.out.println("Quer usar GET, SET ou SAIR? (Digite 'N' para sair)");
                        String choice = scanner.next().toUpperCase();
                        if (choice.equals("G")) {
                            System.out.println("Digite o índice que deseja obter:");
                            int indice = scanner.nextInt();
                            resultVector.get(indice);
                        } else if (choice.equals("S")) {
                            System.out.println("Digite o índice que deseja setar:");
                            int indice = scanner.nextInt();
                            System.out.println("Digite o novo valor:");
                            double valor = scanner.nextDouble();
                            resultVector.set(indice, valor);
                            System.out.println("Vetor atualizado:");
                            resultVector.apresentarVectorLinha(dim, resultVector.elements);
                        } else if (choice.equals("N")) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                        }
                    }
                }else if(operationChoice == 'V' || operationChoice == 'v'){
                    System.out.println("Digite o tamanho do primeiro vetor:");
                    int dim1 = scanner.nextInt();
                    double[] vectorData1 = new double[dim1];
                    Vector vector1 = new Vector(dim1, vectorData1);
                    vector1.inserirVector(dim1, vectorData1);
                    System.out.println("Digite o tamanho do segundo vetor:");
                    int dim2 = scanner.nextInt();
                    double[] vectorData2 = new double[dim2];
                    Vector vector2 = new Vector(dim2, vectorData2);
                    vector2.inserirVector(dim2, vectorData2);
                    try {
                        // Verifica se os vetores têm o mesmo tamanho
                        if (dim1 != dim2) {
                            throw new Exception("Os vetores devem ter o mesmo tamanho para serem multiplicados elemento a elemento.");
                        }
                
                    // Realiza a multiplicação elemento a elemento
                    Vector resultVector = LinearAlgebra.times(vector1, vector2);
                    System.out.println("Primeiro vetor:");
                    vector1.apresentarVectorLinha(dim1, vector1.elements);
                    System.out.println("Segundo vetor:");
                    vector2.apresentarVectorLinha(dim2, vector2.elements);
                    // Apresenta o resultado
                    System.out.println("Resultado da multiplicação elemento a elemento:");
                    resultVector.apresentarVectorLinha(dim1, resultVector.elements);
                    while (true) {
                        System.out.println("Quer usar GET, SET ou SAIR? (Digite 'N' para sair)");
                        String choice = scanner.next().toUpperCase();
                        if (choice.equals("G")) {
                            System.out.println("Digite o índice que deseja obter:");
                            int indice = scanner.nextInt();
                            resultVector.get(indice);
                        } else if (choice.equals("S")) {
                            System.out.println("Digite o índice que deseja setar:");
                            int indice = scanner.nextInt();
                            System.out.println("Digite o novo valor:");
                            double valor = scanner.nextDouble();
                            resultVector.set(indice, valor);
                            System.out.println("Vetor atualizado:");
                            resultVector.apresentarVectorLinha(dim1, resultVector.elements);
                        } else if (choice.equals("N")) {
                            System.out.println("Saindo...");
                            break;
                        } else {
                            System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                        }
                    }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Operação inválida. Por favor, digite 'S' para multiplicação por escalar ou 'M' para multiplicação de matrizes.");
                }
            }else if (choiceOperation == 'N' || choiceOperation == 'n') {
                // Nenhuma operação, apenas exibir o vetor
                System.out.println("Digite o tamanho do vetor:");
                int dim = scanner.nextInt();
                double[] vetorData = new double[dim];
                // CHAMAR VETOR
                Vector vector = new Vector(dim, vetorData);
                vector.inserirVector(dim, vetorData);
                System.out.println("Vetor:");
                vector.apresentarVectorLinha(dim, vetorData);
                while (true) {
                    System.out.println("Quer usar GET, SET ou SAIR? (Digite 'N' para sair)");
                    String choice = scanner.next().toUpperCase();
                    if (choice.equals("G")) {
                        System.out.println("Digite o índice que deseja obter:");
                        int indice = scanner.nextInt();
                        vector.get(indice);
                    } else if (choice.equals("S")) {
                        System.out.println("Digite o índice que deseja setar:");
                        int indice = scanner.nextInt();
                        System.out.println("Digite o novo valor:");
                        double valor = scanner.nextDouble();
                        vector.set(indice, valor);
                        System.out.println("Vetor atualizado:");
                        vector.apresentarVectorLinha(dim, vetorData);
                    } else if (choice.equals("N")) {
                        System.out.println("Saindo...");
                        break;
                    } else {
                        System.out.println("Operação inválida. Por favor, digite 'GET', 'SET' ou 'S' para sair.");
                    }
                }
            } else {
                System.out.println("Operação inválida. Por favor, digite 'T' para transpor, 'S' para somar, ou 'N' para não fazer operação.");
            }
        } else {
            System.out.println("Escolha inválida. Por favor, digite 'M' para matriz ou 'V' para vetor.");
        }
        scanner.close();
    }
}
