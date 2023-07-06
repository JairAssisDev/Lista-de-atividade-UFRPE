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

    public void listaMidiaUser(Consumidor consumidor) {
    	for (ReproducaoMidia reproducao : reproducoes) {
            if (reproducao.getConsumidor().equals(consumidor)) {
                System.out.println(reproducao.getMidia().getArquivo());
            }
        }
    }
    
    public void listaCategoriaJogo() {
    	for (ReproducaoMidia reproducao : reproducoes) {
            if (reproducao.getMidia().getCategoria().equals("Jogos")) {
                System.out.println("Reproducao Midia-midia: " + reproducao.getMidia().getArquivo() + " Categoria: " + reproducao.getMidia().getCategoria());
            }
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
