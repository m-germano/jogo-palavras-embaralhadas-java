package entities;




public class MecanicaDoJogoPadrao implements MecanicaDoJogo {
    private BancoDePalavras bancoDePalavras;
    private Embaralhador embaralhador;
    private String palavraAtual;
    private String palavraEmbaralhada;
    private int tentativasRestantes;
    private int pontuacao;

    public MecanicaDoJogoPadrao(BancoDePalavras bancoDePalavras, FabricaEmbaralhadores fabricaEmbaralhadores) {
        this.bancoDePalavras = bancoDePalavras;
        this.embaralhador = fabricaEmbaralhadores.getEmbaralhadorAleatorio();
        this.tentativasRestantes = 3; // 3 tentativas por palavra
        this.pontuacao = 0;
    }

    @Override
    public String getPalavraEmbaralhada() {
        palavraAtual = bancoDePalavras.getPalavraAleatoria();
        palavraEmbaralhada = embaralhador.embaralhar(palavraAtual);
        return palavraEmbaralhada;
    }

    @Override
    public boolean verificarTentativa(String tentativa) {
        if (tentativa.equalsIgnoreCase(palavraAtual)) {
            pontuacao += 10; // Pontuação por acerto
            tentativasRestantes = 3; // Reiniciar tentativas para próxima palavra
            return true;
        } else {
            tentativasRestantes--;
            return false;
        }
    }

    @Override
    public boolean jogoAcabou() {
        return tentativasRestantes <= 0; // Jogo acaba quando não há mais tentativas
    }

    @Override
    public int getPontuacaoFinal() {
        return pontuacao;
    }
}
