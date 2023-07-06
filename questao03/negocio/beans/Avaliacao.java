package questao03.negocio.beans;

public class Avaliacao {

    private Palestra palestra;
    private int nota;
    private String comentario;
    private Participante avaliador;

    public Avaliacao(int nota, Participante avaliador,Palestra palestra) {
        this.nota = nota;
        this.avaliador = avaliador;
        this.palestra=palestra;
    }

    public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public void setAvaliador(Participante avaliador) {
		this.avaliador = avaliador;
	}

	public int getNota() {
        return nota;
    }

    public Participante getAvaliador() {
        return avaliador;
    }
    
}
