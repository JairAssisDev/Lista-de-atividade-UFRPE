package questao02;

import java.time.LocalDate;
import java.time.Period;

public abstract class Usuario {

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String email;
    private int idade;

    public Usuario(String nomeCompleto, LocalDate dataNascimento, String email) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.idade = calcularIdade();
    }

    private int calcularIdade() {
        LocalDate hoje = LocalDate.now(); // Represents the current date
        Period periodo = Period.between(dataNascimento, hoje);
        return periodo.getYears();
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", email='" + email + '\'' +
                '}';
    }
}

