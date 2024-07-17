package entities;

import java.util.Random;

public class EmbaralhadorAleatorio implements Embaralhador {
    @Override
    public String embaralhar(String palavra) {
        Random random = new Random();
        char[] chars = palavra.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}