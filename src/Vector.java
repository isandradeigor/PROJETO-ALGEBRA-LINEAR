import java.util.Scanner;

public class Vector {
    int dim;
    double[] elements;
    Scanner scanner = new Scanner(System.in);
    // Construtor
    public Vector(int dim, double[] elements) {
        this.dim = dim;
        this.elements = elements;
    }

    // Método para obter o valor de um elemento do vetor
    public void get(int i) {
        // Verifica se o índice está dentro dos limites do vetor
        if (i >= 0 && i < dim) {
            System.out.printf("%.3f%n", elements[i - 1]);
        } else {
            // Índice fora dos limites, retornar um valor padrão ou lançar uma exceção
            System.out.println("Índice fora dos limites.");
        }
    }

    // Método para atribuir um valor a um elemento do vetor
    public void set(int i, double value) {
        // Verifica se o índice está dentro dos limites do vetor
        if (i >= 0 && i < dim) {
            elements[i - 1] = value;
        } else {
            // Índice fora dos limites, realizar uma ação apropriada
            System.out.println("Índice fora dos limites. Não foi possível atribuir o valor.");
        }
    }

    public void inserirVector(int dim, double[] elements){
        System.out.println("Insira os elementos do vetor:");
        for(int i = 0; i < dim; i++){
            elements[i] = scanner.nextDouble();
        }
    }
    public void apresentarVectorLinha(int dim, double[] elements){
        System.out.printf("[ ");
        for(int i = 0; i < dim; i++){
            System.out.printf("%.3f ",elements[i]);
        }
        System.out.printf("]%n");

    }
    public void apresentarVectorColuna(int dim, double[] elements){
        for(int i = 0; i < dim; i++){
            System.out.printf("[%.3f]%n",elements[i]);
        }
    }
}
