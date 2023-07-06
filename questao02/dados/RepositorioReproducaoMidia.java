package questao02.dados;

import questao02.negocios.beans.Consumidor;
import questao02.negocios.beans.ReproducaoMidia;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioReproducaoMidia {
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
                System.out.println("Nome: "+ reproducao.getMidia().getArquivo());
            }
        }
    }
    public void listaCategoriaJogo() {
    	for (ReproducaoMidia reproducao : reproducoes) {
            if (reproducao.getMidia().getCategoria().equals("Jogos")) {
                System.out.println("Reproducao Midia - midia: " + reproducao.getMidia().getArquivo() + " || Categoria: " + reproducao.getMidia().getCategoria());
            }
        }
    }
    public void listInDateTime(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        for (ReproducaoMidia reproducaoMidia : reproducoes) {
            if (reproducaoMidia.getDataHoraReproducao().isAfter(dataInicial)
                    || reproducaoMidia.getDataHoraReproducao().isEqual(dataInicial)) {
                if (reproducaoMidia.getDataHoraReproducao().isBefore(dataFinal)
                        || reproducaoMidia.getDataHoraReproducao().isEqual(dataFinal)) {
                    System.out.println(reproducaoMidia.getMidia().getArquivo());
                }
            }
        }
    }
}
