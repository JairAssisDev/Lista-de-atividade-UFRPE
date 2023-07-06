package questao02.negocios.beans;

import java.time.LocalDateTime;

public class Midia {

    private LocalDateTime dataHoraUpload;
    private String arquivo;
    private int faixaEtariaMinima;
    private String categoria;
    private Produtor produtor;

    public Midia(LocalDateTime dataHoraUpload, String arquivo, int faixaEtariaMinima, String categoria, Produtor produtor) {
        this.dataHoraUpload = dataHoraUpload;
        this.arquivo = arquivo;
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.categoria = categoria;
        this.produtor = produtor;
    }

    public LocalDateTime getDataHoraUpload() {
        return dataHoraUpload;
    }

    public String getArquivo() {
        return arquivo;
    }

    public int getFaixaEtariaMinima() {
        return faixaEtariaMinima;
    }

    public String getCategoria() {
        return categoria;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    @Override
    public String toString() {
        return "Midia [dataHoraUpload=" + dataHoraUpload + ", arquivo=" + arquivo + ", faixaEtariaMinima="
                + faixaEtariaMinima + ", categoria=" + categoria + ", produtor=" + produtor + "]";
    }
}
