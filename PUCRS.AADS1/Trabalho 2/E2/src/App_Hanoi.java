import java.util.Scanner;

public class App_Hanoi{

    public static void main(String[] args)
    {   Hanoi jogo;
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o tamanho desejado para começar o Hanoi:  (Min. 3)");
        jogo = new Hanoi (in.nextInt());

        System.out.println("Seja Bem-Vindo ao Hanoi projetado por: Pércio Reinert  &  Matheus Hrymalak. \nEsperamos que goste.");
        while (!jogo.victoryTest())
        {
            System.out.println(jogo);

        }
    }
}
