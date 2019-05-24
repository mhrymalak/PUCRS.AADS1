import java.util.EmptyStackException;

public class Hanoi
{
    private class Node
    {    // == Private Class ==
        public Integer element;
        public Node next;

        public Node(Integer element)
        {   this.element = element;
        }

    }
    private class Pilha
    {   // == Fields ==
        private int tam;
        private Node first;

        // == Constructor ==
        public Pilha(int tam) {   this.tam = tam; }

        // == Public Methods ==

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
        public int size()  {  return tam;}

        public boolean isEmpty() {  if(tam == 0)return true; return false;}

    }
    // == fields ==
    private Pilha left;
    private Pilha center;
    private Pilha right;
    private int pinos;
    // == constructors ==
    public Hanoi(int size)
    {   if(size < 3) size = 3;

        this.left   = new Pilha(size);
        this.center = new Pilha(size);
        this.right  = new Pilha(size);
        pinos = size;

        for (int i = 1; i <= size; i++)left.push(i);
    }

    // == public methods ==


    public void push(int n, byte a)
    {   switch (a)
        {   case 1: left.push  (n); break;
            case 2: center.push(n); break;
            case 3: right.push (n); break;
            default: System.out.println("Jogada não permitida. Escolha novamente.");
        }

    }

    public int pop(byte a)
    {   switch (a)
        {   case 1:
                if (!left.isEmpty())   return left.pop();
                break;
            case 2:
                if (!center.isEmpty()) return center.pop();
                break;
            case 3:
                if (!right.isEmpty())  return right.pop();
                break;
        }
        System.out.println("Jogada não permitida. Escolha novamente.");
        return 0;
    }



    public void move(int origin, int destination)
    {   switch (origin)
        {   case 1: pointer(origin, destination);
                break;
            case 2: pointer(origin, destination);
                break;
            case 3: pointer(origin, destination);
                break;
        }
    }

    public boolean victoryTest() {
        if (left.isEmpty() && center.isEmpty())
        {   Integer i = right.pop();
            Node aux  = right.first;

            for (int j = 0; j < right.tam;j++)
            {   if (i < aux.element)
                {   i = right.pop();
                }
                else return false;
            }
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
       StringBuilder string = new StringBuilder();
       string.append("\f");
       Node aux;
        for(byte i = 1; i <= pinos; i++)
        {   //Só lista o elemento da pilha se ela não estiver vazia e
            //lista o elemento de acordo com a ordem de listagem para que pilhas que possuam um único elemento
            //não o tenham listado no topo da torre enquanto deveriam estar na base
            if (!left.isEmpty() && pinos == left.size())
            {   aux = left.top();
                string.append(aux.element+" \t");
                aux = aux.next;

                //Se estiver vazia ou o elemento listado não estiver na posição que está sendo listada,
                //inclui estrutura da torre
            }
            else string.append("| \t");

            // === Lista torre 2 ===
            if (!center.isEmpty() && pinos == center.size())
            {   aux = center.top();
                string.append(aux.element+" \t");
                aux = aux.next;
            }
            else string.append("| \t");


            // === Lista torre 3 ===
            if (!right.isEmpty() && pinos == right.size())
            {   aux = right.top();
                string.append(aux.element+" \t");
                aux = aux.next;
            }
            else string.append("| \t");


            string.append("\n");
            pinos--;
        }
        string.append("---------- ");
        string.append("\n A\t B\t C\t \n");

        return string.toString();
    }

     //== private methods
    private boolean moveTest(int origin, int destination)
    { if(origin == 1 || origin == 2 || origin == 3 && destination != origin) return pieceTest(origin, destination);
        return false;
    }

    private boolean pieceTest(int origin, int destination)
    {   switch (origin)
        {   case 1: if (destination == 2)
                        return left.top().element < center.top().element;
                    else if (destination == 3)
                        return left.top().element < right.top().element;

                break;

            case 2: if (destination == 1)
                        return center.top().element < left.top().element;
                    else if (destination == 3)
                        return center.top().element < right.top().element;
                break;

            case 3: if (destination == 2)
                        return right.top().element < center.top().element;
                    else if (destination == 1)
                        return right.top().element < left.top().element;
                break;
        }
        return false;
    }

    private void pointer(int origin, int destination)
    {   if (moveTest(origin, destination))
        {   if (destination == 2)
            {   center.push(left.pop());
                if (victoryTest()) victorious();
            }
            else if (destination == 3)
            {   right.push(left.pop());
                if (victoryTest()) victorious();
            }
        }
        else System.out.println("Jogada não permitida. Escolha novamente.");
    }


    private void victorious() {
        System.out.println(toString());
        System.out.println("Parabéns! Você venceu o Hanói!");
    }


}
