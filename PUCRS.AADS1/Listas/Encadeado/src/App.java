public class App1
{   public static void main(String[] args)
    {   DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger(2);

        lista.add(4);
        lista.add(2);
        lista.add(7);
        lista.add(1);
        lista.add(9);
        System.out.println(lista.size());
        if(lista.addIndex(3,3)) System.out.println(lista.toString());

        System.out.println(lista.getElement(2));


    }

}