package application;

import java.util.Scanner;

import entities.FabricaMecanicaDoJogo;
import entities.MecanicaDoJogo;

public class Principal {
    public static void main(String[] args) {
        FabricaMecanicaDoJogo fabricaMecanicaDoJogo = new FabricaMecanicaDoJogo();
        MecanicaDoJogo mecanicaDoJogo = fabricaMecanicaDoJogo.getMecanicaDoJogo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo de Palavras Embaralhadas!");
        System.out.println("Para sair a qualquer momento, digite 'sair'.\n");

        while (!mecanicaDoJogo.jogoAcabou()) {
            String palavraEmbaralhada = mecanicaDoJogo.getPalavraEmbaralhada();
            System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
            System.out.print("Tentativa: ");
            String tentativa = scanner.nextLine().trim();

            if (tentativa.equalsIgnoreCase("sair")) {
                System.out.println("Você saiu do jogo.");
                break;
            }

            if (mecanicaDoJogo.verificarTentativa(tentativa)) {
                System.out.println("Parabéns! Você acertou!\n");
            } else {
                System.out.println("Tentativa incorreta. Tente novamente.\n");
            }
        }

        System.out.println("Fim do jogo!");
        System.out.println("Pontuação final: " + mecanicaDoJogo.getPontuacaoFinal());

        scanner.close();
    }
}
