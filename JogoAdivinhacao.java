import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numeroComputador = random.nextInt(101);
        int tentativasMaximas = 10;
        boolean acertou = false;

    
        clearScreen();

    
        System.out.println("Bem-vindo ao meu Jogo de Adivinhação!");
        System.out.println("Eu escolhi um número entre 0 e 100. Tente-me Adivinhar!");

    
        System.out.println("Pressione Enter para começar...");
        scanner.nextLine();
    
        clearScreen();

    
        for (int tentativas = 1; tentativas <= tentativasMaximas; tentativas++) {
            System.out.println("Tentativa " + tentativas + " de " + tentativasMaximas + ".");
            System.out.print("Digite seu palpite: ");
            int palpiteJogador = scanner.nextInt();

            if (palpiteJogador == numeroComputador) {
                acertou = true;
                System.out.println("Boaaaa! Você acertou o meu número " + numeroComputador + " em " + tentativas + " tentativas.");
                break;
            } else if (palpiteJogador > numeroComputador) {
                System.out.println("O número sorteado é menor que " + palpiteJogador + ".");
            } else {
                System.out.println("O número sorteado é maior que " + palpiteJogador + ".");
            }
        }
        

        if (!acertou) {
            System.out.println("Errouu! Você não conseguiu adivinhar o meu número. O meu número certo era " + numeroComputador + ".");
        }

        scanner.close();
    }
}