package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {
    private List<String> palavras;

    public BancoDePalavras() {
        // Lista fixa de palavras
        this.palavras = new ArrayList<>();
        palavras.add("java");
        palavras.add("programacao");
        palavras.add("computador");
        palavras.add("desenvolvimento");
        palavras.add("algoritmo");
        palavras.add("openai");
        palavras.add("inteligencia");
        palavras.add("artificial");
        palavras.add("aprendizado");
        palavras.add("maquina");
        palavras.add("robotica");
        palavras.add("processamento");
        palavras.add("dados");
        palavras.add("estrutura");
        palavras.add("software");
        palavras.add("hardware");
        palavras.add("interface");
        palavras.add("usuario");
        palavras.add("rede");
        palavras.add("seguranca");
    }

    public String getPalavraAleatoria() {
        Random random = new Random();
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }
}
