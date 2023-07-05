package questao03;

import java.time.LocalDate;

public class Participante extends Pessoa{

    private String trilhaDeInteresse;

    public Participante(long codigo, String email, String nome, LocalDate dataNascimento, String cidade, String trilhaDeInteresse) {
        super(codigo, email, nome, dataNascimento, cidade);
        this.trilhaDeInteresse = trilhaDeInteresse;
    }

    public String getTrilhaDeInteresse() {
        return trilhaDeInteresse;
    }

    public void setTrilhaDeInteresse(String trilhaDeInteresse) {
        this.trilhaDeInteresse = trilhaDeInteresse;
    }
}
