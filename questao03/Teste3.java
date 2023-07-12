package questao03;

import questao03.dados.RepositorioPalestras;
import questao03.dados.RepositorioPessoas;
import questao03.negocio.ControladorRECnPlay;
import questao03.negocio.beans.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Teste3 {
    public static void main(String[] args) {

        RepositorioPessoas repositorioPessoas = new RepositorioPessoas();
        RepositorioPalestras repositorioPalestras = new RepositorioPalestras();
        ControladorRECnPlay cnPlay = new ControladorRECnPlay(repositorioPessoas, repositorioPalestras);

        Palestrante palestrante1 = new Palestrante(11549, "gustavof@gmail.com", "GUSTAVO FRANCO", LocalDate.of(2000,02,12), "ÁGUA PRETA", "EMPRESA X");
        Palestrante palestrante2 = new Palestrante(54988, "simonez@gmail.com", "SIMONE ZELAQUETT", LocalDate.of(2000,05,04), "PALMARES", "ACCENTURE");
        Palestrante palestrante3 = new Palestrante(31544, "andreap@gmail.com", "ANDREA PINHO", LocalDate.of(2000,12,02), "RECIFE", "PREFEITURA DO RECIFE");
        Palestrante palestrante4 = new Palestrante(87233, "marianam@gmail.com", "MARIANA MOURA", LocalDate.of(2000,06,12), "CARUARU", "GRUPO MOURA");
        Palestrante palestrante5 = new Palestrante(65644, "silviom@gmail.com", "SILVIO MEIRA", LocalDate.of(2000,04,11), "CATENDE", "UFPE");

        Participante participante1 = new Participante(147, "rafaelr@gmail.com", "Rafael", LocalDate.of(2003, 06, 24), "Água Preta", Trilha.CIDADES);
        Participante participante2 = new Participante(258, "danilor@gmail.com", "Danilo", LocalDate.of(2000, 07, 24), "Rio de Janeiro", Trilha.TECNOLOGIA);
        Participante participante3 = new Participante(369, "thaianev@gmail.com", "Thaiane", LocalDate.of(1999, 10, 28), "Santos", Trilha.ECONOMIA_CRIATIVA);
        Participante participante4 = new Participante(123, "caiov@gmail.com", "Caio", LocalDate.of(1995, 02, 02), "Santos", Trilha.CIDADES);
        Participante participante5 = new Participante(456, "cauav@gmail.com", "Cauã", LocalDate.of(2003, 12, 26), "Santos", Trilha.TECNOLOGIA);
        Participante participante6 = new Participante(789, "leonardol@gmail.com", "Leonardo", LocalDate.of(2003, 02, 16), "Palmares", Trilha.CIDADES);
        Participante participante7 = new Participante(159, "rogerior@gmail.com", "Rogerio", LocalDate.of(1998, 10, 11), "Água Preta", Trilha.TECNOLOGIA);
        Participante participante8 = new Participante(357, "gracietem@gmail.com", "Graciete", LocalDate.of(1970, 11, 11), "Palmares", Trilha.ECONOMIA_CRIATIVA);

        Palestra palestra1 = new Palestra(12345, Trilha.TECNOLOGIA, palestrante1,
                " Palestra sobre como as inovações tecnológicas financeiras podem influenciar o sistema financeiro",
                LocalDateTime.of(2023,10,02,10,00), "TEATRO APOLO", "A inovação financeira e os sistemas financeiro do futuro" );

        Palestra palestra2 = new Palestra(12346, Trilha.TECNOLOGIA, palestrante2,
                "Nessa atividade os participantes assistirão a performance do NAO- humanóide programado por estudantes da rede municipal do Recife, am \n"
                        + "apresentações de Yoga e Dança que serão contagiantes e motivarão a interação dos presentes.",
                        LocalDateTime.of(2023,10,02,11,15), "Accenture Innovation Center", " Apresentação do Humanóide NAO" );

        Palestra palestra3 = new Palestra(12347, Trilha.ECONOMIA_CRIATIVA, palestrante3, " Durante o evento os palestrantes serão entrevistados como " +
                "pauta da Cobertura jornalística das ações do Rec'n'Play , realizadas por \n" + "estudantes da Prefeitura de Recife. Muitos participantes poderão compor " +
                "com os palestrantes as entrevistas prestando depoimentos sobre o \n" + "evento e suas impressões e novas aprendizagens.",
                LocalDateTime.of(2023,10,02,10,00), "TEATRO APOLO", "Imprensa Mirim" );

        Palestra palestra4 = new Palestra(12348, Trilha.CIDADES, palestrante4, "Uma conversa com os sócios e membros da Escola F " +
                "para debater um novo modelo educacional voltado para famílias empresárias. Um modelo de \n" + "negócio colaborativo que valoriza a aprendizagem a " +
                "partir da troca de experiências, investe na facilitação de grupos para gerar conhecimento e \n" + "desenvolvimento, por meio da construção de entendimentos " +
                "e não apenas a partir de conteúdos externos.", LocalDateTime.of(2023,10,04,10,00),
                "CESAR Bom Jesus - Sala Garagem (5º andar)", "Educação experimental para famílias empresárias");

        Palestra palestra5 = new Palestra(12349, Trilha.CIDADES, palestrante5, "Talk Show com o renomado líder do setor de inovação que conversá sobre o tema de " +
                "transformação digital.", LocalDateTime.of(2023,10,05,10,00), "Cais do Sertão - Auditório", " Como você e a sua " +
                "empresa " + "irão sobreviver ao apocalipse digital?" );

        List<Avaliacao> avaliacaos1 = new ArrayList<>();
        avaliacaos1.add(new Avaliacao(5, participante1,palestra1));
        avaliacaos1.add(new Avaliacao(5, participante2,palestra1));
        avaliacaos1.add(new Avaliacao(5, participante5,palestra1));

        List<Avaliacao> avaliacaos2 = new ArrayList<>();
        avaliacaos2.add(new Avaliacao(4, participante8,palestra2));
        avaliacaos2.add(new Avaliacao(3, participante4,palestra2));
        avaliacaos2.add(new Avaliacao(2, participante6,palestra2));

        List<Avaliacao> avaliacaos4 = new ArrayList<>();
        avaliacaos4.add(new Avaliacao(4, participante2,palestra4));
        avaliacaos4.add(new Avaliacao(5, participante5,palestra4));
        avaliacaos4.add(new Avaliacao(3, participante7,palestra4));

        List<Avaliacao> avaliacaos5 = new ArrayList<>();
        avaliacaos5.add(new Avaliacao(4, participante1,palestra5));
        avaliacaos5.add(new Avaliacao(3, participante3,palestra5));
        avaliacaos5.add(new Avaliacao(5, participante5,palestra5));

        cnPlay.cadastrarParticipante(participante1);
        cnPlay.cadastrarParticipante(participante2);
        cnPlay.cadastrarParticipante(participante3);
        cnPlay.cadastrarParticipante(participante4);
        cnPlay.cadastrarParticipante(participante5);
        cnPlay.cadastrarParticipante(participante6);
        cnPlay.cadastrarParticipante(participante7);
        cnPlay.cadastrarParticipante(participante8);

        // O PALESTRANTE É CADASTRADO JUNTO COM A PALESTRA
        cnPlay.cadastrarPalestra(palestra1);
        cnPlay.cadastrarPalestra(palestra2);
        cnPlay.cadastrarPalestra(palestra3); // N CADASTRA POIS É NO MESMO LOCALDATETIME E LOCAL QUE A PALESTRA 1
        cnPlay.cadastrarPalestra(palestra4);
        cnPlay.cadastrarPalestra(palestra5);
        
        cnPlay.avaliarPalestra(avaliacaos1);
        cnPlay.avaliarPalestra(avaliacaos2);
        cnPlay.avaliarPalestra(avaliacaos4);
        cnPlay.avaliarPalestra(avaliacaos5);

        Palestra palestra3new = new Palestra(12347, Trilha.ECONOMIA_CRIATIVA, palestrante3, " Durante o evento os palestrantes serão entrevistados como " +
                "pauta da Cobertura jornalística das ações do Rec'n'Play , realizadas por \n" + "estudantes da Prefeitura de Recife. Muitos participantes poderão compor " +
                "com os palestrantes as entrevistas prestando depoimentos sobre o \n" + "evento e suas impressões e novas aprendizagens.",
                LocalDateTime.of(2023,10,03,12,00), "TEATRO APOLO", "Imprensa Mirim" );

        List<Avaliacao> avaliacaos3 = new ArrayList<>();
        avaliacaos3.add(new Avaliacao(2, participante2,palestra3new));
        avaliacaos3.add(new Avaliacao(2, participante7,palestra3new));
        avaliacaos3.add(new Avaliacao(2, participante1,palestra3new));

        cnPlay.cadastrarPalestra(palestra3new); // RECADASTRANDO A PALESTRA 3 POIS ELA NÃO FOI CADASTRADA ANTERIORMENTE
        cnPlay.avaliarPalestra(avaliacaos3);


        System.out.println("\n*------------------------------------------------------------*");
        System.out.println("                 LISTA DE USUARIOS ACIMA DE 39:                 ");
        System.out.println("*------------------------------------------------------------*\n");
        cnPlay.listarPessoasAcimaDaIdade(39);
        System.out.println("\n*------------------------------------------------------------*");
        System.out.println("         LISTA COM AS PALESTRAS COM MÉDIA MAIOR QUE 3:          ");
        System.out.println("*------------------------------------------------------------*\n");
        cnPlay.listarTotalPalestrasComMediaAvaliacaoMaiorQue(3);
        System.out.println("\n*------------------------------------------------------------*");
        System.out.println("             LISTA DAS PALESTRAS MAIS BEM AVALIADAS:            ");
        System.out.println("*------------------------------------------------------------*\n");
        cnPlay.listarPalestrasMaisBemAvaliadas();
    }
}
