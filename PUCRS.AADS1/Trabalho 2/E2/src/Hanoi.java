import java.util.EmptyStackException;

public class Hanoi {

   // == private class ==
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
    }

    // == fields ==
    private Hanoi left;
    private Hanoi center;
    private Hanoi right;
    private int tam;
    private Node top;

    // == constructors ==
    public Hanoi(int size)
    {   if(size < 1) size = 1;

        this.left   = new Hanoi(size);
        this.center = new Hanoi(size);
        this.right  = new Hanoi(size);

        left.tam   = size;
        center.tam = size;
        right.tam  = size;

        for (int i = 1; i <= size; i++) left.push(i);
    }

    // == public methods ==


    public void push(int n)
    {   Node aux = new Node(n);
        aux.next = top;
        top = aux;
        tam++;
    }

    public int pop()
    {   if (!isEmpty())
        {   int n = top.element;
            top = top.next;
            tam--;
            return n;
        }
        else throw new EmptyStackException();
    }

    public boolean isEmpty() { return (tam == 0); }


    public void move(int origin, int destination) {
        switch (origin) {
            case 1: if (moveTest(origin, destination)) {
                        if (destination == 2) {
                            center.push(left.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        } else if (destination == 3) {
                            right.push(left.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        }
                    } else {
                        System.out.println("Jogada não permitida. Escolha novamente.");
                    }
                break;
            case 2: if (moveTest(origin, destination)) {
                        if (destination == 1) {
                            left.push(center.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        } else if (destination == 3) {
                            right.push(center.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        }
                    } else {
                        System.out.println("Jogada não permitida. Escolha novamente.");
                    }
                break;
            case 3: if (moveTest(origin, destination)) {
                        if (destination == 2) {
                            center.push(right.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        } else if (destination == 1) {
                            left.push(right.pop());
                            if (victoryTest()) {
                                victorious();
                            }
                        }
                    } else {
                        System.out.println("Jogada não permitida. Escolha novamente.");
                    }
                break;
        }
    }

    private boolean moveTest(int origin, int destination) {
        switch (origin) {
            case 1: if (destination == 1) return false;
                    else if (destination == 2) return pieceTest(origin, destination);
                    else if (destination == 3) return pieceTest(origin, destination);

                 break;
            case 2: if (destination == 1) return pieceTest(origin, destination);
                    else if (destination == 2) return false;
                    else if (destination == 3) return pieceTest(origin, destination);
                 break;
            case 3: if (destination == 1) return pieceTest(origin, destination);
                    else if (destination == 2) return pieceTest(origin, destination);
                    else if (destination == 3) return false;
                 break;
        }
        return false;
    }

    private boolean pieceTest(int origin, int destination) {
        switch (origin) {
            case 1: if (destination == 2) {
                        return left.top.element < center.top.element;
                    } else if (destination == 3) {
                        return left.top.element < right.top.element;
                    }
                break;
            case 2: if (destination == 1) {
                        return center.top.element < left.top.element;
                    } else if (destination == 3) {
                        return center.top.element < right.top.element;
                    }
                break;
            case 3: if (destination == 2) {
                        return right.top.element < center.top.element;
                    } else if (destination == 1) {
                        return right.top.element < left.top.element;
                    }
                break;
        }
        return false;
    }

    private boolean victoryTest() {
        if (left.isEmpty() && center.isEmpty())
        {   Integer i = right.pop();
            Node aux  = right.top;

            for (int j = 0; i < right.tam;i++)
            {   if (i < aux.element)
                {   i = right.pop();
                }
                else return false;
            }
            return true;
        }
        return false;
    }

    private void victorious() {
        System.out.println(toString());
        System.out.println("Parabéns! Você venceu o Hanói!");
    }

    @Override
    public String toString() {
        return "Hanoi{}";
    }
}
