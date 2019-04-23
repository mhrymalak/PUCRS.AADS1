class Node
{   // == Fields ==
    public Integer element;
    public Node prev;
    public Node next;

    // == Constructor ==
    public Node(){}
    //Sobrecarga
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
    {   if(index < 0 || index > count) return false;
        else
        {   if(index == count)
            {   add(element);
                return true;
            }
             else
             {   Node node = new Node(element);
                 Node aux;
                 if (count / 2 > index)
                 {  aux = header;
                    for (int i = 0; i <= index; i++) aux = aux.next;
                 }
                 else
                 {  aux = trailer;
                    for (int i = count; i >= index; i--) aux = aux.prev;
                 }
                    node.prev = aux.prev;
                    node.next = aux;
                    aux.prev.next = node;
                    aux.prev = node;
                    count++;
                    return true;
                }
        }
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
    {   if(index < 0 || index > count) return  false;
        else
        {   if(index == 0)
            {   header.next.next.prev = header;
                header.next = header.next.next ;
            }
            else if(index == count)
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
    }
    public int size(){ return count;}

    public Integer getElement (int index)
    {   if(index < 0 || index > count) throw new IndexOutOfBoundsException();
        else
        {   Node aux;
            if(count / 2 > index)
            {   aux = trailer;
                for(int i = count; i >= index;i--)aux = aux.prev;
            }
            else
            {   aux = header;
                for(int i = 0; i <= index;i++)aux = aux.next;
            }
            return aux.element;
        }

    }
    public boolean setElement (int index,Integer element)
    { if(index < 0 || index > count) return false;
        else
        {   Node aux;
            if(count / 2 > index)
            {   aux = trailer;
                for(int e = count; e >= index;e--)aux = aux.prev;
            }
            else
            {   aux = header;
                for(int e = 0; e <= index;e++)aux = aux.next;
            }
            aux.element = element;
            return true;
        }
    }

    public void reverse()
    {   Integer integer;
        Node aux = header.next, xua = trailer.prev;
        for(int i = 1; i <= count / 2; i++)
        {   integer = xua.element;
            xua.element = aux.element;
            aux.element = integer;

            aux = aux.next;
            xua = xua.prev;
        }
    }

    public void unique()
    {   Node xua = header.next, aux = xua.next;

        for(int i = 1;i <= count;i++) {
            for (int e = 1; e <= count; e++)
            {    if (xua.element == aux.element)
                {   aux.next.prev = xua;

                }
                aux = aux.next;
            }
            xua = xua.next;
        }
    }

    public String gnirtSot()
    {   StringBuilder string = new StringBuilder();
        Node aux = trailer.next;
        for (int i = count; i <= 1; i--)
        {   string.append("Posição: ");
            string.append(i);
            string.append("    Número: ");
            string.append(aux.element);
            string.append("\n");
            aux = aux.prev;
        }
        return string.toString();
    }

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
