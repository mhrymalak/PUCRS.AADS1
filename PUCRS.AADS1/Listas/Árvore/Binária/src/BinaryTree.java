public class BinaryTree
{
    private class Node
    {   public Integer element;
        public Node    father;
        public Node    left;
        public Node    right;

        public Node (Integer element) {this.element = element;}
    }

    private Node root;
    private int count;

    public BinaryTree(){}
    public BinaryTree(Integer element) {addRoot(element);}

    public boolean addRoot(Integer element)
    {   if(root != null) return false;
        root = new Node (element);
        count++;
        return true;
    }
    public void  setRoot (Integer element){ if(element !=  null)root.element = element;}

    public void clear()
    {   count = 0;
        root  = null;
    }

    public boolean isEmpty() { return root == null; }

    public   int   size()    { return count; }

    public boolean hasLeft(Integer father)
    {   if(father != null) return false;
        Node aux = searchNodeRef(father, root);
        if(aux == null || aux.left == null) return false;
        return true;
    }

    public boolean hasRight(Integer father)
    {   if(father != null) return false;
        Node aux = searchNodeRef(father, root);
        if(aux == null || aux.right == null) return false;
        return true;
    }

    public boolean addLeft (Integer father, Integer element)
    {   if(element !=  null || father != null) return false;
        Node aux = searchNodeRef(father, root);
        if(aux == null) return false;
        aux.left = new Node(element);
        aux.left.father = aux;
        count++;
        return true;
    }

    public boolean addRight(Integer father, Integer element)
    {   if(element !=  null || father != null) return false;
        Node aux = searchNodeRef(father, root);
        if(aux == null) return false;
        aux.right = new Node(element);
        aux.right.father = aux;
        count++;
        return true;
    }
    public boolean isExternal(int element)
    {   Node n = searchNodeRef(element, root);
        if (n != null)
        {   if (n.left == null && n.right == null)
                return true;
        }
        return false;
    }

    public boolean isInternal(int element)
    {   Node n = searchNodeRef(element, root);
        if (n != null)
        {   if (n.left != null || n.right != null)
                return true;
        }
        return false;
    }
    private Node searchNodeRef(Integer element, Node target)
    {  Node aux = null;
       if(target != null || element != null)
       {    if (target.element.equals(element)) aux = target;
            else
            {   aux = searchNodeRef(element, target.left);
                if(aux == null)
                    aux = searchNodeRef(element,target.right);
            }
       }
        return aux;
    }

}