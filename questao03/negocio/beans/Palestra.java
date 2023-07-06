package questao03.negocio.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Palestra {


    public Trilha trilha;
    public int id;
    public String titulo;
    public Palestrante palestrante;
    public String descricao;
    public List<Avaliacao> avaliacaos=new ArrayList<Avaliacao>();
    public LocalDateTime dataHora;
    public String local;

    public Palestra(int id, Trilha trilha, Palestrante palestrante, String descricao,
                    LocalDateTime dataHora, String local, String titulo) {
        this.id = id;
        this.trilha = trilha;
        this.palestrante = palestrante;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
        this.titulo = titulo;
    }

    public void adicionarNotasNaAvaliacao (Avaliacao avaliacao){
        avaliacaos.add(avaliacao);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getMediaAvaliacao() {
        if (avaliacaos.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (Avaliacao avaliacao : avaliacaos) {
            total += avaliacao.getNota();
        }
        return (double) total / avaliacaos.size();
    }

    public boolean verificarnull (){
        if (this.titulo != null && this.id >= 0 && this.avaliacaos != null && this.local != null &&
                this.trilha != null && this.dataHora != null && this.descricao != null && this.palestrante != null){
            return true;
        }
        return false;
    }

}
