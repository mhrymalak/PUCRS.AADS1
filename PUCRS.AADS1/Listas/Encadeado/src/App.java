public class App
{   public static void main(String[] args)
    {   /*DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger(2);

        lista.add(4);
        lista.add(2);
        lista.add(7);
        lista.add(1);
        lista.add(9);
        System.out.println(lista.size());
        if(lista.addIndex(3,3)) System.out.println(lista.toString());

        lista.remove(1);
        System.out.println(lista.size());
        System.out.println(lista.toString());*/

       /* LinkedListOfInteger lista = new LinkedListOfInteger(2);

        lista.add(4);
        lista.add(2);
        lista.add(7);
        lista.add(1);
        lista.add(9);
        if(lista.addIndex(3,3)) System.out.println(lista.toString());
        if(lista.remove(9))System.out.println(lista.toString());*/

        ListArrayOfInteger lista = new ListArrayOfInteger();

        lista.add(4);
        lista.add(2);
        lista.add(7);
        lista.add(1);
        lista.add(9);
        lista.addIndex(3,3);
        System.out.println(lista.toString());
        if(lista.remove(9))System.out.println(lista.toString());
    }

}