package questao02;

import java.util.ArrayList;
import java.util.List;

class RepositorioUsuario {
	private List<Usuario> usuarios;

	public RepositorioUsuario() {
		usuarios = new ArrayList<>();
	}

	public void cadastrarUsuario(Usuario u) {
		if (u != null && !existeUsuario(u)) {
			usuarios.add(u);
		}
	}

	public void removerUsuario(Usuario u) {
		usuarios.removeIf(usuario -> usuario.getEmail().equals(u.getEmail()));
	}

	private boolean existeUsuario(Usuario usuario) {
		return usuarios.stream().anyMatch(u -> u.getEmail().equals(usuario.getEmail()));
	}

	/*
	 * public List<Usuario> listarUsuariosComIdadeAcimaDe(int idade) { List<Usuario>
	 * usuariosComIdadeAcimaDe = new ArrayList<>(); for (Usuario u : usuarios) { if
	 * (u.getIdade() > idade) { usuariosComIdadeAcimaDe.add(u); } } return
	 * usuariosComIdadeAcimaDe; }
	 */
	public List<Usuario> usuariosAcimaIdadeMinima(int idadeMinima) {
		List<Usuario> usuariosAcimaIdadeMinima = new ArrayList<>();

		for (Usuario usuario : usuarios) {
			int idade = usuario.getIdade();
			if (idade >= idadeMinima) {
				usuariosAcimaIdadeMinima.add(usuario);
			}
		}
		return usuariosAcimaIdadeMinima;
	}

	/*
	 * public List<Usuario> listarUsuariosPorTipo(Class tipo) { List<Usuario>
	 * usuariosDoTipo = new ArrayList<>(); for (Usuario u : usuarios) { if
	 * (tipo.isInstance(u)) { usuariosDoTipo.add(u); } } return usuariosDoTipo; }
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Usuario usuario : usuarios) {
			sb.append(usuario.toString()).append("\n");
		}
		return sb.toString();
	}

	public void imprimirConsumidores() {

		for (Usuario usuario : usuarios) {
			if (usuario instanceof Consumidor) {
				System.out.println(usuario.printUser());
			}

		}
	}

	public void imprimirProdutor() {

		for (Usuario usuario : usuarios) {
			if (usuario instanceof Produtor) {
				System.out.println(usuario.printUser());
			}

		}
	}

	public void listaDeMaiorde16() {
		for (Usuario usuario : usuarios) {
			int idade = usuario.getIdade();
			if (idade > 16) {
				System.out.println(usuario.printUser());
			}
		}
	}

}