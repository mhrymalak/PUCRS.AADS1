public class LinkedListOfInteger
{   // == Fields ==
    private Node head;
    private Node tail;
    private int count;

    // == Public Methods ==
    public LinkedListOfInteger()
    {   head = new Node();
        tail = new Node();
        head.next = tail;
        count = 0;
    }

    public LinkedListOfInteger(Integer element)
    {   head = new Node();
        tail = new Node();
        Node aux = new Node (element);
        head.next = aux;
        aux.next  = tail;
        count = 1;
    }

    public void add (Integer element)
    {   Node aux = new Node (element);
        Node xua = head.next;
        while(xua.next != tail)xua = xua.next;
        xua.next = aux;
        aux.next = tail;
        count++;
    }

    public boolean addIndex (int index, Integer element)
    {   if(index < count)
        {   Node node = new Node(element);
            Node aux = head;
            for(int i = 0; i < index; i++) aux = aux.next;
            node.next = aux.next;
            aux.next = node;
            count++;
            return true;
        }
        else if(index == count)
        {   add(element);
            return true;
        }
        return false;
    }

    public boolean remove (Integer element)
    {   Node aux = head;
        while (!aux.next.equals(tail))
        {   aux = aux.next;
            if(aux.element.equals(element))
            {   count--;

                return true;
            }
        }
        return false;

    }
    public boolean removeIndex (int index)
    {   if(index < count)
        {   if(index == 0)head.next = head.next.next;
            else
            {   Node aux = head;
                for (int i = 0; i < index; i++) aux = aux.next;
                aux.next = aux.next.next;
            }
            count--;
            return true;
        }
        return false;
    }
    public String toString()
    {   StringBuilder string = new StringBuilder();
        Node aux = head.next;
        for (int i = 0; i < count; i++)
        {   string.append("Posição: ");
            string.append(i);
            string.append("    Número: ");
            string.append(aux.element);
            string.append("\n");
            aux = aux.next;
        }
        return string.toString();
    }
    public int size(){ return count;}
}
