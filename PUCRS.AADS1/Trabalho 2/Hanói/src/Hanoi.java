import java.util.EmptyStackException;

public class Hanoi
{

    // == Private Class ==
    private class Node
    {
        public Integer element;
        public Node next;

        public Node(Integer element)
        {   this.element = element;
        }

    }
    private class Pilha
    {
        private Node first;
        private int tam;


        public Pilha(){}


        public void push(int n)
        {   Node aux = new Node(n);
            aux.next = first;
            first = aux;
            tam++;
        }
        public Node top (){ return first;}

        public int pop ()
        {   if(!isEmpty())
            {   int n = first.element;
                first = first.next;
                tam--;
                return n;
            }
             throw new EmptyStackException();
        }

        public boolean isEmpty() {  return(tam == 0); }

    }

    // == fields ==
    private Pilha left;
    private Pilha center;
    private Pilha right;
    private byte pinos;
    private int movimentos;

    // == constructors ==
    public Hanoi(byte size)
    {   if(size < 3) size = 3;
        else if(size > 7) size = 7;

        this.left   = new Pilha();
        this.center = new Pilha();
        this.right  = new Pilha();
        pinos = size;

        for (int i = size; i > 0; i--)left.push(i);
    }

    // == public methods ==

    public void move(byte origin, byte destination)
    {   if(origin != destination)
        {   switch (origin)
            {   case 1:
                    if(left.top() != null)
                    {   if      (destination == 2) pointer(left, center);
                        else if (destination == 3) pointer(left, right);
                        else jogadaInvalida();
                    }
                    else jogadaInvalida();
                  break;

                case 2:
                    if(center.top() != null)
                    {   if      (destination == 1) pointer(center, left);
                        else if (destination == 3) pointer(center, right);
                        else jogadaInvalida();
                    }
                    else jogadaInvalida();
                  break;

                case 3:
                    if(right.top() != null)
                    {   if      (destination == 1) pointer(right, left);
                        else if (destination == 2) pointer(right, center);
                        else jogadaInvalida();
                    }
                    else jogadaInvalida();
                   break;

                default: jogadaInvalida();

            }
        }
        else jogadaInvalida();
    }

    public boolean victoryTest() {
        if (left.isEmpty() && center.isEmpty() && !right.isEmpty())
        {   Integer i = right.pop();
            Node aux  = right.first;

            for (int j = 0; j < right.tam;j++)
            {   if (i < aux.element)
                {   i = right.pop();
                }
                else return false;
            }
            victorious();
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
       StringBuilder string = new StringBuilder();
       Node l = left.top(), c = center.top(), r = right.top();

        for(byte i = 1; i <= pinos; i++)
        {
            if (l != null)
            {   string.append(l.element);
                string.append(" \t");
                l = l.next;

            }
            else string.append("| \t");


            if (c != null)
            {   string.append(c.element);
                string.append(" \t");
                c = c.next;
            }
            else string.append("| \t");


            if (r != null)
            {   string.append(r.element);
                string.append(" \t");
                r = r.next;
            }
            else string.append("| \t");

            string.append("\n");
        }
        string.append("---------- ");
        string.append("\nA\tB\tC\t \n");
        string.append("Movimentos: ");
        string.append(movimentos);
        return string.toString();
    }

     // == Private Methods ==
    private boolean pieceTest(Pilha origin, Pilha destination)
    {   if(destination.top() != null) return destination.top().element - origin.top().element > 0;
        return true;
    }

    private void pointer(Pilha origin, Pilha destination)
    {   if (pieceTest(origin, destination))
        { destination.push(origin.pop());
          movimentos++;
        }
        else jogadaInvalida();
    }


    private void victorious()    { System.out.println("\n\nParabéns! Você venceu o Hanói!\nMovimentos: "+movimentos); }

    private void jogadaInvalida(){ System.out.println("Jogada não permitida. Escolha novamente.");}
}
