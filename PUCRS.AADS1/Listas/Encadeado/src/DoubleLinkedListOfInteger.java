class Node
{   // == Fields ==
    public Integer element;
    public Node prev;
    public Node next;

    // == Constructor ==
    public Node(){}
    //Sobrecar ga
    public Node(Integer element){ this.element = element;}
}
public class DoubleLinkedListOfInteger
{   // == Fields ==
    private Node header;
    private Node trailer;
    private int  count;

    // == Methods ==
    public DoubleLinkedListOfInteger ()
    {   header   = new Node();
        trailer  = new Node();
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
    // Sobrecarga
    public DoubleLinkedListOfInteger (Integer element)
    {   Node aux = new Node(element);
        header   = new Node();
        trailer  = new Node();
        header.next  = aux;
        trailer.prev = aux;
        aux.prev = header;
        aux.next = trailer;
        count = 1;
    }

    public void add (Integer element)
    {   Node aux = new Node (element);
        aux.next = trailer;
        aux.prev = trailer.prev;
        trailer.prev.next = aux;
        trailer.prev = aux;
        count++;
    }

    public boolean addIndex (int index, Integer element)
    {   if(index <= count)
        {   Node node = new Node(element);
            Node aux = header;
            for(int i = 0; i <= index; i++) aux = aux.next;
            node.prev = aux.prev;
            node.next = aux;
            aux.prev.next = node;
            count++;
            return true;
        }
        return false;
    }

    public boolean remove (Integer element)
    {   Node aux = header;
        for(int i = 1;i <= count; i++)
        {   aux = aux.next;
            if(aux.element.equals(element))
            {   aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
        }
        return false;

    }
    public boolean removeIndex (int index)
    {   if(index < count)
        {   if(index == 0)
            {   header.next.next.prev = header;
                header.next = header.next.next;
            }
            else if(index == count - 1)
            {   trailer.prev.prev.next = trailer;
                trailer.prev = trailer.prev.prev;
            }
            else
            {   Node aux = header;
                for (int i = 1; i <= index; i++) aux = aux.next;
                aux.next.next.prev = aux;
                aux.next = aux.next.next;
            }
            count--;
            return true;
        }
        return false;
    }
    public int size(){ return count;}
    public String toString()
    {   StringBuilder string = new StringBuilder();
        Node aux = header.next;
        for (int i = 1; i <= count; i++)
        {   string.append("Posição: ");
            string.append(i);
            string.append("    Número: ");
            string.append(aux.element);
            string.append("\n");
            aux = aux.next;
        }
        return string.toString();
    }
}
