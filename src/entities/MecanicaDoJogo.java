package entities;

public interface MecanicaDoJogo {
    String getPalavraEmbaralhada();
    boolean verificarTentativa(String tentativa);
    boolean jogoAcabou();
    int getPontuacaoFinal();
}