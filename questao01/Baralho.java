package questao01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    private final List<Carta> cartas;

    public Baralho(int numBaralhos) {
        cartas = new ArrayList<>();
        String[] naipes = { "P", "C", "E", "O" };
        String[] valores = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

        for (int i = 0; i < numBaralhos; i++) {
            for (String naipe : naipes) {
                for (String valor : valores) {
                    cartas.add(new Carta(valor, naipe));
                }
            }
        }

        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta pegarCarta() {
        if (cartas.isEmpty()) {
            embaralhar();
        }
        return cartas.remove(cartas.size() - 1);
    }

    public int getQuantidadeCartas() {
        return cartas.size();
    }
}
