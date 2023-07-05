package questao02;

import java.time.LocalDate;
import java.util.List;

public class Produtor extends Usuario{

    private String nomeCanal;
    private List<String> categorias;

    public Produtor(String nomeCompleto, LocalDate dataNascimento, String email, String nomeCanal, List<String> categorias) {
        super(nomeCompleto, dataNascimento, email);
        this.nomeCanal = nomeCanal;
        this.categorias=categorias;
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        return "Produtor [email=" + getEmail() + ", nomeCompleto=" + getNomeCompleto() + ", dataNascimento="
                + getDataNascimento() + ", nomeCanal=" + nomeCanal + ", categorias=" + categorias + "]";
    }
}
