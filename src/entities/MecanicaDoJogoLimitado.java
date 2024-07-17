package entities;

import java.util.ArrayList;
import java.util.List;

public class MecanicaDoJogoLimitado implements MecanicaDoJogo {
    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private List<String> palavrasUtilizadas;
    private int tentativasGlobais;
    private int pontuacao;

    public MecanicaDoJogoLimitado(BancoDePalavras bancoDePalavras, FabricaEmbaralhadores fabricaEmbaralhadores) {
        this.bancoDePalavras = bancoDePalavras;
        this.embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
        this.palavrasUtilizadas = new ArrayList<>();
        this.tentativasGlobais = 10; // Limite global de tentativas
        this.pontuacao = 0;
    }

    @Override
    public String getPalavraEmbaralhada() {
        String palavraAtual;
        do {
            palavraAtual = bancoDePalavras.getPalavraAleatoria();
        } while (palavrasUtilizadas.contains(palavraAtual));
        palavrasUtilizadas.add(palavraAtual);
        return embaralhador.embaralhar(palavraAtual);
    }

    @Override
    public boolean verificarTentativa(String tentativa) {
        if (tentativa.equalsIgnoreCase(palavrasUtilizadas.get(palavrasUtilizadas.size() - 1))) {
            pontuacao += 10; // Pontuação por acerto
            return true;
        } else {
            tentativasGlobais--;
            return false;
        }
    }

    @Override
    public boolean jogoAcabou() {
        return tentativasGlobais <= 0 || palavrasUtilizadas.size() >= 5; // Jogo acaba após 10 tentativas ou 5 palavras
    }

    @Override
    public int getPontuacaoFinal() {
        return pontuacao;
    }
}