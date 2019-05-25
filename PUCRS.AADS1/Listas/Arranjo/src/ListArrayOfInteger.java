public class ListArrayOfInteger
{
    private Integer[] lista;
    private int count;

    public LinkedListOfInteger()
    {  lista = new Integer[10];
    }
    public LinkedListOfInteger(int tam)
    {  if(tam < 1)lista = new Integer[tam];
       else       lista = new Integer[10];
    }

    public void add(Integer element)
    {   if(lista.length == count)setCapacity(lista.length * 2);

    }
    public void addIndex(int index, Integer element){lista.add(index,element);}
    public void addFirst(Integer element)
    {

    }

    public boolean remove (Integer element)
    {   if(lista.remove(element))
        {   if(lista.size() % 4 == 0)dividirArranjo();
            return true;
        }
        return false;
    }
    private void setCapacity(int nCapacity)
    {

    }

    private void dividirArranjo()
    {  for(int i = lista.size() - 1; i >= lista.size() / 2; i--)lista.remove(i);
    }
}
