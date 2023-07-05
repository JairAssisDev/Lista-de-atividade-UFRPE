package questao03;

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

    public List<Palestrante> listarPalestrantesPorEmpresa(String empresa) {
        List<Palestrante> palestrantes = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Palestrante) {
                Palestrante palestrante = (Palestrante)pessoa;
                if (palestrante.getEmpresa().equals(empresa)) {
                    palestrantes.add(palestrante);
                }
            }
        }
        return palestrantes;
    }

    public List<Participante> listarParticipantesComInteresseEm(String trilha) {
        List<Participante> participantes = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Participante) {
                Participante participante = (Participante) pessoa;
                if (participante.getTrilhaDeInteresse().equals(trilha)) {
                    participantes.add(participante);
                }
            }
        }
        return participantes;
    }

//    public List<Participante> listarParticipantesComIdadeMaiorQue(int idade) {
//        List<Participante> participantes = new ArrayList<>();
//        for (Pessoa pessoa : pessoas) {
//            if (pessoa instanceof Participante) {
//                Participante participante = (Participante) pessoa;
//                if (participante.getIdade() >= idade) {
//                    participantes.add(participante);
//                }
//            }
//        }
//        return participantes;
//    }
}
