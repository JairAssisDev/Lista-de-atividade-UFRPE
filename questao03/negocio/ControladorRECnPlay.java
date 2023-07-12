package questao03.negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import questao03.dados.RepositorioPalestras;
import questao03.dados.RepositorioPessoas;
import questao03.negocio.beans.*;

public class ControladorRECnPlay {

    private RepositorioPessoas repositorioPessoas;
    private RepositorioPalestras repositorioPalestras;

    public ControladorRECnPlay(RepositorioPessoas repositorioPessoas, RepositorioPalestras repositorioPalestras){
        this.repositorioPessoas = repositorioPessoas;
        this.repositorioPalestras = repositorioPalestras;
    }

    public void cadastrarParticipante (Pessoa participante) {
        if (participante != null && participante instanceof Participante && ((Participante) participante).getTrilhaDeInteresse() != null) {
            repositorioPessoas.inserirPessoa(participante);
        }
    }

    public void cadastrarPalestrante (Pessoa palestrante) {
        if (palestrante instanceof Palestrante && ((Palestrante) palestrante).getEmpresa() != null) {
            repositorioPessoas.inserirPessoa(palestrante);
        }
    }

    public void cadastrarPalestra (Palestra palestra){
        if (palestra != null && !repositorioPalestras.buscarPalestraPorTitulo(palestra.getTitulo())){
            cadastrarPalestrante(palestra.palestrante);
            if (!repositorioPalestras.buscarPalestraPorDataHora(palestra.dataHora)){
                repositorioPalestras.inserirPalestra(palestra);
            }
        }
    }

    public void avaliarPalestra(List<Avaliacao> avaliacoes) {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getNota() >= 0 && avaliacao.getNota() <= 5 && avaliacao.getAvaliador() != null) {
                for (Palestra palestra : repositorioPalestras.getPalestras()) {
                    if (palestra.getTitulo() == avaliacao.getPalestra().getTitulo()) {
                        palestra.adicionarNotasNaAvaliacao(avaliacao);
                        break;
                        
                    }
                }
            }
        }
    }

    public void listarPalestrasMaisBemAvaliadas() {
        List<Palestra> todasPalestras = repositorioPalestras.getPalestras();
        
        todasPalestras.sort(Comparator.comparingDouble(Palestra::getMediaAvaliacao).reversed());

        for (Palestra palestra : todasPalestras) {
            System.out.println("* " + palestra.getTitulo() + " || Média de avaliação = " + palestra.getMediaAvaliacao());
        }
    }
    
    public void listarTotalPalestrasComMediaAvaliacaoMaiorQue(int nota) {
        List<Palestra> todasPalestras = repositorioPalestras.getPalestras();
        List<Palestra> palestrasComMediaMaior = new ArrayList<>();

        for (Palestra palestra : todasPalestras) {
            if (palestra.getMediaAvaliacao() > nota) {
                palestrasComMediaMaior.add(palestra);
            }
        }
        for (Palestra palestra : palestrasComMediaMaior) {
            System.out.println("* " + palestra.getTitulo() + " || Média de avaliação = " + palestra.getMediaAvaliacao());
        }
    }

    public void listarPessoasAcimaDaIdade(int idadeMinima) {
        List<Pessoa> pessoasAcimaDaIdade = new ArrayList<>();

        for (Pessoa pessoa : repositorioPessoas.getPessoas()) {
            if (pessoa.getIdade() > idadeMinima) {
                pessoasAcimaDaIdade.add(pessoa);
            }
        }
        for (Pessoa pessoa : pessoasAcimaDaIdade) {
            System.out.println(pessoa.getNome() + ": " + pessoa.getIdade() + " anos");
        }
    }
}

