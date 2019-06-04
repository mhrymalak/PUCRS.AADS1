import java.util.Scanner;

public class App_Hanoi{

    public static void main(String[] args)
    {   Hanoi jogo; byte origem, destino;
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o tamanho desejado para começar o Hanói (Min. 3| Max. 7): ");
        origem = in.nextByte();
        jogo = new Hanoi (origem);

        System.out.println("\n\nSeja Bem-Vindo ao Hanói projetado por: Pércio Reinert  &  Matheus Hrymalak. \nDirija os números nessa ordem para pilha da direita    \nEsperamos que goste.");
        while (!jogo.victoryTest())
        {   System.out.println("\n"+jogo);
            System.out.print("Digite o número de 1 a 3 da coluna de origem:  ");
            origem = in.nextByte();
            System.out.print("Digite o número de 1 a 3 da coluna de destino: ");
            destino = in.nextByte();
            jogo.move(origem,destino);
        }
    }
}
