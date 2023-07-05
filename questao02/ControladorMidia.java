package questao02;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ControladorMidia {
    private RepositorioUsuario repositorioUsuario;
    private RepositorioMidia repositorioMidia;
    private RepositorioReproducaoMidia repositorioReproducaoMidia;

    public ControladorMidia(RepositorioUsuario repositorioUsuario, RepositorioMidia repositorioMidia, RepositorioReproducaoMidia repositorioReproducaoMidia) {
        this.repositorioUsuario = new RepositorioUsuario();
        this.repositorioMidia = new RepositorioMidia();
        this.repositorioReproducaoMidia = new RepositorioReproducaoMidia();
    }

    public void cadastrarUsuario(Usuario u) {
        if (u != null) {
            if (u instanceof Produtor && ((Produtor)u).getCategorias().isEmpty()) {
                throw new IllegalArgumentException("A lista de categorias não pode ser nula ou vazia para um Produtor.");
            }
            repositorioUsuario.cadastrarUsuario(u);
        }
    }

    public void removerUsuario(Usuario u) {
        if (u != null) {
            repositorioUsuario.removerUsuario(u);
        }
    }

    public void cadastrarMidia(Midia m) {
        if (m != null) {
            repositorioMidia.cadastrarMidia(m);
        }
    }

    public void removerMidia(Midia m) {
        if (m != null) {
            repositorioMidia.removerMidia(m);
        }
    }

    /*public void reproduzirMidia(Consumidor consumidor, Midia midia) {
        if (consumidor != null && midia != null) {
            int idade = consumidor.getIdade();
            int faixaEtaria = midia.getFaixaEtariaMinima();
            if (idade >= faixaEtaria) {
                ReproducaoMidia reproducaoMidia = new ReproducaoMidia(midia, consumidor, LocalDateTime.now());
                RepositorioReproducaoMidia repositorioReproducaoMidia1 = new RepositorioReproducaoMidia();
                repositorioReproducaoMidia1.cadastrarReproducaoMidia(reproducaoMidia);
            } else {
                throw new IllegalArgumentException("A idade do consumidor não é adequada para reproduzir esta mídia.");
            }
        }
    }*/
}