package questao01;

import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private static final int APOSTA_MINIMA = 2;
    private static final int APOSTA_MAXIMA = 100;

    private final Baralho baralho;
    private final Jogador jogador;
    private final Banca banca;
    private int apostaAtual;

    public BlackjackGame() {
        baralho = new Baralho(1);
        jogador = new Jogador();
        banca = new Banca();
        apostaAtual = 0;
    }

    public void jogar() {
        System.out.println("Bem-vindo ao jogo de Blackjack!");

        while (true) {
            System.out.println("\nFichas disponíveis: " + jogador.getFichas());
            realizarAposta();
            distribuirCartas();

            if (verificarBlackjack(jogador.getMao())) {
                System.out.println("Blackjack! Você ganhou!");
                jogador.aumentarFichas(apostaAtual);
            } else {
                jogarJogador();
                jogarBanca();
                verificarVencedor();
            }

            jogador.limparMao();
            banca.limparMao();

            if (!querContinuarJogando()) {
                break;
            }
        }

        System.out.println("Obrigado por jogar!");
    }

    private void realizarAposta() {
        Scanner scanner = new Scanner(System.in);
        int fichasDisponiveis = jogador.getFichas();

        while (true) {
            System.out.print("Faça sua aposta (mínimo " + APOSTA_MINIMA + " fichas, máximo " + APOSTA_MAXIMA + " fichas): ");
            apostaAtual = scanner.nextInt();

            if (apostaAtual >= APOSTA_MINIMA && apostaAtual <= APOSTA_MAXIMA && apostaAtual <= fichasDisponiveis) {
                break;
            }

            System.out.println("Aposta inválida. Por favor, insira um valor válido.");
        }

        jogador.diminuirFichas(apostaAtual);
    }

    private void distribuirCartas() {
        jogador.adicionarCarta(baralho.pegarCarta());
        jogador.adicionarCarta(baralho.pegarCarta());
        banca.adicionarCarta(baralho.pegarCarta());
        banca.adicionarCarta(baralho.pegarCarta());

        System.out.println("\nJogador: " + jogador.getMao());
        System.out.println("Banca: " + banca.getMao().get(0) + " (carta oculta)");
    }

    private void jogarJogador() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDeseja (H)it ou (S)tand? ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("H")) {
                jogador.adicionarCarta(baralho.pegarCarta());
                System.out.println("Jogador: " + jogador.getMao());

                if (verificarEstouro(jogador.getMao())) {
                    System.out.println("Estourou! Você perdeu.");
                    return;
                }
            } else if (escolha.equalsIgnoreCase("S")) {
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha H ou S.");
            }
        }
    }

    private void jogarBanca() {
        System.out.println("\nBanca: " + banca.getMao());

        while (pontuacaoBanca() < 17) {
            banca.adicionarCarta(baralho.pegarCarta());
            System.out.println("Banca: " + banca.getMao());

            if (verificarEstouro(banca.getMao())) {
                System.out.println("A banca estourou! Você ganhou!");
                jogador.aumentarFichas(apostaAtual * 2);
                return;
            }
        }
    }

    private void verificarVencedor() {
        int pontuacaoJogador = pontuacao(jogador.getMao());
        int pontuacaoBanca = pontuacaoBanca();

        System.out.println("\nPontuação final:");
        System.out.println("Jogador: " + pontuacaoJogador);
        System.out.println("Banca: " + pontuacaoBanca);

        if (pontuacaoJogador > pontuacaoBanca) {
            System.out.println("Você ganhou!");
            jogador.aumentarFichas(apostaAtual * 2);
        } else if (pontuacaoJogador < pontuacaoBanca) {
            System.out.println("Você perdeu.");
        } else {
            System.out.println("Empate.");
            jogador.aumentarFichas(apostaAtual);
        }
    }

    private boolean querContinuarJogando() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nDeseja jogar novamente? (S)im ou (N)ão: ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("S")) {
                return true;
            } else if (escolha.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha S ou N.");
            }
        }
    }

    private boolean verificarBlackjack(List<Carta> mao) {
        if (mao.size() != 2) {
            return false;
        }

        Carta primeiraCarta = mao.get(0);
        Carta segundaCarta = mao.get(1);

        return (primeiraCarta.getValor().equals("A") && segundaCarta.getValor().equals("10"))
                || (primeiraCarta.getValor().equals("10") && segundaCarta.getValor().equals("A"));
    }
    
    private boolean verificarEstouro(List<Carta> mao) {
        int pontuacao = pontuacao(mao);
        return pontuacao > 21;
    }

    private int pontuacao(List<Carta> mao) {
        int totalPontos = 0;
        int numAces = 0;

        for (Carta carta : mao) {
            String valor = carta.getValor();

            if (valor.equals("A")) {
                totalPontos += 11;
                numAces++;
            } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) {
                totalPontos += 10;
            } else {
                totalPontos += Integer.parseInt(valor);
            }
        }

        while (totalPontos > 21 && numAces > 0) {
            totalPontos -= 10;
            numAces--;
        }

        return totalPontos;
    }

    private int pontuacaoBanca() {
        int totalPontos = pontuacao(banca.getMao());

        // Exibe a segunda carta da banca (antes oculta)
        System.out.println("Banca: " + banca.getMao());

        return totalPontos;
    }

    public static void main(String[] args) {
        BlackjackGame jogo = new BlackjackGame();
        jogo.jogar();
    }
}
