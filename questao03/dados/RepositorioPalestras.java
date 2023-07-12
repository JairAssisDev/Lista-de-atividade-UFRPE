package questao03.dados;

import questao03.negocio.beans.Avaliacao;
import questao03.negocio.beans.Palestra;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPalestras {
    private List<Palestra> palestras = new ArrayList<Palestra>();
    private Palestra palestra;
    public List<Palestra> getPalestras() {
		return palestras;
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

}
