package questao03;

import java.time.LocalDateTime;
import java.util.List;

public class Palestra {


    public Trilha trilha;
    public long id;
    public String titulo;
    public Palestrante palestrante;
    public String descricao;
    public List<Avaliacao> avaliacaos;
    public LocalDateTime dataHora;
    public String local;

    public Palestra(long id, Trilha trilha, Palestrante palestrante, String descricao, List<Avaliacao> avaliacaos,
                    LocalDateTime dataHora, String local, String titulo) {
        this.id = id;
        this.trilha = trilha;
        this.palestrante = palestrante;
        this.descricao = descricao;
        this.avaliacaos = avaliacaos;
        this.dataHora = dataHora;
        this.local = local;
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Avaliacao> getAvaliacaos() {
        return avaliacaos;
    }

    public void setAvaliacaos(List<Avaliacao> avaliacaos) {
        this.avaliacaos = avaliacaos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
