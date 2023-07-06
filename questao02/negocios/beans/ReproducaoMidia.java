package questao02.negocios.beans;


import questao02.negocios.beans.Consumidor;
import questao02.negocios.beans.Midia;

import java.time.LocalDateTime;


public class ReproducaoMidia {
	

    private Midia midia;
    private Consumidor consumidor;
    private LocalDateTime dataHoraReproducao;

    public ReproducaoMidia(Midia midia, Consumidor consumidor, LocalDateTime dataHoraReproducao) {
        this.midia = midia;
        this.consumidor = consumidor;
        this.dataHoraReproducao = dataHoraReproducao;
        
    }

    public Midia getMidia() {
        return midia;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public LocalDateTime getDataHoraReproducao() {
        return dataHoraReproducao;
    }

	
	


}
    
    
   

