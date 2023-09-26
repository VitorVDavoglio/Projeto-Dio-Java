package Robos;

public class Robo {
    private int posicao; // A posição atual do robô

    // Construtor para inicializar a posição do robô
    public Robo(int posicaoInicial) {
        this.posicao = posicaoInicial;
    }

    // Método para mover o robô para a direita
    public void moverDireita() {
        posicao++;
        System.out.println("O robô moveu para a direita. Posição atual: " + posicao);
    }

    // Método para mover o robô para a esquerda
    public void moverEsquerda() {
        if (posicao > 0) {
            posicao--;
            System.out.println("O robô moveu para a esquerda. Posição atual: " + posicao);
        } else {
            System.out.println("O robô já está na posição mais à esquerda.");
        }
    }

    // Método para obter a posição atual do robô
    public int getPosicao() {
        return posicao;
    }
    
    public void desenhandoRobo() {
    	
    }

    public static void main(String[] args) {
        // Exemplo de uso da classe Robo
        Robo robo = new Robo(0); // Inicializa o robô na posição 0
        System.out.println("Posição atual do robô: "+robo.getPosicao()); 

        // Movimenta o robô para a direita duas vezes
        robo.moverDireita();
        robo.moverDireita();

        // Movimenta o robô para a esquerda uma vez
        robo.moverEsquerda();
    }
}
