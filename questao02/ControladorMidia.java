package questao02;

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

	public void listInDateTime(LocalDateTime dataInicial, LocalDateTime dataFinal) {
		for (ReproducaoMidia reproducaoMidia : reproducaoMidias) {
			if (reproducaoMidia.getDataHoraReproducao().isAfter(dataInicial)
					|| reproducaoMidia.getDataHoraReproducao().isEqual(dataInicial)) {
				if (reproducaoMidia.getDataHoraReproducao().isBefore(dataFinal)
						|| reproducaoMidia.getDataHoraReproducao().isEqual(dataFinal)) {
					System.out.println(reproducaoMidia.getMidia().getArquivo());
				}
			}
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

	public void setRepositorioUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public RepositorioMidia getRepositorioMidia() {
		return repositorioMidia;
	}

	public void setRepositorioMidia(RepositorioMidia repositorioMidia) {
		this.repositorioMidia = repositorioMidia;
	}

	public RepositorioReproducaoMidia getRepositorioReproducaoMidia() {
		return repositorioReproducaoMidia;
	}

	public void setRepositorioReproducaoMidia(RepositorioReproducaoMidia repositorioReproducaoMidia) {
		this.repositorioReproducaoMidia = repositorioReproducaoMidia;
	}

	/*
	 * public void reproduzirMidia(Consumidor consumidor, Midia midia) { if
	 * (consumidor != null && midia != null) { int idade = consumidor.getIdade();
	 * int faixaEtaria = midia.getFaixaEtariaMinima(); if (idade >= faixaEtaria) {
	 * ReproducaoMidia reproducaoMidia = new ReproducaoMidia(midia, consumidor,
	 * LocalDateTime.now()); RepositorioReproducaoMidia repositorioReproducaoMidia1
	 * = new RepositorioReproducaoMidia();
	 * repositorioReproducaoMidia1.cadastrarReproducaoMidia(reproducaoMidia); } else
	 * { throw new
	 * IllegalArgumentException("A idade do consumidor não é adequada para reproduzir esta mídia."
	 * ); } } }
	 */
}