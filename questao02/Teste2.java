package questao02;

import questao02.dados.RepositorioMidia;
import questao02.dados.RepositorioReproducaoMidia;
import questao02.dados.RepositorioUsuario;
import questao02.negocios.ControladorMidia;
import questao02.negocios.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Teste2 {

	public static void main(String[] args) {

		RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
		RepositorioMidia repositorioMidia = new RepositorioMidia();
		RepositorioReproducaoMidia repositorioReproducaoMidia = new RepositorioReproducaoMidia();

		ControladorMidia controladorMidia = new ControladorMidia(repositorioUsuario, repositorioMidia,
				repositorioReproducaoMidia);

		List<String> categorias1 = new ArrayList<>();
		categorias1.add("educação");
		categorias1.add("jogos");
		categorias1.add("tutoriais");
		Usuario produtor1 = new Produtor("Rafael Rodrigues", LocalDate.of(2003, 06, 24), "rafaelr@gmail.com",
				"Rafael Tutorias", categorias1);

		List<String> categorias2 = new ArrayList<>();
		categorias2.add("jogos");
		categorias2.add("politica");
		Usuario produtor2 = new Produtor("Jair Soares", LocalDate.of(1970, 12, 23), "jairs@gmail.com", "Scooby Nasus",
				categorias2);

		List<String> categorias3 = new ArrayList<>();
		categorias3.add("educação");
		categorias3.add("jogos");
		categorias3.add("tutoriais");
		Usuario produtor3 = new Produtor("Leonardo Lucas", LocalDate.of(2003, 02, 16), "leonardol@gmail.com", "LeviNTC",
				categorias3);

		List<String> categorias4 = new ArrayList<>();
		categorias4.add("Casa");
		categorias4.add("Diversão");
		Usuario consumidor1 = new Consumidor("Benvenuto Estevão", LocalDate.of(2003, 04, 02), "estevaof@gmail.com",
				categorias4);

		List<String> categorias5 = new ArrayList<>();
		categorias5.add("Trabalho");
		categorias5.add("Educação");
		Usuario consumidor2 = new Consumidor("Maria Silva", LocalDate.of(2020, 8, 15), "mariasilva@gmail.com",
				categorias5);

		List<String> categorias6 = new ArrayList<>();
		categorias6.add("Esportes");
		categorias6.add("Saúde");
		Usuario consumidor3 = new Consumidor("João Souza", LocalDate.of(1985, 2, 10), "joaosouza@gmail.com",
				categorias6);

		List<String> categorias7 = new ArrayList<>();
		categorias7.add("Viagem");
		categorias7.add("Aventura");
		Usuario consumidor4 = new Consumidor("Carolina Santos", LocalDate.of(1998, 11, 25), "carolinasantos@gmail.com",
				categorias7);

		List<String> categorias8 = new ArrayList<>();
		categorias8.add("Moda");
		categorias8.add("Beleza");
		Usuario consumidor5 = new Consumidor("Pedro Almeida", LocalDate.of(1980, 5, 3), "pedroalmeida@gmail.com",
				categorias8);

		List<String> categorias9 = new ArrayList<>();
		categorias9.add("Tecnologia");
		categorias9.add("Inovação");
		Usuario consumidor6 = new Consumidor("Ana Costa", LocalDate.of(1995, 12, 18), "anacosta@gmail.com",
				categorias9);

		List<String> categorias10 = new ArrayList<>();
		categorias10.add("Gastronomia");
		categorias10.add("Cultura");
		Usuario consumidor7 = new Consumidor("Rafael Mendes", LocalDate.of(1987, 7, 8), "rafaelmendes@gmail.com",
				categorias10);

		controladorMidia.cadastrarUsuario(produtor1);
		controladorMidia.cadastrarUsuario(produtor2);
		controladorMidia.cadastrarUsuario(produtor3);
		controladorMidia.cadastrarUsuario(consumidor1);
		controladorMidia.cadastrarUsuario(consumidor2);
		controladorMidia.cadastrarUsuario(consumidor3);
		controladorMidia.cadastrarUsuario(consumidor4);
		controladorMidia.cadastrarUsuario(consumidor5);
		controladorMidia.cadastrarUsuario(consumidor6);
		controladorMidia.cadastrarUsuario(consumidor7);
		controladorMidia.removerUsuario(consumidor7);

		System.out.println("\n--------------------------------------------------------------");
		System.out.println("                     LISTA DE CONSUMIDORES:                     ");
		System.out.println("*------------------------------------------------------------*\n");
		controladorMidia.getRepositorioUsuario().imprimirConsumidores();
		System.out.println("\n*------------------------------------------------------------*");
		System.out.println("                      LISTA DE PRODUTORES:                      ");
		System.out.println("*------------------------------------------------------------*\n");
		controladorMidia.getRepositorioUsuario().imprimirProdutor();
		System.out.println("\n*------------------------------------------------------------*");
		System.out.println("               LISTA DE USUARIOS ACIMA DE 16 ANOS:              ");
		System.out.println("*------------------------------------------------------------*\n");
		controladorMidia.getRepositorioUsuario().listaDeMaiorde16();
		System.out.println("\n*------------------------------------------------------------*");

		Midia midia1 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 1", 18, "Jogos", (Produtor) produtor1);
		Midia midia2 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 2", 15, "Jogos", (Produtor) produtor3);
		Midia midia3 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 3", 14, "Jogos", (Produtor) produtor2);
		Midia midia4 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 4", 12, "Educação",(Produtor) produtor1);
		Midia midia5 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 5", 18, "Cultura",(Produtor) produtor1);
		Midia midia6 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 6", 10, "Gastronomia",(Produtor) produtor2);
		Midia midia7 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 7", 1, "Inovação",(Produtor) produtor3);
		Midia midia8 = new Midia(LocalDateTime.of(2023, 07, 04, 15, 31), "video 8", 12, "Beleza", (Produtor) produtor3);

		controladorMidia.cadastrarMidia(midia1);
		controladorMidia.cadastrarMidia(midia2);
		controladorMidia.cadastrarMidia(midia3);
		controladorMidia.cadastrarMidia(midia4);
		controladorMidia.cadastrarMidia(midia5);
		controladorMidia.cadastrarMidia(midia6);
		controladorMidia.cadastrarMidia(midia7);
		controladorMidia.cadastrarMidia(midia8);
		controladorMidia.removerMidia(midia8);

		System.out.println("      LISTA DE MIDIAS COM FAIXA ETARIA MAIOR QUE 14 ANOS:       ");
		System.out.println("*------------------------------------------------------------*\n");
		controladorMidia.getRepositorioMidia().listarMidiasPorFaixaEtaria();
		System.out.println("\n*------------------------------------------------------------*");
		System.out.println("              LISTA DE MIDIAS COM CATEGORIAS JOGOS              ");
		System.out.println("*------------------------------------------------------------*\n");
		controladorMidia.getRepositorioMidia().listarMidiasPorCategoria();
		System.out.println("\n*------------------------------------------------------------*");
		
		
		
		ReproducaoMidia reproducaoMidia1 = new ReproducaoMidia(midia1, (Consumidor)consumidor2, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia2 = new ReproducaoMidia(midia2, (Consumidor)consumidor1, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia3 = new ReproducaoMidia(midia3, (Consumidor)consumidor2, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia4 = new ReproducaoMidia(midia3, (Consumidor)consumidor3, LocalDateTime.of(2023,01,04,16,44));
        ReproducaoMidia reproducaoMidia5 = new ReproducaoMidia(midia2, (Consumidor)consumidor4, LocalDateTime.of(2023,01,04,16,44));
        ReproducaoMidia reproducaoMidia6 = new ReproducaoMidia(midia1, (Consumidor)consumidor5, LocalDateTime.of(2023,01,04,16,44));
        ReproducaoMidia reproducaoMidia7 = new ReproducaoMidia(midia2, (Consumidor)consumidor1, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia8 = new ReproducaoMidia(midia3, (Consumidor)consumidor1, LocalDateTime.of(2023,04,04,16,44));
        ReproducaoMidia reproducaoMidia9 = new ReproducaoMidia(midia1, (Consumidor)consumidor2, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia10 = new ReproducaoMidia(midia3, (Consumidor)consumidor2, LocalDateTime.of(2023,06,04,16,44));
        ReproducaoMidia reproducaoMidia11 = new ReproducaoMidia(midia3, (Consumidor)consumidor5, LocalDateTime.of(2023,07,04,16,44));
        ReproducaoMidia reproducaoMidia12 = new ReproducaoMidia(midia7, (Consumidor)consumidor4, LocalDateTime.of(2023,07,04,16,44));
        ReproducaoMidia reproducaoMidia13 = new ReproducaoMidia(midia5, (Consumidor)consumidor2, LocalDateTime.of(2023,07,04,16,44));
        ReproducaoMidia reproducaoMidia14 = new ReproducaoMidia(midia4, (Consumidor)consumidor3, LocalDateTime.of(2023,07,04,16,44));
        ReproducaoMidia reproducaoMidia15 = new ReproducaoMidia(midia3, (Consumidor)consumidor1, LocalDateTime.of(2023,05,04,16,44));
        ReproducaoMidia reproducaoMidia16 = new ReproducaoMidia(midia1, (Consumidor)consumidor1, LocalDateTime.of(2023,02,04,16,44));
        ReproducaoMidia reproducaoMidia17 = new ReproducaoMidia(midia7, (Consumidor)consumidor1, LocalDateTime.of(2023,01,04,16,44));
        ReproducaoMidia reproducaoMidia18 = new ReproducaoMidia(midia3, (Consumidor)consumidor2, LocalDateTime.of(2023,01,04,16,44));
        ReproducaoMidia reproducaoMidia19 = new ReproducaoMidia(midia2, (Consumidor)consumidor1, LocalDateTime.of(2023,03,04,16,44));
        ReproducaoMidia reproducaoMidia20 = new ReproducaoMidia(midia1, (Consumidor)consumidor1, LocalDateTime.of(2023,03,04,16,44));

        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia1);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia2);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia3);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia4);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia5);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia6);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia7);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia8);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia9);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia10);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia11);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia12);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia13);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia14);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia15);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia16);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia17);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia18);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia19);
        controladorMidia.cadastrarReproducaoMidia(reproducaoMidia20);

        LocalDateTime dataInicial = LocalDateTime.of(2023, 06, 03, 0, 0);
        LocalDateTime dataFinal = LocalDateTime.of(2023, 07, 05, 0, 0);

		System.out.println("           MIDIAS REPRODUZIDAS DE 03/06/2023 A 05/07/2023:        ");
        System.out.println("*--------------------------------------------------------------*\n");
        controladorMidia.getRepositorioReproducaoMidia().listInDateTime(dataInicial, dataFinal);
		System.out.println("\n*--------------------------------------------------------------*");
        System.out.println("               MIDIAS REPRODUZIDAS PELO CONSUMIDOR 1:             ");
        System.out.println("*--------------------------------------------------------------*\n");
        controladorMidia.getRepositorioReproducaoMidia().listaMidiaUser((Consumidor)consumidor1);
		System.out.println("\n*--------------------------------------------------------------*");
        System.out.println("          LISTA DE REPRODUCAO DE MIDIAS DA CATEGORIA JOGOS:       ");
        System.out.println("*--------------------------------------------------------------*\n");
        controladorMidia.getRepositorioReproducaoMidia().listaCategoriaJogo();
	}
}
