package questao03.dados;

import questao03.negocio.beans.Avaliacao;
import questao03.negocio.beans.Palestra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPalestras {
    private List<Palestra> palestras = new ArrayList<Palestra>();

    private Palestra palestra;
   

    public void cadastrarPalestra(Palestra palestra) {
    	palestras.add(palestra);
    }
    public List<Palestra> getPalestras() {
		return palestras;
	}


	public void setPalestras(List<Palestra> palestras) {
		this.palestras = palestras;
	}


	public Palestra getPalestra() {
		return palestra;
	}


	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}


	private boolean existePalestraComId(int id) {
        for (Palestra palestra : palestras) {
            if (palestra.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void inserirPalestra(Palestra p) {
        if (!existePalestraComId((int) p.getId())) {
            palestras.add(p);
        } else {
            System.out.println("Já existe uma palestra com o mesmo ID.");
        }
    }


    public boolean buscarPalestraPorTitulo(String palestrat) {
        for (Palestra palestra: palestras) {
            if (palestra.getTitulo() == palestrat) {
                return true;
            }
        }
        return false;
    }

    public boolean buscarPalestraPorDataHora (LocalDateTime dataHora){
        for (Palestra palestra : palestras){
            if (palestra.getDataHora().equals(dataHora)){
                return true;
            }
        }
        return false;
    }

    public List<Palestra> listarPalestras() {
        return palestras;
    }

    public Palestra buscarPalestrasPorLocalEHorario(String local, LocalDateTime horario) {
        for (Palestra palestra : palestras) {
            if (palestra.getLocal().equals(local) && palestra.getDataHora().equals(horario)) {
                return palestra;
            }
        }
        return null;
    }

    public List<Palestra> listarPalestrasComMediaAvaliacaoIgualOuMaiorQue(int nota) {
        List<Palestra> palestrasFiltradas = new ArrayList<>();
        for (Palestra palestra : palestras) {
            if (palestra.getMediaAvaliacao() >= nota) {
                palestrasFiltradas.add(palestra);
            }
        }
        return palestrasFiltradas;
    }
    public List<Avaliacao> listarTodasAvaliacoes() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        for (Palestra palestra : palestras) {
            avaliacoes.addAll(palestra.getAvaliacaos());
        }
        return avaliacoes;
    }

}
