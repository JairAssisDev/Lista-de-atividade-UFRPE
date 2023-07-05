package questao02;

import java.util.ArrayList;
import java.util.List;

class RepositorioMidia {
    private List<Midia> midias;

    public RepositorioMidia() {
        midias = new ArrayList<>();
    }

    public void cadastrarMidia(Midia m) {
        if (m != null && !existeMidia(m)) {
            midias.add(m);
        }
    }

    public void removerMidia(Midia m) {
        midias.removeIf(midia -> midia.getArquivo().equals(m.getArquivo()));
    }

    private boolean existeMidia(Midia midia) {
        return midias.stream().anyMatch(m -> m.getArquivo().equals(midia.getArquivo()));
    }

    public List<Midia> listarMidiasPorFaixaEtaria(int faixaEtaria) {

        List<Midia> midiasPorFaixaEtaria = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getFaixaEtariaMinima() <= faixaEtaria) {
                midiasPorFaixaEtaria.add(m);
            }
        }
        return midiasPorFaixaEtaria;

    }

    public List<Midia> listarMidiasPorCategoria(String categoria) {
        List<Midia> midiasPorCategoria = new ArrayList<>();
        for (Midia m : midias) {
            if (m.getCategoria().equals(categoria)) {
                midiasPorCategoria.add(m);
            }
        }
        return midiasPorCategoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Midia midia : midias) {
            sb.append(midia.toString()).append("\n");
        }
        return sb.toString();
    }
}
