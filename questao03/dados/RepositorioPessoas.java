package questao03.dados;

import questao03.negocio.beans.Palestrante;
import questao03.negocio.beans.Participante;
import questao03.negocio.beans.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPessoas {
    private List<Pessoa> pessoas;

    public RepositorioPessoas(){
        pessoas = new ArrayList<>();
    }


    public void inserirPessoa(Pessoa pessoa) {
        if (!existePessoaComEmail(pessoa.getEmail())) {
            pessoas.add(pessoa);
        } else {
            System.out.println("Email já relacioando a um usuário");
        }
    }

    private boolean existePessoaComEmail(String email) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void removerPessoa(String email) {
        Pessoa pessoa = buscarPessoaPorEmail(email);
        if (pessoa != null) {
            pessoas.remove(pessoa);
        } else {
            System.out.println("Email não encontrado");
        }
    }

    public Pessoa buscarPessoaPorEmail(String email) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        return null;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }
}
