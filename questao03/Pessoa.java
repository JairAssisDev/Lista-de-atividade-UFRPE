package questao03;

import java.time.LocalDate;

public abstract class Pessoa {

    private long codigo;
    private String email;
    private String nome;
    private LocalDate dataNascimento;
    private String cidade;

    public Pessoa(long codigo, String email, String nome, LocalDate dataNascimento, String cidade) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }
}
