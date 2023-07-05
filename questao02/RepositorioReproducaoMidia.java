package questao02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class RepositorioReproducaoMidia {
    private List<ReproducaoMidia> reproducoes;

    public RepositorioReproducaoMidia() {
        reproducoes = new ArrayList<>();
    }

    public void cadastrarReproducaoMidia(ReproducaoMidia rm) {
        if (rm != null) {
            reproducoes.add(rm);
        }
    }

    public List<ReproducaoMidia> listarReproducoesNoPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<ReproducaoMidia> reproducoesNoPeriodo = new ArrayList<>();
        for (ReproducaoMidia rm : reproducoes) {
            LocalDateTime dataReproducao = rm.getDataHoraReproducao();
            if (dataReproducao.compareTo(inicio) >= 0 && dataReproducao.compareTo(fim) <= 0) {
                reproducoesNoPeriodo.add(rm);
            }
        }
        return reproducoesNoPeriodo;
    }

    public List<ReproducaoMidia> listarReproducoesPorUsuario(Consumidor usuario) {
        List<ReproducaoMidia> reproducoesPorUsuario = new ArrayList<>();
        for (ReproducaoMidia rm : reproducoes) {
            if (rm.getConsumidor().equals(usuario)) {
                reproducoesPorUsuario.add(rm);
            }
        }
        return reproducoesPorUsuario;
    }

    public List<ReproducaoMidia> listarReproducoesPorCategorias(List<String> categorias) {
        List<ReproducaoMidia> reproducoesPorCategorias = new ArrayList<>();
        for (ReproducaoMidia rm : reproducoes) {
            if (categorias.contains(rm.getMidia().getCategoria())) {
                reproducoesPorCategorias.add(rm);
            }
        }
        return reproducoesPorCategorias;
    }
}
