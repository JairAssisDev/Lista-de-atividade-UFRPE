package questao01;

public class Cartas {
    public static final String[] NAIPES = {"C", "O", "P", "E"};
    public static final String[] VALORES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "10", "11"};
    public static final int[] PONTOS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    private String naipe;
    private String valor;
    private int pontosCartas;

    public Cartas(String naipe, String valor, int pontosCartas) {
        this.naipe = naipe;
        this.valor = valor;
        this.pontosCartas = pontosCartas;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public int getPontosCartas() {
        return pontosCartas;
    }

    @Override
    public String toString() {
        return "Cartas{" +
                "naipe='" + naipe + '\'' +
                ", valor='" + valor + '\'' +
                ", pontosCartas=" + pontosCartas +
                '}';
    }

}
