package entities;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FabricaEmbaralhadores {
    private List<Class<? extends Embaralhador>> embaralhadoresDisponiveis;

    public FabricaEmbaralhadores() {
        embaralhadoresDisponiveis = new ArrayList<>();
        embaralhadoresDisponiveis.add(EmbaralhadorInversao.class);
        embaralhadoresDisponiveis.add(EmbaralhadorAleatorio.class);
        // Adicionar outras implementações de Embaralhador conforme necessário
    }

    public Embaralhador getEmbaralhadorAleatorio() {
        Random random = new Random();
        int indice = random.nextInt(embaralhadoresDisponiveis.size());
        try {
            Class<? extends Embaralhador> clazz = embaralhadoresDisponiveis.get(indice);
            Constructor<? extends Embaralhador> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            // Pode lançar uma exceção personalizada ou retornar um valor padrão, conforme a necessidade
            return null;
        }
    }
}
