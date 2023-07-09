package questao02;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Consumidor extends Usuario{

    private List<String> categoriasInteresse;

    public Consumidor(String nomeCompleto, LocalDate dataNascimento, String email, List<String> categoriasInteresse) {
        super(nomeCompleto, dataNascimento, email);
        this.categoriasInteresse = categoriasInteresse;
    }

    public List<String> getCategoriasInteresse() {
        return categoriasInteresse;
    }

    @Override
    public String toString() {
        return "Consumidor [email=" + getEmail() + ", nomeCompleto=" + getNomeCompleto() + ", dataNascimento= "
                + getDataNascimento() + ", categoriasInteresse=" + categoriasInteresse + "]";
    }
}
