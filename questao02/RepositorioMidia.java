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

    public void listarMidiasPorFaixaEtaria() {

        for (Midia midia : midias) {
            if (midia.getFaixaEtariaMinima() > 14) {
                System.out.println("Nome: "+midia.getArquivo());
            }
        }
        

    }

    public void listarMidiasPorCategoria() {
        
        for (Midia midia: midias) {
            if (midia.getCategoria().equals("Jogos")) {
                System.out.println("Nome: "+midia.getArquivo());
            }
        }
        
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
