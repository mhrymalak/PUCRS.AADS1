import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // == Solicita quantidade de pinos da partida ==
        int quantidadePinos = 0;
        do {
            System.out.print("Informe a quantidade de pinos entre 3 e 7: ");
            quantidadePinos = in.nextInt();
        } while (quantidadePinos < 3 || quantidadePinos > 7);


        // == Cria as pilhas das três torres ==
        Pilha A = new Pilha();
        for (int i = quantidadePinos; i > 0; i--) {
            A.push(i);
        }

        Pilha B = new Pilha();
        Pilha C = new Pilha();
        //Cria pilha auxiliar para manipular as três pilhas
        Pilha aux = new Pilha();

        //Exibe em tela a estrutura inicial das torres:
        System.out.print(aux.retornaTorres(A, B, C, quantidadePinos));

        //Variavel para controle do número de movimentos realizados pelo jogador
        int quantidadeMovimentos = 1;

        // == Solicita a troca de colunas até que todos os pinos estejam na última coluna de forma correta ==
        while (C.size() != quantidadePinos) {
            String colunaOrigem;
            do {
                System.out.print("\nInforme a coluna que você deseja alterar a posição do elemento superior: ");
                colunaOrigem = in.next();
                colunaOrigem = colunaOrigem.toUpperCase();
            } while (colunaOrigem.compareTo("A") == 1 && colunaOrigem.compareTo("B") == 1 && colunaOrigem.compareTo("C") == 1);

            String colunaDestino;
            do {
                System.out.print("\nInforme a coluna para onde deseja mover o pino: ");
                colunaDestino = in.next();
                colunaDestino = colunaDestino.toUpperCase();
            } while ((colunaDestino.compareTo("A") == 1 && colunaDestino.compareTo("B") == 1 && colunaDestino.compareTo("C") == 1) && colunaDestino.compareTo(colunaOrigem) == 0);

            // == Chama o método de alteração das posições de acordo com as opções selecionadas ==
            if (colunaOrigem.compareTo("A") == 0 && colunaDestino.compareTo("C") == 0) {
                if (!aux.alteraPosicao(A, C)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            } else if (colunaOrigem.compareTo("A") == 0 && colunaDestino.compareTo("B") == 0) {
                if (!aux.alteraPosicao(A, B)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            }

            if (colunaOrigem.compareTo("B") == 0 && colunaDestino.compareTo("A") == 0) {
                if (!aux.alteraPosicao(B, A)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            } else if (colunaOrigem.compareTo("B") == 0 && colunaDestino.compareTo("C") == 0) {
                if (!aux.alteraPosicao(B, C)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            }

            if (colunaOrigem.compareTo("C") == 0 && colunaDestino.compareTo("A") == 0) {
                if (!aux.alteraPosicao(C, A)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            } else if (colunaOrigem.compareTo("C") == 0 && colunaDestino.compareTo("B") == 0) {
                if (!aux.alteraPosicao(C, B)) {
                    System.out.println(" == Jogada inválida! == \n Tente novamente.");
                }
            }

            //Após a alteração das posições, exibe situação atual dos pinos:
            System.out.println(aux.retornaTorres(A, B, C, quantidadePinos));
            System.out.println("Quantidade de movimentos realizados até o momento: " + quantidadeMovimentos);

            quantidadeMovimentos++;
        }

        //Quando todos os pinos estiverem na torre final, exibe alerta de partida encerrada:
        System.out.println(" === Parabéns! === \n você completou o desafio!");
    }
}
