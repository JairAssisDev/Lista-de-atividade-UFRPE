package questao03.negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante extends Pessoa {

    private Trilha trilhaDeInteresse;
    private List<Participante> participantes;

    public Participante(long codigo, String email, String nome, LocalDate dataNascimento, String cidade, Trilha trilhaDeInteresse) {
        super(codigo, email, nome, dataNascimento, cidade);
        this.trilhaDeInteresse = trilhaDeInteresse;
        participantes = new ArrayList<>();
    }

    public Trilha getTrilhaDeInteresse() {
        return trilhaDeInteresse;
    }

    public void listaDeMaiorde39() {
        for (Participante participante : participantes) {
            int idade = participante.getIdade();
            if(idade > 16) {
                System.out.println(participante.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "Participante[" +
                "codigo=" + getCodigo()  +
                ", email='" + getEmail() + '\'' +
                ", nome='" + getNome() + '\'' +
                ']';
    }
}
