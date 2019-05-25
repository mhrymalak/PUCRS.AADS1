public class Fifo
{
    private int[] data;
    private int last;
    private int first;
    private int total;

    public Fifo(int tam)
    {   if(tam < 1) data = new int[5];
        else data = new int[tam];
    }

    public boolean add (int element)
    {   if(last == total)

        data[last] =  element;

    }

}
