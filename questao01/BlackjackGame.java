package questao01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackGame {
    private static final int APOSTA_MINIMA = 2;
    private static final int APOSTA_MAXIMA = 100;
    private final Baralho baralho;
    private final Jogador jogador;
    private final Banca banca;
    private int apostaAtual;
    private int numeroDecks;

    public BlackjackGame(int numeroDecks) {
        this.numeroDecks = Math.max(2, Math.min(numeroDecks,10));
        baralho = new Baralho(this.numeroDecks);
        jogador = new Jogador();
        banca = new Banca();
        apostaAtual = 0;
    }

    public void jogar() {
        System.out.println("\n*-----------------------------------------------------------*");
        System.out.println("*----------------- Bem-vindo ao BlackJack! -----------------*");
        System.out.println("*-----------------------------------------------------------*");

        while (true) {
            System.out.println("\nFichas disponíveis: " + jogador.getFichas());
            realizarAposta();
            distribuirCartas();

                if (true) {
                jogarJogador();
                if (!verificarEstouro(jogador.getMao())){
                jogarBanca();
                }
                verificarVencedor();
            }

            jogador.limparMao();
            banca.limparMao();

            if (!querContinuarJogando()) {
                break;
            }
        }
    }

    private void realizarAposta() {
        Scanner scanner = new Scanner(System.in);
        int fichasDisponiveis = jogador.getFichas();
        System.out.println("Cartas restantes no baralho: " + baralho.getQuantidadeCartas());

        while (true) {
            System.out.print("Faça sua aposta mínimo " + APOSTA_MINIMA + " fichas, máximo " + APOSTA_MAXIMA + " fichas: ");
            apostaAtual = scanner.nextInt();
            jogador.diminuirFichas((int)apostaAtual);
            System.out.println(jogador.getFichas());

            if (apostaAtual >= APOSTA_MINIMA && apostaAtual <= APOSTA_MAXIMA && apostaAtual <= fichasDisponiveis) {
                break;
            }

            System.out.println("Por favor, insira um valor válido.");
        }

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
            System.out.print("\nDeseja (H) Hit - Pedir mais cartas - ou (S) Stand - parar? ");
            String escolha = scanner.nextLine();

            if (escolha.equals("H") || escolha.equals("h")) {
                jogador.adicionarCarta(baralho.pegarCarta());
                System.out.println("Jogador: " + jogador.getMao());

                if (verificarEstouro(jogador.getMao())) {
                    System.out.println("Você perdeu! :(");
                    return;
                }
            } else if (escolha.equals("S") || escolha.equals("s")) {
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha H (h) ou S (s).");
            }
        }
    }

    private void jogarBanca() {
        System.out.println("\nBanca: " + banca.getMao());

        while (pontuacaoBanca() < 17) {
            banca.adicionarCarta(baralho.pegarCarta());
            System.out.println("Banca: " + banca.getMao());

            if (verificarEstouro(banca.getMao())) {
                System.out.println("\nVocê ganhou! : \n");
                return;
            }
        }
    }

    private void verificarVencedor() {
        int pontuacaoJogador = pontuacao(jogador.getMao());
        int pontuacaoBanca = pontuacaoBanca();

        System.out.println("\n*---------Pontuação final:---------*");
        System.out.println("* Jogador: " + pontuacaoJogador);
        System.out.println("* Banca: " + pontuacaoBanca);

        if (pontuacaoJogador > pontuacaoBanca && pontuacaoJogador <= 21 || pontuacaoBanca > 21) {
            System.out.println("*---------Parabéns Campeão!--------*");
            jogador.aumentarFichas(apostaAtual * 2);
        } else if (pontuacaoJogador < pontuacaoBanca && pontuacaoBanca <= 21 || pontuacaoJogador > 21) {
            System.out.println("Você perdeu.");
        } else {
            System.out.println("Empate.");
            jogador.aumentarFichas(apostaAtual);
        }
    }

    private boolean querContinuarJogando() {
        Scanner scanner = new Scanner(System.in);
        int fichasDisponiveis = jogador.getFichas();

        while (fichasDisponiveis > 0) {
            System.out.print("\nDeseja jogar novamente? (S) Sim ou (N) Não: ");
            String escolha = scanner.nextLine();

            if (escolha.equals("S") || escolha.equals("s")) {
                return true;
            } else if (escolha.equals("N") || escolha.equals("n")) {
                return false;
            } else {
                System.out.println("Inválido. Escolha S (s) ou N (n).");
            }
        }
        System.out.println("*-------------Perdeu Cowboy!---------------*");
        return false;
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

        System.out.println("Banca: " + banca.getMao());

        return totalPontos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos decks quer utilizar? (2 -> 10)");
        int numDecks = scanner.nextInt();
        BlackjackGame jogo = new BlackjackGame(numDecks);
        jogo.jogar();
    }
}
