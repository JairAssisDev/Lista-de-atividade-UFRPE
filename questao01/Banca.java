package questao01;

import java.util.ArrayList;
import java.util.List;

public class Banca {
    private final List<Carta> mao;

    public Banca() {
        mao = new ArrayList<>();
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
}
