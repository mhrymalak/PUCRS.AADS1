import java.util.EmptyStackException;

public class Pilha {

    /**
     * Criação da classe Nodo interna para
     * controle da pilha encadeada
     */
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
    }

    private int tam;
    private Node top;

    /**
     * Construtor da Pilha
     */
    public Pilha() {
        tam = 0;
        top = null;
    }

    /**
     * Adiciona um novo elemento no topo da pilha
     *
     * @param e
     */
    public void push(int e) {
        Node n = new Node(e);
        n.next = top;
        top = n;
        tam++;
    }

    /**
     * Verifica se a pilha está vazia
     *
     * @return true se a pilha estiver vazia
     * @return false se a pilha tiver ao menos um elemento
     */
    public boolean isEmpty() {
        return (tam == 0);
    }

    /**
     * Método que retira o elemento do topo da lista
     *
     * @return elemento removido
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int e = top.element;
        top = top.next;
        tam--;
        return e;
    }

    /**
     * Verifica o tamanho da pilha
     *
     * @return tamanho da pilha
     */
    public int size() {
        return tam;
    }

    /**
     * Verifica qual é o elemento no topo da lista
     *
     * @return elemento do topo da lista sem removê-lo
     */
    public int peek() {
        return top.element;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = top;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    /**
     * Método que exibe as três torres de acordo com as suas quantidades de elementos
     *
     * @param pilha1
     * @param pilha2
     * @param pilha3
     * @param quantidadePinos
     *
     * @return texto com a estrutura da Torre de Hanoi
     */
    public String retornaTorres(Pilha pilha1, Pilha pilha2, Pilha pilha3, int quantidadePinos) {
        StringBuilder s = new StringBuilder();
        // === Vetores que armazenam itens desempilhadados para exibição ===
        int[] aux1 = new int[pilha1.size()];
        int[] aux2 = new int[pilha2.size()];
        int[] aux3 = new int[pilha3.size()];

        // == Indice de controle dos vetores ==
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        s.append("\n");
        // Lista os elementos de acordo com a quantidade de pinos selecionada inicialmente pelo jogador
        while (quantidadePinos > 0) {
            //Só lista o elemento da pilha se ela não estiver vazia e
            //lista o elemento de acordo com a ordem de listagem para que pilhas que possuam um único elemento
            //não o tenham listado no topo da torre enquanto deveriam estar na base
            if (!pilha1.isEmpty() && quantidadePinos == pilha1.size()) {
                aux1[count1] = pilha1.pop();
                s.append(aux1[count1]+" \t");
                count1++;

            //Se estiver vazia ou o elemento listado não estiver na posição que está sendo listada,
            //inclui estrutura da torre
            } else {
                s.append("| \t");
            }

            // === Lista torre 2 ===
            if (!pilha2.isEmpty() && quantidadePinos == pilha2.size()) {
                aux2[count2] = pilha2.pop();
                s.append(aux2[count2]+" \t");
                count2++;
            } else {
                s.append("| \t");
            }

            // === Lista torre 3 ===
            if (!pilha3.isEmpty() && quantidadePinos == pilha3.size()) {
                aux3[count3] = pilha3.pop();
                s.append(aux3[count3]+" \t");
                count3++;
            } else {
                s.append("| \t");
            }

            s.append("\n");
            quantidadePinos--;
        }
        s.append("---------- ");
        s.append("\n A\t B\t C\t \n");

        /*Como os elementos das pilhas foram removidos para serem exibidos,
        é necessário realocá-los nas pilhas novamente: */
        atualizaPilhas(aux1, pilha1);
        atualizaPilhas(aux2, pilha2);
        atualizaPilhas(aux3, pilha3);

        return s.toString();
    }


    /**
     * Método auxiliar ao de exibição que realoca os elementos das pilhas na ordem correta
     * @param aux - vetor com os elementos da pilha que foram exibidos em tela
     * @param pilha - pilha que foi esvaziada para exibição
     */
    public void atualizaPilhas(int[] aux, Pilha pilha) {
            if (aux != null) {
                for (int i = aux.length - 1; i >= 0; i--) {
                    pilha.push(aux[i]);
                }
            }
        }


    /**
     * Método que verifica se a jogada é válida e altera a posição do pino
     *
     * @param pilhaOrigem
     * @param pilhaDestino
     *
     * @return true se a alteração foi realizada
     * @return false se a alteração não foi realizada por ser uma jogada inválida
     */
        public boolean alteraPosicao(Pilha pilhaOrigem, Pilha pilhaDestino) {
            if (pilhaDestino.isEmpty()) {
                pilhaDestino.push(pilhaOrigem.pop());
            } else {
                if (pilhaDestino.peek() < pilhaOrigem.peek()) {
                    return false;
                } else {
                    pilhaDestino.push(pilhaOrigem.pop());
                }
            }
            return true;
        }
}
