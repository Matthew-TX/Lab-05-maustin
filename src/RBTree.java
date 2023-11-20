public class RBTree {
    Node nil = null;
    Node root = null;
    String red = "red";
    String black = "black";

    public void Insert(Integer zKey){
        Node z = new Node();
        z.setKey(zKey);
        Node y = nil;
        Node x = root;
        while(x!=nil){
            y = x;
            if(z.getKey() < x.getKey()){
                x = x.getLeftChild();
            }
            else{
                x = x.getRightChild();
            }
        }
        z.setParent(y);
        if (y == nil){
            root = z;
        }
        else if (z.getKey() < y.getKey()){
            y.setLeftChild(z);
        }
        else{
            y.setRightChild(z);
        }
        z.setLeftChild(nil);
        z.setRightChild(nil);
        z.setColor(red);
    }

    public void InsertFixUp (Node z){

    }

    public void leftRotate(Node x){
        Node y = x.getRightChild();
        x.setRightChild(y.getLeftChild());
        if (y.getLeftChild() != nil){
            y.getLeftChild().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getLeftChild()){
            x.getParent().setLeftChild(y);
        }
        else {
            x.getParent().setRightChild(y);
        }
        y.setLeftChild(x);
        x.setParent(y);
    }

    public void rightRotate(Node x){
        Node y = x.getLeftChild();
        x.setLeftChild(y.getRightChild());
        if (y.getRightChild() != nil){
            y.getRightChild().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getRightChild()){
            x.getParent().setRightChild(y);
        }
        else {
            x.getParent().setLeftChild(y);
        }
        y.setRightChild(x);
        x.setParent(y);
    }

    public void fixup(Node z){
        while (z.getParent().getColor().equals(red)){
            if(z.getParent() == z.getParent().getParent().getLeftChild()){
                Node y = z.getParent().getParent().getRightChild();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if ( z == z.getParent().getRightChild()){
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().setColor(black);
                    z.getParent().getParent().setColor(red);
                    rightRotate(z.getParent().getParent());
                }
            }
            else{
                Node y = z.getParent().getParent().getLeftChild();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if (z == z.getParent().getLeftChild()){
                        z = z.getParent();
                        rightRotate(z);
                    }
                    z.getParent().setColor(black);
                    z.getParent().getParent().setColor(red);
                    leftRotate(z.getParent().getParent());
                }
            }
        }
        root.setColor(black);
    }

}
