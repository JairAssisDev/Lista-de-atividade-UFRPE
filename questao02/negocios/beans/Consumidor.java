package questao02.negocios.beans;

import java.time.LocalDate;
import java.util.List;

public class Consumidor extends Usuario {

    private List<String> categoriasInteresse;

    public Consumidor(String nomeCompleto, LocalDate dataNascimento, String email, List<String> categoriasInteresse) {
        super(nomeCompleto, dataNascimento, email);
        this.categoriasInteresse = categoriasInteresse;
    }

    @Override
    public String toString() {
        return "Consumidor [email=" + getEmail() + ", nomeCompleto=" + getNomeCompleto() + ", dataNascimento="
                + getDataNascimento() + ", categoriasInteresse=" + categoriasInteresse + "]";
    }
}
