package questao01;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private final List<Carta> mao;
    private int fichas;

    public Jogador() {
        mao = new ArrayList<>();
        fichas = 100; // Valor inicial de fichas
    }

    public void adicionarCarta(Carta carta) {
        mao.add(carta);
    }

    public void limparMao() {
        mao.clear();
    }

    public List<Carta> getMao() {
        return mao;
    }

    public int getFichas() {
        return fichas;
    }

    public void aumentarFichas(int valor) {
        fichas += valor;
    }

    public void diminuirFichas(int valor) {
        fichas -= valor;
    }
}
