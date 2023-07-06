package questao03.negocio.beans;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {

    private long codigo;
    private String email;
    private String nome;
    private LocalDate dataNascimento;
    private String cidade;

    private int idade;

    public Pessoa(long codigo, String email, String nome, LocalDate dataNascimento, String cidade) {
        this.codigo = codigo;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
        this.idade = calcularIdade();
    }

    public String getEmail() {
        return email;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCidade() {
        return cidade;
    }

    private int calcularIdade() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        return periodo.getYears();
    }

    public int getIdade() {
        return idade;
    }
}
