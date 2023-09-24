package Robos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Estante {
    private List<Jogo> jogos;
    private Robo robo;

    public Estante() {
        this.jogos = new ArrayList<>();
        this.robo = new Robo(0); // Inicializa o robô na posição 0
    }

    // Adicionar um jogo à estante
    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
        // Ordenar a lista de jogos em ordem alfabética após adicionar um novo jogo
        Collections.sort(jogos, (j1, j2) -> j1.getNome().compareTo(j2.getNome()));
    }

    // Listar os jogos na estante
    public void listarJogos() {
        System.out.println("Jogos na estante:");
        for (int i = 0; i < jogos.size(); i++) {
            System.out.println((i + 1) + ". " + jogos.get(i).getNome());
        }
    }

    // Mover o robô para a posição do jogo especificado
    public void moverRoboParaJogo(String nomeJogo) {
        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogo = jogos.get(i);
            if (jogo.getNome().equalsIgnoreCase(nomeJogo)) {
                int posicaoJogo = i + 1; // Posição começa em 1
                int posicaoAtualRobo = robo.getPosicao();

                // Calcula a direção em que o robô precisa se mover
                int direcao = Integer.compare(posicaoJogo, posicaoAtualRobo);
                while (robo.getPosicao() != posicaoJogo) {
                    if (direcao > 0) {
                        robo.moverDireita();
                    } else if (direcao < 0) {
                        robo.moverEsquerda();
                    }
                }
                System.out.println("O jogo '" + nomeJogo + "' foi inserido na posição " + posicaoJogo + " da estante.");
                return;
            }
        }
        System.out.println("Jogo não encontrado na estante.");
    }

    public static void main(String[] args) {
        Estante estante = new Estante();
        Scanner scanner = new Scanner(System.in);

        // Adicionar jogos à estante
        estante.adicionarJogo(new Jogo("Zelda"));
        estante.adicionarJogo(new Jogo("Mario"));
        estante.adicionarJogo(new Jogo("FIFA"));
        estante.adicionarJogo(new Jogo("Call of Duty"));
        estante.adicionarJogo(new Jogo("Assassin's Creed"));

        // Listar os jogos na estante (em ordem alfabética)
        estante.listarJogos();

        // Perguntar ao usuário qual jogo ele deseja inserir
        System.out.print("Qual jogo você deseja inserir na estante? Digite o nome do jogo: ");
        String nomeJogoInserir = scanner.nextLine();

        // Criar o novo jogo e adicionar à estante
        Jogo novoJogo = new Jogo(nomeJogoInserir);
        estante.adicionarJogo(novoJogo);

        // Listar os jogos na estante novamente (agora em ordem alfabética atualizada)
        estante.listarJogos();

        // Fechar o scanner
        scanner.close();
    }
}