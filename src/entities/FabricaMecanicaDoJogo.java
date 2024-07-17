package entities;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaMecanicaDoJogo {
    private List<Class<? extends MecanicaDoJogo>> mecanicasDisponiveis;

    public FabricaMecanicaDoJogo() {
        mecanicasDisponiveis = new ArrayList<>();
        mecanicasDisponiveis.add(MecanicaDoJogoPadrao.class);
        mecanicasDisponiveis.add(MecanicaDoJogoLimitado.class);
        // Adicionar outras implementações de MecanicaDoJogo conforme necessário
    }

    public MecanicaDoJogo getMecanicaDoJogo() {
        Random random = new Random();
        int indice = random.nextInt(mecanicasDisponiveis.size());
        try {
            Class<? extends MecanicaDoJogo> clazz = mecanicasDisponiveis.get(indice);
            Constructor<? extends MecanicaDoJogo> constructor = clazz.getDeclaredConstructor(BancoDePalavras.class, FabricaEmbaralhadores.class);
            return constructor.newInstance(new BancoDePalavras(), new FabricaEmbaralhadores());
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Retornar null em caso de erro
        }
    }
}
