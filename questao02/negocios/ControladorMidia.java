package questao02.negocios;

import questao02.negocios.beans.Midia;
import questao02.negocios.beans.Produtor;
import questao02.negocios.beans.ReproducaoMidia;
import questao02.negocios.beans.Usuario;
import questao02.dados.RepositorioMidia;
import questao02.dados.RepositorioReproducaoMidia;
import questao02.dados.RepositorioUsuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorMidia {
	private RepositorioUsuario repositorioUsuario;
	private RepositorioMidia repositorioMidia;
	private RepositorioReproducaoMidia repositorioReproducaoMidia;
	private static List<ReproducaoMidia> reproducaoMidias = new ArrayList<>();

	public ControladorMidia(RepositorioUsuario repositorioUsuario, RepositorioMidia repositorioMidia,
			RepositorioReproducaoMidia repositorioReproducaoMidia) {
		this.repositorioUsuario = repositorioUsuario;
		this.repositorioMidia = repositorioMidia;
		this.repositorioReproducaoMidia = repositorioReproducaoMidia;

	}

	public void cadastrarUsuario(Usuario u) {
		if (u != null) {
			if (u instanceof Produtor && ((Produtor) u).getCategorias().isEmpty()) {
				throw new IllegalArgumentException(
						"A lista de categorias não pode ser nula ou vazia para um Produtor.");
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
	public void cadastrarReproducaoMidia(ReproducaoMidia reproducaoMidia) {
		if (reproducaoMidia != null) {
			repositorioReproducaoMidia.cadastrarReproducaoMidia(reproducaoMidia);
			reproducaoMidias.add(reproducaoMidia);
		}
	}
	public void removerMidia(Midia m) {
		if (m != null) {
			repositorioMidia.removerMidia(m);
		}
	}
	public RepositorioUsuario getRepositorioUsuario() {
		return repositorioUsuario;
	}
	public RepositorioMidia getRepositorioMidia() {
		return repositorioMidia;
	}
	public RepositorioReproducaoMidia getRepositorioReproducaoMidia() {
		return repositorioReproducaoMidia;
	}
}